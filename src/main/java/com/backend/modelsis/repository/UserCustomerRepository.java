package com.backend.modelsis.repository;

import com.backend.modelsis.entites.UserCustomer;
import com.backend.modelsis.entites.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Integer> {
    public UserCustomer findUserByUsername(String username);
}
