package com.ukrposhta.restdemoproject.service.impl;

import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    void buyProductsTest() {

        Set<ProductWithQuantityDto> products = new HashSet<>();
        products.add(new ProductWithQuantityDto(1l, "product_one", "descr", "category", 100d, 10F, 2l));
        products.add(new ProductWithQuantityDto(2l, "product_two", "descr", "category", 50d, 10F, 2l));
        products.add(new ProductWithQuantityDto(3l, "product_three", "descr", "category", 10d, 10F, 2l));

        double moneyLeft = userService.buyProducts(1l, products);
        System.out.println(moneyLeft);
        assertEquals(295, moneyLeft);
    }
}