package com.vikram.productservice.services;

import com.vikram.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(Long id);

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public String deleteProduct(Long id);

    public Product updateProduct( Long id, Product product);

    public String replaceProduct(Long id, Product product);

    public String product();
}
