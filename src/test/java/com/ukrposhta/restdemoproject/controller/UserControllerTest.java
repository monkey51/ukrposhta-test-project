package com.ukrposhta.restdemoproject.controller;

import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.dto.UserSimpleDto;
import com.ukrposhta.restdemoproject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController userController;

    User rick;
    User morty;

    @BeforeEach
    public void init(){
        rick = new User();
        rick.setId(1l);
        rick.setNickName("Rick Sanchez");
        rick.setEmail("RS@gmail.com");
        rick.setBalance(1000000d);

        morty = new User();
        morty.setId(2l);
        morty.setNickName("morty");
        morty.setEmail("mort@gmail.com");
        morty.setBalance(2000d);
    }

    @Test
    void getAllUserTest() {
        List<User> users = new ArrayList<>();
        users.add(rick);
        users.add(morty);
        ResponseEntity<List<User>> expected = new ResponseEntity<>(users, HttpStatus.OK);

        assertEquals(expected.getBody().size(), userController.getAllUser().getBody().size());
    }

    @Test
    void getUserByIdTest() {
        assertEquals(rick, userController.getUserById(1l).getBody());
    }

    @Test
    @Transactional
    void addMoneyToUser() {
        UserSimpleDto userDto = new UserSimpleDto();
        userDto.setId(1l);
        userDto.setNickName("Rick Sanchez");
        userDto.setMoney(1000d);

        User user = userController.addMoneyToUser(userDto, 1l).getBody();

        assertEquals(1000000d+1000d, user.getBalance());
    }

    @Test
    void payForItemsTest() {
        Set<ProductWithQuantityDto> products = new HashSet<>();
        products.add(new ProductWithQuantityDto(1l, "product_one", "descr", "category", 100d, 10F, 2l));
        products.add(new ProductWithQuantityDto(2l, "product_two", "descr", "category", 50d, 10F, 2l));
        products.add(new ProductWithQuantityDto(3l, "product_three", "descr", "category", 10d, 10F, 2l));

        assertEquals(295d, userController.payForItems(1l, products).getBody());
    }

    @Test
    void createUserTest() {
        User newUser = new User();
        newUser.setId(3l);
        newUser.setNickName("Bob");
        newUser.setEmail("bob@gmail.com");
        newUser.setBalance(12000d);

        assertEquals(newUser, userController.createUser(newUser));
    }
}