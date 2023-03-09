package com.springboot3mexample.ppspringboot3m1.service;

import com.springboot3mexample.ppspringboot3m1.model.User;

import java.util.Optional;

public interface UserServiceImpl {
    Optional<User> findById(Long id);
    Iterable<User> findAll();
    User saveUser(User user);
    void deleteUserById(Long id);
}
