package com.example.product_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class ProductRequest {

    private Long productId;

    private String productName;

    private Integer productPrice;

    private Date expiry;

}
