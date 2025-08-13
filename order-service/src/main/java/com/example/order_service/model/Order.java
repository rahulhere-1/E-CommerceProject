package com.example.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_order")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column
    private Long productId;

    @Column
    private String productName;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "invoice_no")
    private OrderItems orderItems;


}
