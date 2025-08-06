package com.example.product_service.controller;

import com.example.product_service.dto.ProductRequest;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductRequest> addProduct(@RequestBody ProductRequest request){
        productService.addProduct(request);
        return ResponseEntity.ok(request);
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductRequest>> getAllProducts(){
        List<ProductRequest> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("deleted product successfully... ");
    }

    @PostMapping
    public ResponseEntity<ProductRequest> updateProduct(@RequestBody ProductRequest request){
        productService.updateProduct(request);
        return ResponseEntity.ok(request);
    }
}
