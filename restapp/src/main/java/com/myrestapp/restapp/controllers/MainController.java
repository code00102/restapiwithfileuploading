package com.myrestapp.restapp.controllers;

import java.util.List;
import java.util.Optional;

import com.myrestapp.restapp.entities.User;
import com.myrestapp.restapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        
        List<User> lis = this.userService.getAllUsers();

        return ResponseEntity.of(Optional.of(lis));
    }


    @PostMapping("/users")
    public ResponseEntity<User> postUsers(@RequestBody User user){

        if(user == null){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        User user1 = this.userService.saveUser(user);
        return ResponseEntity.ok().body(user1);

    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteSingleUser(@PathVariable("id") int id){
        try{
        this.userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id){

        if(user == null){

            return ResponseEntity.badRequest().build();
        }

        try{

            user.setUid(id);
            User us = this.userService.saveUser(user);
            return ResponseEntity.ok().body(us);
            
        }catch(Exception e){

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    
}
