package Controlers;


import Repositories.ProductsRepository;
import data.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    private ProductsRepository productsRepository;

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
    public void addProduct(@RequestBody Product product){
        productsRepository.add(product);
    }






}




