package com.franco.supermegaapp.controllers;

import com.franco.supermegaapp.models.Car;
import com.franco.supermegaapp.models.Product;
import com.franco.supermegaapp.services.CarsService;
import com.franco.supermegaapp.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("")
    public String createNewProduct(@RequestBody Product product){
        return productsService.createNewProduct(product);
    }

    @GetMapping("")
    public List<Product> listAllProducts() {
        return productsService.listAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return productsService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productsService.findProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return productsService.updateProduct(id, updatedProduct);
    }

}