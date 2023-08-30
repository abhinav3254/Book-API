package com.pojo;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder.In;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    private Integer userId;
    
    private Integer bookId;

    private Double orderTotal;

    private String paymentMethod;


    private String shippingAddress;


    private String billingAddress;


    private String orderStatus;


    private String shippingMethod;


    private String paymentStatus;


    private Double discountAmount;

    private Double taxAmount;

    private String notes;


}
