package Controlers;


import Repositories.ProductsRepository;
import data.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {

    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    private ProductsRepository productsRepository;

    @GetMapping("/v1/products")


    public List<Product> getAllProducts() {


        return productsRepository.getAllProducts();
    }

    @GetMapping("/obj")
    @ResponseBody
    public Product showProduct() {
        return new Product(1L, "Milk",32l);
    }

}




