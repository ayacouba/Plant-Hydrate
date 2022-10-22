
package com.FinalTest.demo.user;

import java.util.List;

/**
 *
 * @author llove
 */
public interface UserService {

    public List<User> getAllUsers();

    public User registerUser(User user);

    public void deleteUser(String userId);
    
}
