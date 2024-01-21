package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.annotations.Interactor;
import com.dagy.cafeheroapi.core.constants.enums.Template;
import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductCategoryService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductCategoryUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import java.util.stream.Collectors;

import static com.dagy.cafeheroapi.core.constants.Exception.RECORD_NOT_FOUND;
import static com.dagy.cafeheroapi.core.constants.Exception.REQUIRED_ID;
import static com.dagy.cafeheroapi.core.constants.ReportConstant.UNEXPECTED_FILE_TYPE;
import static com.dagy.cafeheroapi.core.constants.enums.FileType.EXCEL;
import static com.dagy.cafeheroapi.core.utils.files.FileUtil.isFileType;
import static com.dagy.cafeheroapi.core.utils.files.FileUtil.writeProductScrapContentToFile;
import static java.lang.String.format;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
//@Interactor
@Service
@RequiredArgsConstructor
public class ProductCategoryService implements IProductCategoryService, Mapper<ProductCategoryRequest, ProductCategory> {
    public static final String REQUIRE_CATEGORY_ID = "Product category ID is required";
    private static final String FAILED_TO_DELETE = "UNABLE TO DELETE, THIS ITEM IS CURRENTLY IN USE";
    private final IProductCategoryUsecase usecase;
    private final ModelMapper mapper;
    @Override
    public ResponseEntity<ProductCategoryRequest> find(Long id) {
        Optional<ProductCategory> optional = this.usecase.findOne(id);
        return optional.map(category -> ok(toRequest(category))).orElse(notFound().build());
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> findMany() {
        List<ProductCategory> all = this.usecase.findAll();
        List<ProductCategoryRequest> collect = all.stream().map(this::toRequest).collect(Collectors.toList());
        return ok().body(collect);
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> save(ProductCategoryRequest request) {
        var model = toModel(request);
        Optional<ProductCategory> category = this.usecase.save(model);
        return ok().body(category.map(this::toRequest));
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> update(ProductCategoryRequest request) {

        this.throwIfRequestNotValid(request);
        return this.save(request);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        Optional<Boolean> optional = this.usecase.remove(id);

        return ok().body(optional.map(value -> {
            if (!value) {
                throw new ResponseStatusException(BAD_REQUEST, FAILED_TO_DELETE);
            }
            return value;
        }));
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> search(String term) {
        if (term.isEmpty()) {
            return ok().body(new ArrayList<>());
        }

        List<ProductCategory> categories = this.usecase.search(term);
        List<ProductCategoryRequest> requests = categories.stream().map(this::toRequest).collect(Collectors.toList());
        return new ResponseEntity<>(requests, OK);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id) {
        Optional<ProductCategory> optional = this.usecase.findOne(id);
        return ok().body(optional.map(value -> this.usecase.toggleStatus(!value.getIsActiveStatus(), value.getId())));
    }

    @Override
    public ResponseEntity<Resource> downloadTemplate() throws IOException {
        Resource resource = this.usecase.downloadTemplate(Template.PRODUCT_CATEGORY_UPLOAD);
        Path path = resource.getFile().toPath();
        return ok().header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @Override
    public ResponseEntity<?> uploadTemplate(MultipartFile file) {
        if (!isFileType(file, EXCEL)) {
            throw new ResponseStatusException(BAD_REQUEST, format(UNEXPECTED_FILE_TYPE, EXCEL.extension()));
        }

        Map<String, String> map = this.usecase.uploadTemplate(file);

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
    public ProductCategoryRequest toRequest(ProductCategory model) {
        return mapper.map(model, ProductCategoryRequest.class);
    }

    @Override
    public ProductCategory toModel(ProductCategoryRequest request) {
        return mapper.map(request, ProductCategory.class);
    }


    private void throwIfRequestNotValid(ProductCategoryRequest request) {
        if (isEmpty(request.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, REQUIRED_ID);
        }

        if (!this.find(request.getId()).getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
        }
    }
}
