package com.vikram.productservice.services;

import com.vikram.productservice.models.Product;
import com.vikram.productservice.respositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public String product() {
        return "";
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }

    @Override
    public String replaceProduct(Long id, Product product) {
        return "";
    }
}
