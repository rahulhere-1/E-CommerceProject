package com.example.product_service.service;

import com.example.product_service.dto.ProductRequest;
import com.example.product_service.model.Product;
import com.example.product_service.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequest request){
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());
        product.setExpiry(request.getExpiry());
        productRepository.save(product);
        request.setProductId(product.getProductId());
    }

    @Override
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(ProductRequest request){
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        if(product!=null){
            product.setProductName(request.getProductName());
            product.setProductPrice(request.getProductPrice());
            product.setExpiry(request.getExpiry());
        }
    }

    @Override
    public List<ProductRequest> getAllProducts(){
        return productRepository.findAll().stream().map( obj -> {
            ProductRequest dto = new ProductRequest();
            dto.setProductId(obj.getProductId());
            dto.setProductName(obj.getProductName());
            dto.setProductPrice(obj.getProductPrice());
            dto.setExpiry(obj.getExpiry());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductRequest getProductById(Long productId){
        Product obj = productRepository.findById(productId).orElse(null);
        ProductRequest dto = null;
        if(obj!=null){
            dto = new ProductRequest();
            dto.setProductId(obj.getProductId());
            dto.setProductName(obj.getProductName());
            dto.setProductPrice(obj.getProductPrice());
            dto.setExpiry(obj.getExpiry());
            return dto;
        }
        return dto;
    }
}
