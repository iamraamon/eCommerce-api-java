package com.shop.product.entity;

import com.shop.cart.entity.Cart_ItemEntity;
import com.shop.category.entity.CategoryEntity;
import com.shop.order.entity.Order_ItemEntity;
import com.shop.tag.entity.TagEntity;
import com.shop.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20,nullable = false)
    private Long id;

    @Column(name = "title",length = 75,nullable = false)
    private String title;

    @Column(name = "metatitle",length = 100)
    private String metaTitle;

    @Column(name = "slug",length = 100,nullable = false,unique = true)
    private String slug;

    @Column(name = "summary")
    private String summery;

    @Column(name = "type",nullable = false)
    private Integer type;

    @Column(name = "sku",nullable = false,length = 100)
    private String sku;

    @Column(name = "price",nullable = false)
    private Float price;

    @Column(name = "discount",nullable = false)
    private Float discount;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "shop",nullable = false)
    private Integer shop;

    @Column(name = "createdat",nullable = false)
    private String createdAt;

    @Column(name = "updatedat")
    private String updatedAt;

    @Column(name = "publishedat")
    private String publishedAt;

    @Column(name = "startsat")
    private String startsAt;

    @Column(name = "endsat")
    private String endsAt;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "productEntity")
    private List<Order_ItemEntity> orderItemEntityList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "productEntity")
    private List<Cart_ItemEntity> cartItemEntityList;

    @OneToMany(mappedBy = "product")
    private Set<ProductReviewEntity> productReviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ProductMetaEntity> productMetas = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "products")
    private Set<CategoryEntity> categories = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "productEntitySet")
    private Set<TagEntity> tagEntitySet;

}
