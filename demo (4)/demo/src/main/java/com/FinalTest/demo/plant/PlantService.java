
package com.FinalTest.demo.plant;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author llove
 */
@Service
public class PlantService {
    @Autowired(required=false)
    private PlantRepository repo;
    
    public List<Plant> getAllPlants(){
        return repo.findAll();
    }
    
    public Plant addPlant(Plant plant){
        return repo.save(plant);
    }
}
