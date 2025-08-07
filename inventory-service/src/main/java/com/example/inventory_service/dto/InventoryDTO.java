package com.example.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryDTO {

    private String productName;
    private Integer productId;
    private Integer quantity;

}
