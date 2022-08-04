package com.shop.cart.entity;

import com.shop.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class CartEntity {

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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cartEntity",fetch = FetchType.LAZY)
    private List<Cart_ItemEntity> cartItemEntityList;
}
