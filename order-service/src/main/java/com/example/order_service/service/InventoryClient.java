package com.example.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("inventory-service")
public interface InventoryClient {

    @GetMapping("/api/inventory/isAvailable")
    public Boolean isProductAvaiable(@RequestParam Long productId, @RequestParam Integer quantity);
}
