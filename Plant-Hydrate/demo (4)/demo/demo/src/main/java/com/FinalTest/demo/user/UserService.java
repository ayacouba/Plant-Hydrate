
package com.FinalTest.demo.user;
/**
 * Last updated: 10/31/2022 
 * Purpose: Hides implementation from user
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.List;

/**
 *
 * @author llove
 */
public interface UserService {

    public List<User> getAllUsers();

    public User registerUser(User user);

    public void deleteUser(String userName);
    
}
