package com.vikram.productservice.controllers;

import com.vikram.productservice.exceptions.ProductNotFoundException;
import com.vikram.productservice.models.Product;
import com.vikram.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.getProduct(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/product")
    public ResponseEntity<String> getProducts() throws ProductNotFoundException {
        return new ResponseEntity<>(
                productService.product(),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );

    }

    @PostMapping
    public String createProduct( @RequestBody Product product ) {
        return "Success";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Success";
    }


    @PatchMapping("/{id}") // Partial Update
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct( id, product );
    }

    @PutMapping("/{id}") // Product update
    public void replaceProduct( @PathVariable("id") Long id, @RequestBody Product product) {

    }

}
