package com.springboot3mexample.ppspringboot3m1.repository;

import com.springboot3mexample.ppspringboot3m1.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
