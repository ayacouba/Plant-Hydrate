package com.FinalTest.demo.Plant;

/**
 * Last updated: 11/14/2022 
 * Purpose: This class takes email input and turns it into a model to be 
 * displayed by the view. 
 * Contributing authors: Kayla Abreu, Laura Love, Aimade Yacouba
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kabreu1998
 */
@Controller
public class PlantController {

    //Allows PlantController to access PlantService
    @Autowired
    private PlantService plantService;

    /**
     * Returns a specific plant based off the given username
     *
     * @param model
     * @param userName
     * @return dashboard.html
     */
    @GetMapping("/userPlants/{userName}")
    public String getPlantByUserName(Model model, @PathVariable("userName") String userName) {
        model.addAttribute("plantList", plantService.getPlantByUserName(userName));
        model.addAttribute("currentUser", userName);
        Plant plant = new Plant();
        model.addAttribute("plant", plant);
        return "dashboard";
    }

    /**
     * Adds plant to plant list
     *
     * @param plant
     * @return dashboard.html with list of user's plants
     */
    @PostMapping("/addPlant")
    public String addPlant(Plant plant) {
        plantService.addPlant(plant);

        return "redirect:/userPlants/" + plant.getUserName();
    }

    /**
     * Deletes specific plant
     *
     * @param id
     * @param userName
     * @return dashboard.html with user's plant list
     */
    @GetMapping("/delete/{userName}/{id}")
    public String deletePlant(@PathVariable("id") long id, @PathVariable("userName") String userName) {
        plantService.deletePlant(id);
        return "redirect:/userPlants/" + userName;
    }
}
