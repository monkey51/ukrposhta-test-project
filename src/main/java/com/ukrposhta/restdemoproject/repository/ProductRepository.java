package com.ukrposhta.restdemoproject.repository;

import com.ukrposhta.restdemoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findProductsByCategory(String category);

    public Product findProductByIdAndDiscountIsNotNull(Long productId);

}
