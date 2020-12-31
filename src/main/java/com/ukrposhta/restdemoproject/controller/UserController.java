package com.ukrposhta.restdemoproject.controller;

import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.dto.UserSimpleDto;
import com.ukrposhta.restdemoproject.dto.ProductDto;
import com.ukrposhta.restdemoproject.model.User;
import com.ukrposhta.restdemoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") Long userId) {
        User user = userService.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PatchMapping("/{userId}/add-money")
    public ResponseEntity<User> addMoneyToUser(@RequestBody UserSimpleDto userSimpleDto, @PathVariable(value = "userId") Long userId) {
        User user = userService.putMoneyToUser(userId, userSimpleDto);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //should change return type
    @PostMapping("pay/user/{userId}")
    public ResponseEntity<Double> payForItems(@PathVariable(value = "userId") Long userId, @RequestBody Set<ProductWithQuantityDto> products){
        return new ResponseEntity<>(userService.buyProducts(userId, products), HttpStatus.OK);
    }

    @PostMapping("/create_user")
    public User createUser(@RequestBody User user){
        return userService.createNewUser(user);
    }
}
