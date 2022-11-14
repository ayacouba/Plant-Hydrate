
package com.FinalTest.demo.user;
/**
 * Last updated: 11/07/2022 
 * Purpose: Hides implementation from user. Allows access to JpaRepository
 * methods.
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author llove
 */
public interface UserRepository extends JpaRepository<User, String>{
    @Query("select u from User u where u.email = :email")
    public User getUserByUserName(@Param("email") String email);
    

}
