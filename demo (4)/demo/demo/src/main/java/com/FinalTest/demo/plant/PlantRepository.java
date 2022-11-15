package com.FinalTest.demo.Plant;
/**
 * Last updated: 11/114/2022 
 * Purpose: Hides implementation from user. Allows access to JpaRepository
 * methods.
 * Contributing authors: Kayla Abreu, Laura Love, Aimade Yacouba
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kabreu1998
 */

public interface PlantRepository extends JpaRepository<Plant, Long>{

    public List<Plant> getPlantByUserName(String userName);
    
}