package com.shop.user.entity;

import com.shop.cart.entity.CartEntity;
import com.shop.order.entity.OrderEntity;
import com.shop.product.entity.ProductEntity;
import com.shop.transaction.entity.TransactionEntity;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 20,nullable = false)
    private Long id;

    @NotEmpty(message = "First name should not be empty")
    @Column(name = "firstname",length = 50)
    private String firstName;

    @Column(name = "middlename",length = 50)
    private String middleName;

    @NotEmpty(message = "Last name should not be empty")
    @Column(name = "lastname",length = 50)
    private String lastName;

    @NotEmpty(message = "Mobile number should not be empty")
    @Size(min = 10,max = 10)
    @Column(name = "mobile",length = 15,unique = true)
    private String mobile;

    @NotEmpty(message = "Mobile number should not be empty")
    @Column(name = "email",length = 50,unique = true)
    private String email;

    @NotEmpty(message = "password should not be empty")
    @Column(name = "passwordhash",nullable = false)
    private String passwordHash;

    private Boolean enabled = false;

    @Column(name = "admin",length = 1,nullable = false,columnDefinition = "int default 1")
    private Integer admin;

    @Column(name = "vendor",length = 1,nullable = false,columnDefinition = "int default 1")
    private Integer vendor;

    @Column(name = "registeredat",nullable = false)
    private String registeredAt;

    @Column(name = "lastlogin")
    private String lastLogin;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
 //   @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<ProductEntity> productEntityList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
    private List<CartEntity> cartEntityList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
    private List<OrderEntity> orderEntityList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
    private List<TransactionEntity> transactionEntityList;

}