package com.ukrposhta.restdemoproject.service.impl;

import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.dto.UserSimpleDto;
import com.ukrposhta.restdemoproject.model.User;
import com.ukrposhta.restdemoproject.repository.UserRepository;
import com.ukrposhta.restdemoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println(userRepository.findAll().size());
        return userRepository.findAll();
    }

    @Override
    public User putMoneyToUser(Long userId, UserSimpleDto userSimpleDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("user with id " + userId + "not found"));
        if (!user.getNickName().equals(userSimpleDto.getNickName())) {
            throw new RuntimeException("incorrect id-name pair!");
        }
        user.setBalance(user.getBalance() + userSimpleDto.getMoney());
        return userRepository.save(user);
    }

    @Override
    public Double buyProducts(Long userId, Set<ProductWithQuantityDto> products) {
        double totalPrice = recountProductsPrice(products);
        if (totalPrice > userRepository.findById(userId).get().getBalance()) {
            throw new RuntimeException("you don't have enough money");
        }
        return totalPrice;
    }

    private Double recountProductsPrice(Set<ProductWithQuantityDto> products) {

        List<ProductWithQuantityDto> sortedByAbsolutDiscountValue = products.stream()
                .sorted((a, b) -> (int) ((b.getPrice() * b.getDiscount() - a.getPrice() * a.getDiscount()) * 100))
                .collect(Collectors.toList());

        double totalPrice = 0L;
        int productsWithDiscountLimiter = 3;

        for (ProductWithQuantityDto product : sortedByAbsolutDiscountValue) {
            long quantityCounter = product.getQuantity();
            while (quantityCounter > 0) {
                if (productsWithDiscountLimiter > 0) {
                    totalPrice += product.getPrice() - product.getPrice() * product.getDiscount()/100;
                } else {
                    totalPrice += product.getPrice();
                }
                quantityCounter--;
                productsWithDiscountLimiter--;
            }
        }

        return totalPrice;
    }
}
