
package com.FinalTest.demo.Plant;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class handles the communication
 * between the UserService interface and the database. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PlantServiceImpl implements PlantService {


    @Autowired
    private PlantRepository repo;
    
    


    @Override
    public List<Plant> getAllPlants() {
    return repo.findAll();

    }
@Override
    public void deletePlant(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Plant> getPlantByUserName(String userName) {
    return repo.getPlantByUserName(userName);
    } 

    @Override
    public void addPlant(Plant plant) {
        repo.save(plant);
    }

}
