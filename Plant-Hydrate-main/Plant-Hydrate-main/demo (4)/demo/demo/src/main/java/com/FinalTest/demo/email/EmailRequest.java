package com.FinalTest.demo.email;
/**
 * Last updated: 11/07/2022 
 * Purpose: This class stores email request's information into the EmailRequest 
 * object into a model to be displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
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
public class EmailRequest {
    private String to;
    private String subject;
    private String message;
    
}
        
  