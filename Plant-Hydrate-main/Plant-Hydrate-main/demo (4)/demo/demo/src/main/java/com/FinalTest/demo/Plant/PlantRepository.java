/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FinalTest.demo.Plant;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kabreu1998
 */

public interface PlantRepository extends JpaRepository<Plant, Long>{

    public List<Plant> getPlantByUserName(String userName);
    
}

