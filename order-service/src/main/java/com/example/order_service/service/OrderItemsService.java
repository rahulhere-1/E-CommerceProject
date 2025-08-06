package com.example.order_service.service;

import com.example.order_service.dto.OrderItemsDTO;

public interface OrderItemsService {
    OrderItemsDTO saveOrderItems(OrderItemsDTO orderItemsDTO);
}
