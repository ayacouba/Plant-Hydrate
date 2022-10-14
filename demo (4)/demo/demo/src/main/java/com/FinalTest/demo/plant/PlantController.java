
package com.FinalTest.demo.plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author llove
 */
@Controller
@RequestMapping("/dashboard")
public class PlantController {
    @Autowired(required = false)
    private PlantService service;
    
    @GetMapping("/plantList")
    public String getAllPlants(Model model) {
        model.addAttribute("plantList", service.getAllPlants());
        return "plant";
    }
    @PostMapping("/addPlant")
    public Plant addUser(@RequestBody Plant plant) {
        return service.addPlant(plant);
    }
}
