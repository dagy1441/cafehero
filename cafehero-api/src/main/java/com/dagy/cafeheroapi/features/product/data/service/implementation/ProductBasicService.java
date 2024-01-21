package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.annotations.Interactor;
import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductBasicRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductBasicService;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductTaxService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductBasic;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductTax;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductBasicUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


//@Interactor
@Service
@RequiredArgsConstructor
public class ProductBasicService implements IProductBasicService, Mapper<ProductBasicRequest, ProductBasic> {
    private final IProductBasicUsecase basicUsecase;
    private final IProductTaxService taxInteractor;
    private final ModelMapper mapper;
    @Override
    public ProductBasic save(ProductBasicRequest request) {
        List<ProductTax> taxes = getTaxModels(request);
        ProductBasic model = this.toModel(request);
        model.setTaxes(taxes);
        return this.basicUsecase.save(model);
    }

    @Override
    public ProductBasic update(ProductBasic basic) {
        return this.basicUsecase.save(basic);
    }

    @Override
    public ProductBasic update(ProductBasicRequest request) {
        ProductBasic model = this.toModel(request);
        return this.update(model);
    }

    @Override
    public ProductBasicRequest toRequest(ProductBasic model) {
        return this.mapper.map(model, ProductBasicRequest.class);
    }

    @Override
    public ProductBasic toModel(ProductBasicRequest request) {
        return this.mapper.map(request, ProductBasic.class);
    }

    private List<ProductTax> getTaxModels(ProductBasicRequest request) {
        List<ProductTax> taxList = taxInteractor.mapRequestListToModelList(request.getTaxes());
        request.setTaxes(null);
        return taxList;
    }
}
