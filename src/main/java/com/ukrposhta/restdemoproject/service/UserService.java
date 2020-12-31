package com.ukrposhta.restdemoproject.service;

import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.dto.UserSimpleDto;
import com.ukrposhta.restdemoproject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface UserService {

    public User createNewUser(User user);
    public Optional<User> findById(Long id);
    public List<User> getAllUsers();
    public User putMoneyToUser(Long userId, UserSimpleDto userSimpleDto);
    public Double buyProducts(Long userId, Set<ProductWithQuantityDto> products);
}
