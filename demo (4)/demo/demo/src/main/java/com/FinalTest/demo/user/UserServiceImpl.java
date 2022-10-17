
package com.FinalTest.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author llove
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User registerUser(User user) {
        return repo.save(user);
    }
}
