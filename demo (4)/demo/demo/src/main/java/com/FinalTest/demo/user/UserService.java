/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FinalTest.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author llove
 */
@Service
public class UserService {
    @Autowired(required=false)
    private UserRepository repo;
    
    public List<User> getAllUsers(){
        return repo.findAll();
    }
    void deleteById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User addUser(User user){
        return repo.save(user);
    }
}
