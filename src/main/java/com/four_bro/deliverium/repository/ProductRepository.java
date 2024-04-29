package com.four_bro.deliverium.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.four_bro.deliverium.model.ProductModel;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    List<ProductModel> findByDeleteFlg(Integer deleteFlg);

    Optional<ProductModel> findByIdAndDeleteFlg(Integer id, int deleteFlg);
}
