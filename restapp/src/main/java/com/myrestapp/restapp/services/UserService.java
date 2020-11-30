package com.myrestapp.restapp.services;

import com.myrestapp.restapp.dao.UserRepository;
import com.myrestapp.restapp.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    

    public List<User> getAllUsers(){

        List<User> lis = (List<User>)this.userRepository.findAll();
        return lis;
    }


    public User getUserById(int id){

        User user = this.userRepository.findById(id);
        return user;
    }


    public void deleteUserById(int id){

        this.userRepository.deleteById(id);
    }

    public User saveUser(User user){

        User u= this.userRepository.save(user);
        return u;
    }



}
