package com.ukrposhta.restdemoproject.service.impl;

import com.ukrposhta.restdemoproject.model.Product;
import com.ukrposhta.restdemoproject.repository.ProductRepository;
import com.ukrposhta.restdemoproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductsByCategoryName(String category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product FindProductByIdWithDiscountIsNotNull(Long productId){
        return productRepository.findProductByIdAndDiscountIsNotNull(productId);
    }

}
