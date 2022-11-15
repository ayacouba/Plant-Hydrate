package com.FinalTest.demo.Plant;

/**
 * Last updated: 10/31/2022 Purpose: Hides implementation from user Contributing
 * authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.List;

/**
 *
 * @author llove
 */
public interface PlantService {

    List<Plant> getAllPlants();

    List<Plant> getPlantByUserName(String userName);

    public void addPlant(Plant plant);

    public void deletePlant(long id);

}
