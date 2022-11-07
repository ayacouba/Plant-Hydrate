package com.FinalTest.demo.user;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class stores user's information into the User object
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author llove
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private String userName;
    private String email;
    private String password;

    public User() {

    }

    //============== CONSTRUCTOR ==============
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    //============== GETTERS ==============
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //============== SETTERS ==============
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Object getAdminPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
