package com.example.order_service.controller;


import com.example.order_service.dto.OrderItemsDTO;
import com.example.order_service.model.OrderItems;
import com.example.order_service.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderItemsService orderItemsService;

    public ResponseEntity<OrderItemsDTO> makeOrder(@RequestBody OrderItemsDTO request){
        request = orderItemsService.saveOrderItems(request);
        return ResponseEntity.ok(request);
    }
}
