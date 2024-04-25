package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.ProductModel;
import com.four_bro.deliverium.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String allProducts(Model model) {
        List<ProductModel> res = productService.getAllProducts();
        model.addAttribute("res", res);
        return "product/list"; // Return the logical view name
    }
}
