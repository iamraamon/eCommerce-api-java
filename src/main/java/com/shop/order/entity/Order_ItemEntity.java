package com.shop.order.entity;

import com.shop.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class Order_ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20,nullable = false)
    private Long id;

    @Column(name = "sku",nullable = false,length = 100)
    private String sku;

    @Column(name = "price",nullable = false)
    private Float price;

    @Column(name = "discount",nullable = false)
    private Float discount;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "createdat",nullable = false)
    private String createdAt;

    @Column(name = "updatedat")
    private String updatedAt;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderEntity orderEntity;
}
