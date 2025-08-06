package com.example.order_service.dto;

import com.example.order_service.model.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderItemsDTO {

    private long invoiceNumber;

    private List<OrderDTO> orderDTOList;

    private Date deliveryDate;
}
