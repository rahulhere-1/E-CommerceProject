package com.example.inventory_service.service;

import com.example.inventory_service.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    Boolean isAllProductsAvailable(List<InventoryDTO> inventoryDTOList);

    Boolean isProductAvailabe(Long productId, Integer quantity);

    void addProductsToWarehouse(List<InventoryDTO> inventoryDTOList);
}
