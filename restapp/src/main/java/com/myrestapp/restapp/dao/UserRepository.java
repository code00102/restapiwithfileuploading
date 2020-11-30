package com.myrestapp.restapp.dao;

import com.myrestapp.restapp.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    
    public User findById(int id);
}
