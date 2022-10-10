/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.FinalTest.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author llove
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
