package com.example.order_service.service;

import com.example.order_service.dto.OrderDTO;
import com.example.order_service.dto.OrderItemsDTO;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderItems;
import com.example.order_service.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @Override
    public OrderItemsDTO saveOrderItems(OrderItemsDTO orderItemsDTO){
        List<OrderDTO> orderDTOList = orderItemsDTO.getOrderDTOList();
        List<Order> orderList = new ArrayList<>();
        OrderItems orderItems = new OrderItems();
        for(OrderDTO dto : orderDTOList){
            Boolean isThere = inventoryClient.isProductAvaiable(dto.getProductId(),dto.getQuantity());
            if(!isThere)
                continue;
            Order order = new Order();
            order.setProductId(dto.getProductId());
            order.setProductName(dto.getProductName());
            order.setPrice(dto.getPrice());
            order.setQuantity(dto.getQuantity());
            order.setOrderItems(orderItems);
            orderList.add(order);
        }
        if(!orderList.isEmpty()){
            orderItems.setOrderList(orderList);
            orderItems.setDeliveryDate(new Date());
            orderItemsRepository.save(orderItems);
            orderItemsDTO.setInvoiceNumber(orderItems.getInvoiceNumber());
            return orderItemsDTO;
        }
        return null;
    }
}
