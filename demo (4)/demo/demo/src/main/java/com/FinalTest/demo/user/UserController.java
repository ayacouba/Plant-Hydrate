package com.FinalTest.demo.user;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class takes user input and turns it into a model to be 
 * displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Checks user input against "user" table in database. If the username and
     * password match and are found, it displays user's dashboard. Otherwise it
     * displays incorrect login page.
     *
     * @param user
     * @return admindash.html, dashboard.html or error.html
     */
    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user) {
        String result = "userLoginError";
        try {
            String userName = user.getUserName();
            repo.findById(userName);
            Optional<User> userdata = repo.findById(userName);
            if (user.getPassword().equals(userdata.get().getPassword())) {
                result = "dashboard";
            }
        } catch (Exception e) {
            result = "userLoginError";
        }
        return result;

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
     * @return dashboard.html
     */
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
        service.registerUser(user);
        return "dashboard";
    }

    /**
     * Retrieves a list of all users stored in database and displays it
     *
     * @param model
     * @return user.html
     */
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user";
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
