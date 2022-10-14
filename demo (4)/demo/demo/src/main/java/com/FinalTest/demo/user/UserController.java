package com.FinalTest.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author llove
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserService service;

    @GetMapping("")
    public String showLoginPage() {
        return "index";
    }

    @GetMapping("/signup")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user";
    }

    @GetMapping("/dashboard")
    public String showHomePage() {

        return "dashboard";
    }
    
    @GetMapping("/list")
    public String showPlantList(){
    
        return "list";
    }
    @GetMapping("/calendar")
    public String viewCalendar(){

        return "calendar";
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

}
