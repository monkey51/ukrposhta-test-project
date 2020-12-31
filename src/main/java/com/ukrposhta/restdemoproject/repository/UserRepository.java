package com.ukrposhta.restdemoproject.repository;

import com.ukrposhta.restdemoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
