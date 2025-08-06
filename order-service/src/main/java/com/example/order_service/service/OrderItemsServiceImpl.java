package com.example.order_service.service;

import com.example.order_service.dto.OrderDTO;
import com.example.order_service.dto.OrderItemsDTO;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderItems;
import com.example.order_service.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;


    @Override
    public OrderItemsDTO saveOrderItems(OrderItemsDTO orderItemsDTO){
        List<OrderDTO> orderDTOList = orderItemsDTO.getOrderDTOList();
        List<Order> orderList = new ArrayList<>();
        for(OrderDTO dto : orderDTOList){
            Order order = new Order();
            order.setProductId(dto.getProductId());
            order.setProductName(dto.getProductName());
            order.setPrice(dto.getPrice());
            order.setQuantity(dto.getQuantity());
            orderList.add(order);
        }
        OrderItems orderItems = new OrderItems();
        orderItems.setOrderList(orderList);
        orderItems.setDeliveryDate(new Date());
        orderItemsRepository.save(orderItems);
        orderItemsDTO.setInvoiceNumber(orderItems.getInvoiceNumber());
        return orderItemsDTO;
    }
}
