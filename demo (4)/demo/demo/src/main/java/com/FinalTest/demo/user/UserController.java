package com.FinalTest.demo.user;

/**
 * Last updated: 11/07/2022 Purpose: This class takes user input and turns it
 * into a model to be displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
                display = "dashboard";
            }
        } catch (Exception e) {
            result.hasErrors();
            display = "index";
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
        return "dashboard";
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

}

@GetMapping("/weather")
    public String viewWeather() {

        return "weather";
    }

@GetMapping("/infoPage")
    public String infoPage() {

        return "infoPage";
    }
    /**
     * Displays reset password page
     *
     * @return reset.html
     */
    @GetMapping("/reset")
    public String reset() {
        return "reset";
    }

    @PostMapping("/reset")
    public String resetPassword() {

        return "";
    }

    /**
     * Allows administrator to delete a user from database
     *
     * @param userName
     * @return user.html
     */
    @GetMapping("/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        service.deleteUser(userName);
        return "redirect:/all";
    }
}
