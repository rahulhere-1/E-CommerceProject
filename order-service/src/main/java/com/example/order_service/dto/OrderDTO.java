package com.example.order_service.dto;

import com.example.order_service.model.OrderItems;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class OrderDTO {

    private long orderId;

    private Long productId;

    private String productName;

    private Double price;

    private Integer quantity;

}
