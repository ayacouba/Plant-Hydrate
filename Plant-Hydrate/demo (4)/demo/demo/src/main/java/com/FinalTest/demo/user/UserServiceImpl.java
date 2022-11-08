package com.FinalTest.demo.user;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class handles the communication
 * between the UserService interface and the database. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author llove
 */
@Service
public class UserServiceImpl implements UserService {
    //Allows UserController to use UserRepository

    @Autowired
    private UserRepository repo;

    /**
     * Retrieves user information from database and stores it in a List of Users
     *
     * @return repo.findAll()
     */
    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Stores user information in database
     *
     * @param user
     * @return repo.save(user)
     */
    @Override
    public User registerUser(User user) {
        return repo.save(user);
    }

    /**
     * Removes user information from database
     *
     * @param userName
     */
    @Override
    public void deleteUser(String userName) {
        repo.deleteById(userName);
    }

    
}
