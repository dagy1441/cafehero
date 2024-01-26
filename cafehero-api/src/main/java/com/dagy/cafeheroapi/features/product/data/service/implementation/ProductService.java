package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.constants.enums.Template;
import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.core.params.pages.PageParam;
import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.product.data.request.*;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductBasicService;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductPriceService;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductService;
import com.dagy.cafeheroapi.features.product.domain.entity.*;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductUsecase;
import org.springframework.core.io.Resource;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.ReportConstant.UNEXPECTED_FILE_TYPE;
import static com.dagy.cafeheroapi.core.constants.enums.FileType.EXCEL;
import static com.dagy.cafeheroapi.core.params.pages.PageParam.toPageSearchResponse;
import static com.dagy.cafeheroapi.core.utils.files.FileUtil.isFileType;
import static com.dagy.cafeheroapi.core.utils.files.FileUtil.writeProductScrapContentToFile;
import static com.dagy.cafeheroapi.features.product.data.request.specification.ProductSearchSpecification.productSpecification;
import static com.dagy.cafeheroapi.features.product.data.request.specification.ProductSearchSpecification.salesProductSpecification;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
//@Interactor
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService, Mapper<ProductRequest, Product> {

    private final ModelMapper mapper;
    private final IProductUsecase productUsecase;
    private final IProductBasicService basicInteractor;
    private final IProductPriceService priceInteractor;
    @Override
    public ResponseEntity<ProductRequest> save(ProductRequest request) {
        if (isEmpty(request.getId())) {
            return this.create(request);
        } else {
            return this.update(request);
        }
    }

    @Transactional
    public ResponseEntity<ProductRequest> create(ProductRequest request) {
        ProductBasic basic = this.basicInteractor.save(request.getBasic());
        ProductPrice price = this.priceInteractor.save(request.getPrice());
        this.createNewProduct(basic, price, request);
        return ok().body(request);
    }

    private ResponseEntity<ProductRequest> update(ProductRequest request) {
        Optional<Product> optionalProduct = this.productUsecase.findById(request.getId());
        optionalProduct.map(product -> {
            this.updateBasicDetails(product.getBasic(), request.getBasic());
            this.updatePriceDetails(product.getPrice(), request.getPrice());
            request.setCreatedAt(product.getCreatedAt().toLocalDate().toString());
            return product;
        });

        return ok().body(request);
    }

    private void updateBasicDetails(ProductBasic model, ProductBasicRequest request) {
        model.setProductName(request.getProductName());
        model.setSku(request.getSku());
        model.setBarcode(request.getBarcode());
        model.setBrandName(request.getBrandName());
        model.setDescription(request.getDescription());
        model.setIsActive(request.getIsActive());
        model.setUseQuantity(request.getUseQuantity());
        model.setIsService(request.getIsService());
        model.setMinAgeLimit(request.getMinAgeLimit());
        model.setLowStockPoint(request.getLowStockPoint());
        model.setQuantity(model.getQuantity());
        model.setProductCategory(new ProductCategory(request.getProductCategory().getId()));
        model.setUnitOfMeasure(request.getUnitOfMeasure().toModel());
        model.setStatus(request.getStatus().toModel());
        model.setTaxes(request.getTaxes().stream().map(ProductTaxRequest::toModel).collect(toList()));
        request.setQuantity(model.getQuantity());
        this.basicInteractor.update(model);
    }

    private void updatePriceDetails(ProductPrice model, ProductPriceRequest request) {
        model.setMarkup(request.getMarkup());
        model.setCostPrice(request.getCostPrice());
        model.setSellingPrice(request.getSellingPrice());
        this.priceInteractor.update(model);
    }

    private void createNewProduct(ProductBasic basic, ProductPrice price, ProductRequest request) {
        try {
            Product product = Product.builder().basic(basic).price(price).build();
            Product savedProduct = this.productUsecase.save(product);

            request.setId(savedProduct.getId());
            request.setCreatedAt(savedProduct.getCreatedAt().toString());
            request.setIsActiveStatus(savedProduct.getIsActiveStatus());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> search(PageSearchRequest<ProductSearchRequest> request) {
        Page<Product> page = this.productUsecase.findMany(productSpecification(request.getSearchRequest()), request.getPage().toPageable());
        List<ProductRequest> requests = page.getContent().stream().map(this::toRequest).collect(toList());
        return ok().body(toPageSearchResponse(requests, page));
    }

    @Override
    public ResponseEntity<List<ProductRequest>> search(String term) {
        if (term.isEmpty()) {
            return ok().body(new ArrayList<>());
        }
        List<Product> list = this.productUsecase.findMany(productSpecification(term));
        List<ProductRequest> requests = list.stream().map(this::toRequest).collect(toList());
        return ok().body(requests);
    }

    @Override
    public ResponseEntity<Optional<ProductRequest>> setQuantity(Long productId, Integer quantity) {
        Optional<Product> optionalProduct = this.productUsecase.findById(productId);
        Optional<ProductRequest> optionalProductRequest = optionalProduct.map(product -> {
            ProductBasic basic = product.getBasic();
            basic.setQuantity(quantity);
            ProductBasic updatedBasic = this.basicInteractor.update(basic);
            product.setBasic(updatedBasic);
            return toRequest(product);
        });
        return ok().body(optionalProductRequest);
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProduct(PageSearchRequest<ProductSearchRequest> request) {
        Page<Product> page = this.productUsecase.findMany(salesProductSpecification(request.getSearchRequest()), request.getPage().toPageable());
        List<ProductRequest> requests = page.getContent().stream().map(this::toRequest).collect(toList());
        return ok().body(toPageSearchResponse(requests, page));
    }

    @Override
    public ResponseEntity<Boolean> setDiscount(ProductDiscountRequest discountRequest) {
        Optional<Product> optionalProduct = this.productUsecase.findById(discountRequest.getProductId());

        Boolean res = optionalProduct.map(
                product -> this.priceInteractor.applyDiscount(
                        product.getPrice(), discountRequest)).orElse(Boolean.FALSE);

        return ok().body(res);
    }

    @Override
    public ResponseEntity<?> uploadTemplate(MultipartFile file) {
        if (!isFileType(file, EXCEL)) {
            throw new ResponseStatusException(BAD_REQUEST, format(UNEXPECTED_FILE_TYPE, EXCEL.extension()));
        }

        Map<String, String> map = this.productUsecase.uploadTemplate(file);

        byte[] content = writeProductScrapContentToFile(map);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=scrap_file.txt");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(content.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(content);
    }

    @Override
    public ResponseEntity<Resource> downloadTemplate() throws IOException {
        Resource resource = this.productUsecase.downloadTemplate(Template.PRODUCT_UPLOAD);
        Path path = resource.getFile().toPath();
        return ok().header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @Override
    public ProductRequest toRequest(Product model) {
        return this.mapper.map(model, ProductRequest.class);
    }

    @Override
    public Product toModel(ProductRequest request) {
        return this.mapper.map(request, Product.class);
    }

    private ProductRequest mapToProductRequest(Product product) {
        ProductRequest request = this.toRequest(product);
        ProductUnitOfMeasureRequest unitOfMeasureRequest = new ProductUnitOfMeasureRequest();
        ProductUnitOfMeasure unitOfMeasure = product.getBasic().getUnitOfMeasure();
        unitOfMeasureRequest.setId(unitOfMeasure.getId());
        unitOfMeasureRequest.setTitle(unitOfMeasure.getTitle());
        unitOfMeasureRequest.setUnit(unitOfMeasure.getUnit());
        request.getBasic().setUnitOfMeasure(unitOfMeasureRequest);
        return request;
    }
}
