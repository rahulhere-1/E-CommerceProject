package com.example.inventory_service.controller;

import com.example.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/isAvailable")
    public ResponseEntity<Boolean> areProductsAvailable(@RequestParam Long productId, @RequestParam Integer quantity){
        Boolean response = inventoryService.isProductAvailabe(productId,quantity);
        return ResponseEntity.ok(response);
    }
}
