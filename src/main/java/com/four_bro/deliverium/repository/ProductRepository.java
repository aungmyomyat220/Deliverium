package com.four_bro.deliverium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.four_bro.deliverium.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
