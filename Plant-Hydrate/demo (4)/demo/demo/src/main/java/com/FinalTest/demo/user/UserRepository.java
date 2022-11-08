
package com.FinalTest.demo.user;
/**
 * Last updated: 10/31/2022 
 * Purpose: Hides implementation from user. Allows access to JpaRepository
 * methods.
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author llove
 */
public interface UserRepository extends JpaRepository<User, String>{
  
}
