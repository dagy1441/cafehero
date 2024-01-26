package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductPriceRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductPriceService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductDiscountDuration;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductPriceUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static com.dagy.cafeheroapi.core.constants.Exception.VALIDATION_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
//@Interactor
@Service
@RequiredArgsConstructor
public class ProductPriceService implements IProductPriceService, Mapper<ProductPriceRequest, ProductPrice> {

    private final IProductPriceUsecase priceUsecase;
    private final ModelMapper mapper;

    @Override
    public ProductPrice save(ProductPriceRequest request) {
        ProductPrice model = this.toModel(request);
        return this.priceUsecase.save(model);
    }

    @Override
    public ProductPrice update(ProductPrice price) {
        return this.priceUsecase.save(price);
    }

    @Override
    public Boolean applyDiscount(ProductPrice price, ProductDiscountRequest request) {
        this.throwIfDiscountRequestNotValid(price, request);

        LocalDate start = LocalDate.parse(request.getStart());
        LocalDate end = LocalDate.parse(request.getEnd());
        price.setDiscount(request.getDiscount());
        this.update(price);

        ProductDiscountDuration duration = new ProductDiscountDuration(price.getId(), start, end);
        ProductDiscountDuration savedDuration = this.priceUsecase.updateDiscountDuration(duration);
        return savedDuration.getId() != null;
    }

    @Override
    public ProductPrice update(ProductPriceRequest price) {
        ProductPrice model = this.toModel(price);
        return this.update(model);
    }

    @Override
    public ProductPriceRequest toRequest(ProductPrice model) {
        return this.mapper.map(model, ProductPriceRequest.class);
    }

    @Override
    public ProductPrice toModel(ProductPriceRequest request) {
        return this.mapper.map(request, ProductPrice.class);
    }

    private void throwIfDiscountRequestNotValid(ProductPrice price, ProductDiscountRequest request) {
        if (isEmpty(price) || isEmpty(price.getId())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "PRODUCT PRICE"));
        }

        if (isEmpty(request) || isEmpty(request.getStart())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "STAR DATE"));
        }


        if (isEmpty(request) || isEmpty(request.getEnd())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "END DATE"));
        }


        if (isEmpty(request) || request.getDiscount() == null) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "DISCOUNT AMOUNT"));
        }
    }
}
