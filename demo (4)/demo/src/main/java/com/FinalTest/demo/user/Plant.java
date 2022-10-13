/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FinalTest.demo.user;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author kabreu1998
 */
@Entity
@Table(name = "plantdb")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plant;

    
    public Plant(){
        
    }

    public Plant(String plant) {
        
        this.plant = plant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

   }


