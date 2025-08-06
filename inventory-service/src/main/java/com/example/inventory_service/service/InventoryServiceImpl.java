package com.example.inventory_service.service;

import com.example.inventory_service.dto.InventoryDTO;
import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repo;

    public List<InventoryDTO> getInventoryListOfProducts(List<String> productCode){
        List<Inventory> inv = repo.findAllByProductCode(productCode);
        return inv.stream().map( i -> {
                    InventoryDTO dto = new InventoryDTO();
                    dto.setProductCode(i.getProductCode());
                    dto.setProductName(i.getProductName());
                    dto.setQuantity(i.getQuantity());
                    return dto;
                }).collect(Collectors.toList());
    }
}
