/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FinalTest.demo.Plant;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class stores user's information into the User object
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PlantController {

@Autowired
    private PlantService plantService;

@Autowired
    private PlantRepository repo;
   
    
    @GetMapping("/userPlants/{userName}")
   public String getPlantByUserName(Model model,@PathVariable("userName") String userName ){
      model.addAttribute("plantList", plantService.getPlantByUserName(userName)); 
       model.addAttribute("currentUser",userName);
        Plant plant = new Plant();
        model.addAttribute("plant", plant);
       return "dashboard";
   }

   
   @PostMapping("/addPlant")
    public String addPlant(Plant plant) {
        plantService.addPlant(plant);
        
        return "redirect:/userPlants/"+ plant.getUserName();
    }
       

 @GetMapping("/delete/{userName}/{id}")
    public String deletePlant(@PathVariable("id") long id, @PathVariable("userName") String userName) {
        plantService.deletePlant(id);
        return "redirect:/userPlants/"+ userName;
    }
}
