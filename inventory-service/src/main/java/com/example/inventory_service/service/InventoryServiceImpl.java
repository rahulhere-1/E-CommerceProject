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

    public List<InventoryDTO> getInventoryListOfProducts(List<Integer> productIdList){
        List<Inventory> inv = repo.findAllByProductId(productIdList);
        return inv.stream().map( i -> {
                    InventoryDTO dto = new InventoryDTO();
                    dto.setProductId(i.getProductId());
                    dto.setProductName(i.getProductName());
                    dto.setQuantity(i.getQuantity());
                    return dto;
                }).collect(Collectors.toList());
    }

    public Boolean isAllProductsAvailable(List<InventoryDTO> inventoryDTOList){
        List<Integer> IdList = inventoryDTOList.stream().map( obj -> obj.getProductId()).collect(Collectors.toList());
        List<Inventory> inv = repo.findAllByProductId(IdList);
        if(!inv.isEmpty()){
        }
        return null;
    }
}
