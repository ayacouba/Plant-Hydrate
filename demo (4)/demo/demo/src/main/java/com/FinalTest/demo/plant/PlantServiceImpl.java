package com.FinalTest.demo.Plant;

/**
 * Last updated: 11/14/2022 
 * Purpose: This class handles the communication
 * between the PlantService interface and the database. 
 * Contributing authors: Kayla Abreu, Laura Love, Aimade Yacouba
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kabreu1998
 */
@Service
public class PlantServiceImpl implements PlantService {

    //Allows PlantServiceImpl to access PlantRepository
    @Autowired
    private PlantRepository repo;

    /**
     * Retrieves plant information from database and stores it in a List of
     * Plants
     *
     * @return repo.findAll();
     */
    @Override
    public List<Plant> getAllPlants() {
        return repo.findAll();
    }

    /**
     * Removes plant information from database
     *
     * @param id
     */
    @Override
    public void deletePlant(long id) {
        repo.deleteById(id);
    }

    /**
     * Retrieves plant object from Plant userName
     *
     * @param userName
     * @return repo.getPlantByUserName(userName);
     */
    @Override
    public List<Plant> getPlantByUserName(String userName) {
        return repo.getPlantByUserName(userName);
    }

    /**
     * Stores plant information in database
     *
     * @param plant
     */
    @Override
    public void addPlant(Plant plant) {
        repo.save(plant);
    }

}
