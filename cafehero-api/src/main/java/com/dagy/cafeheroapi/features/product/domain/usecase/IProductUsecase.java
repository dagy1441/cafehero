package com.dagy.cafeheroapi.features.product.domain.usecase;

import com.dagy.cafeheroapi.core.params.FileHandler;
import com.dagy.cafeheroapi.features.product.domain.entity.Product;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductUsecase extends FileHandler<Map<String, String>, MultipartFile> {

    Optional<Product> findById(Long id);

    Product save(Product product);

    Page<Product> findMany(Specification<Product> specification, Pageable pageable);

    List<Product> findMany(Specification<Product> specification);

    void updateProductQuantity(Product product, Integer quantity);

    void tryUpdateProductPrice(Product product, ProductPrice productPrice);

    void deductProductQuantityAfterSales(Product product, Integer deductBy);
}
