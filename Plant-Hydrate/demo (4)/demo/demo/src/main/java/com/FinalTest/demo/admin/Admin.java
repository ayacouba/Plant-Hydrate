package com.FinalTest.demo.admin;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class stores administrator's information into the Admin object 
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
@Table(name = "admin")
public class Admin {

    @Id
    private String adminName;
    private String adminEmail;
    private String adminPassword;

    public Admin() {

    }

    //============== CONSTRUCTOR ==============
    public Admin(String adminName, String adminEmail, String adminPassword) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    //============== GETTERS ==============
    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    //============== SETTERS ==============
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
