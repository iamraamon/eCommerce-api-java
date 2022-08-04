package com.shop.product.repository;

import com.shop.product.entity.ProductMetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMetaRepository extends JpaRepository<ProductMetaEntity,Long> {
}
