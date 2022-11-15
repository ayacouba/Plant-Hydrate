package com.FinalTest.demo.user;

/**
 * Last updated: 11/07/2022 
 * Purpose: This class stores user's information into
 * the User object Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "user")
public class User {

    
    @Id
    
    @NotEmpty(message = "Invalid Username")
    private String userName;
    @NotEmpty(message = "Invalid Email Address")
    @Email
    private String email;
    @NotEmpty(message = "Invalid Password")
    private String password;

    
}
