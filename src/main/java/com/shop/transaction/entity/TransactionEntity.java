package com.shop.transaction.entity;

import com.shop.order.entity.OrderEntity;
import com.shop.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20,nullable = false)
    private Long id;

    @Column(name = "code",length = 100,nullable = false)
    private String code;

    @Column(name = "type",length = 6,nullable = false)
    private Integer type;

    @Column(name = "mode",length = 6,nullable = false)
    private Integer mode;

    @Column(name = "status",length = 6,nullable = false)
    private Integer status;

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

    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderEntity orderEntity;
}
