package com.FinalTest.demo.user;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author llove
 */
@Controller
public class UserController {

    final private String adminId = "admin";
    final private String apassword = "admin";

    @Autowired
    private UserService service;

    @Autowired(required = true)
    private UserRepository repo;

    @GetMapping("/")
    public String showLoginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user) {
        String userId = user.getUserId();
        repo.findById(userId);
        Optional<User> userdata = repo.findById(userId);
        if (user.getPassword().equals(userdata.get().getPassword())) {
            if (user.getUserId().equals(adminId) && user.getPassword().equals(apassword)) {
                return "admindash";
            }
            return "dashboard";
        } else {
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
        service.registerUser(user);

        return "dashboard";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user";
    }

@GetMapping("/weather")
    public String viewWeather() {

        return "weather";
    }

    @GetMapping("/dashboard")
    public String showHomePage() {

        return "dashboard";
    }

@GetMapping("/infoPage")
    public String infoPage() {

        return "infoPage";
    }

    @GetMapping("/calendar")
    public String viewCalendar() {

        return "calendar";
    }

<<<<<<< HEAD
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
=======
>>>>>>> origin
    @GetMapping("/reset")
    public String reset() {

        return "reset";
    }
 
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        service.deleteUser(userId);
        return "redirect:/all";
    }   
}
