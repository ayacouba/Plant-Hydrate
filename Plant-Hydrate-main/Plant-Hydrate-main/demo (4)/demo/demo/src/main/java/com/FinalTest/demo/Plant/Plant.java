/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FinalTest.demo.Plant;

/**
 *
 * @author kabreu1998
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plant")
public class Plant {

    @Id
    
private long id;
private String userName;
   
private String date;
private String time;
private String name;

public Plant(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

 public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


 public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
 public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id= id;
    }
   

 public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}