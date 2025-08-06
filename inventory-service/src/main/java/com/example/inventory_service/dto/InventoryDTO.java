package com.example.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryDTO {

    private String productName;
    private String productCode;
    private Integer quantity;

}
