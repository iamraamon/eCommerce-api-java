package com.shop.tag.entity;

import com.shop.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {

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

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "product_tag",
            joinColumns = {@JoinColumn(name = "tagid")},
            inverseJoinColumns = {@JoinColumn(name = "productid")}
    )
    private Set<ProductEntity> productEntitySet;
}
