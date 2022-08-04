package com.shop.order.entity;

import com.shop.transaction.entity.TransactionEntity;
import com.shop.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20,nullable = false)
    private Long id;

    @Column(name = "sessionid",length = 100,nullable = false)
    private String sessionId;

    @Column(name = "token",length = 100,nullable = false)
    private String token;

    @Column(name = "status",length = 6,nullable = false)
    private Integer status;

    @Column(name = "subtotal",nullable = false)
    private Float subTotal;

    @Column(name = "itemdiscount",nullable = false)
    private Float itemDiscount;

    @Column(name = "tax",nullable = false)
    private Float tax;

    @Column(name = "shipping",nullable = false)
    private Float shipping;

    @Column(name = "total",nullable = false)
    private Float total;

    @Column(name = "promo")
    private String promo;

    @Column(name = "discount",nullable = false)
    private Float discount;

    @Column(name = "grandtotal",nullable = false)
    private Float grandTotal;

    @Column(name = "firstname",length = 50)
    private String firstName;

    @Column(name = "middlename",length = 50)
    private String middleName;

    @Column(name = "lastname",length = 50)
    private String LastName;

    @Column(name = "mobile",length = 15)
    private String mobile;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "line1",length = 50)
    private String line1;

    @Column(name = "line2",length = 50)
    private String line2;

    @Column(name = "city",length = 50)
    private String city;

    @Column(name = "province",length = 50)
    private String province;

    @Column(name = "country",length = 50)
    private String country;

    @Column(name = "createdat",nullable = false)
    private String createdAt;

    @Column(name = "updatedat")
    private String updatedAt;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "orderEntity")
    private List<TransactionEntity> transactionEntityList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "orderEntity")
    private List<Order_ItemEntity> orderItemEntityList;
}
