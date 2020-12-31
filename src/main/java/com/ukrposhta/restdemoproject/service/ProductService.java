package com.ukrposhta.restdemoproject.service;


import com.ukrposhta.restdemoproject.model.Product;
import com.ukrposhta.restdemoproject.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {


    public List<Product> findAllProducts();
    public List<Product> findAllProductsByCategoryName(String category);

    Optional<Product> findProductById(Long productId);

    Product FindProductByIdWithDiscountIsNotNull(Long productId);
}
