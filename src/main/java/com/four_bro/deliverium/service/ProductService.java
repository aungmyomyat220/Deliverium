package com.four_bro.deliverium.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.four_bro.deliverium.model.ProductModel;
import com.four_bro.deliverium.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findByDeleteFlg(0);
    }

    public String saveProduct(@RequestBody ProductModel request) {
        productRepository.save(request);
        return "Product created successfully";
    }

}
