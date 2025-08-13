package com.example.inventory_service.service;

import com.example.inventory_service.dto.InventoryDTO;
import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repo;

    public List<InventoryDTO> getInventoryListOfProducts(List<Long> productIdList){
        /*List<Inventory> inv = repo.findAllByProductId(productIdList);
        return inv.stream().map( i -> {
                    InventoryDTO dto = new InventoryDTO();
                    dto.setProductId(i.getProductId());
                    dto.setProductName(i.getProductName());
                    dto.setQuantity(i.getQuantity());
                    return dto;
                }).collect(Collectors.toList());*/
        return null;
    }

    @Override
    public Boolean isAllProductsAvailable(List<InventoryDTO> inventoryDTOList){
        /*List<Long> IdList = inventoryDTOList.stream().map(InventoryDTO::getProductId).collect(Collectors.toList());
        List<Inventory> inv = repo.findAllByProductId(IdList);
        Map<Long,InventoryDTO> map = inventoryDTOList.stream().collect(Collectors.toMap(InventoryDTO::getProductId, Function.identity()));
        if(!inv.isEmpty()){
            for(Inventory in : inv){
                if(map.get(in.getProductId()).getQuantity()>in.getQuantity())
                        return false;
            }
        }*/
        return true;
    }

    @Override
    public Boolean isProductAvailabe(Long productId, Integer quantity){
        Inventory inv = repo.findById(productId).orElse(null);
        if(inv!=null){
            Integer qt = inv.getQuantity();
            if(qt>=quantity){
                inv.setQuantity(qt-quantity);
                repo.save(inv);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProductsToWarehouse(List<InventoryDTO> inventoryDTOList){
        List<Inventory> invList = repo.findAll();
        Map<Long,Inventory> invMap = invList.stream().collect(Collectors.toMap(Inventory::getProductId,obj -> obj));
        for(InventoryDTO dto: inventoryDTOList){
            Inventory inv;
            if(invMap.containsKey(dto.getProductId())){
                inv=invMap.get(dto.getProductId());
                inv.setQuantity(inv.getQuantity()+ dto.getQuantity());
            }
            else {
                inv = new Inventory();
                inv.setProductId(dto.getProductId());
                inv.setQuantity(dto.getQuantity());
                inv.setProductName(dto.getProductName());
            }
            repo.save(inv);
        }
    }
}
