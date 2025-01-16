package com.vikram.productservice.services;

import com.vikram.productservice.dtos.FakeStoreProductDto;
import com.vikram.productservice.exceptions.ProductNotFoundException;
import com.vikram.productservice.models.Category;
import com.vikram.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);

        // Convert FaketStoreDtoProduct to product
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();

        for( FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return restTemplate.patchForObject("http://fakestoreapi.com/products/"+id,product,Product.class);
    }

    @Override
    public String replaceProduct(Long id, Product product) {
        throw new ProductNotFoundException("Nahi milega");
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        if(Objects.isNull(fakeStoreProductDto)) {
            return product;
        }
        product.setCategory(new Category());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }


    @Override
    public String product() {
        throw new ProductNotFoundException("Nahi milega");
    }

}
