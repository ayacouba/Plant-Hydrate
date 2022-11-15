package com.FinalTest.demo.user;

/**
 * Last updated: 11/07/2022 
 * Purpose: This class takes user input and turns it
 * into a model to be displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author llove
 */
@Controller
public class UserController {

    //Allows UserController to use UserService
    @Autowired
    private UserService service;

    //Allows UserController to use UserRepository
    @Autowired
    private UserRepository repo;

    /**
     * Displays login page
     *
     * @param model
     * @return index.html
     */
    @GetMapping("/")
    public String showLoginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    /**
     * Checks user input against "user" table in database.If the username and
     * password match and are found, it displays user's dashboard.Otherwise it
     * displays incorrect login page.
     *
     * @param user
     * @param result
     * @param model
     * @return admindash.html, dashboard.html or error.html
     */
    @PostMapping("/userLogin")
    public String loginUser(@Valid User user, BindingResult result, Model model) {
        String display = "index";
        try {
            String userName = user.getUserName();
            repo.findById(userName);
            Optional<User> userdata = repo.findById(userName);
            if (user.getPassword().equals(userdata.get().getPassword())) {
                return "redirect:/userPlants/" + userName;
            }
            else{
                display= "loginError";
            }
        } catch (Exception e) {
            result.hasErrors();
            display = "loginError";
        }
        return display;

    }

    /**
     * Displays signup page
     *
     * @param model
     * @return signup.html
     */
    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    /**
     * Stores user input into "user" table in database Displays user dashboard
     * after successful signup
     *
     * @param user
     * @param result
     * @param model
     * @return dashboard.html
     */
    @PostMapping("/registerUser")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }
        service.registerUser(user);
        return "index";
    
    }
    /**
     * Displays user dashboard
     *
     * @return dashboard.html
     */
    @GetMapping("/dashboard")
    public String showHomePage() {
        return "dashboard";
    }

    /**
     * Displays calendar
     *
     * @return calendar.html
     */
    @GetMapping("/calendar")
    public String viewCalendar() {
        return "calendar";
    }

    /**
     * Displays weather page
     *
     * @return weather.html
     */
    @GetMapping("/weather")
    public String viewWeather() {

        return "weather";
    }

    /**
     * Displays information page
     *
     * @return infoPage.html
     */
    @GetMapping("/infoPage")
    public String infoPage() {

        return "infoPage";
    }

}
