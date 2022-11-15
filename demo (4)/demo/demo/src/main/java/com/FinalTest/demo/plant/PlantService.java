package com.FinalTest.demo.Plant;

/**
 * Last updated: 11/14/2022 Purpose: Hides implementation from user 
 * Contributing authors: Kayla Abreu, Laura Love, Aimade Yacouba
 */
import java.util.List;

/**
 *
 * @author kabreu1998
 */

public interface PlantService {

    List<Plant> getAllPlants();

    List<Plant> getPlantByUserName(String userName);

    public void addPlant(Plant plant);

    public void deletePlant(long id);

}