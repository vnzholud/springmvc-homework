package com.geekbreans.springmvc.springmvchomework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final ProductsRepository productsRepository;

    @Autowired
    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/v1/products")
    public List<Product> getAllProducts() {
        return productsRepository.getAllProducts();
    }

    @GetMapping("/v1/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productsRepository.findById(id);
    }

    @GetMapping("/v1/products/del/all")
    public void deleteAll(){
        productsRepository.deleteAllproducts();
    }

    @GetMapping("v1/products/del/{id}")
    public void delById(@PathVariable Long id) {
        productsRepository.deleteById(id);
    }

    @GetMapping("/v1/products/add")
    public void addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Long price){

        Product product = new Product(id, title, price);
        productsRepository.add(product);


    }






}




