package com.example.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product p = getProductById(id);
        p.setName(newProduct.getName());
        p.setBrand(newProduct.getBrand());
        p.setPrice(newProduct.getPrice());
        p.setDescription(newProduct.getDescription());
        p.setStockQuantity(newProduct.getStockQuantity());
        p.setImageUrl(newProduct.getImageUrl());
        return productRepository.save(p);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> search(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}
