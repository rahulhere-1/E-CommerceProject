package com.example.product_service.service;

import com.example.product_service.dto.ProductRequest;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequest request);

    void deleteProduct(Long productId);

    void updateProduct(ProductRequest request);

    List<ProductRequest> getAllProducts();

    ProductRequest getProductById(Long productId);
}
