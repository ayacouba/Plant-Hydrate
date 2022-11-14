package com.FinalTest.demo.admin;

/**
 * Last updated: 11/07/2022 
 * Purpose: This class stores administrator's information into the Admin object 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author llove
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    private String adminName;
    private String adminEmail;
    private String adminPassword;
}
