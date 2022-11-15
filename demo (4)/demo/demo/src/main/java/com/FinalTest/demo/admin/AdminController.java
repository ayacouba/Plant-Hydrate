package com.FinalTest.demo.admin;
/**
 * Last updated: 11/10/2022 
 * Purpose: This class takes admin input and turns it
 * into a model to be displayed by the view. 
 * Contributing authors: Laura Love,Aimade Yacouba, Kayla Abreu
 */
import com.FinalTest.demo.user.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author llove
 */
@Controller
public class AdminController {

    //Allows AdminController to access AdminRepository
    @Autowired
    private AdminRepository repo;

    //Allows AdminController to access UserService 
    @Autowired
    private UserService userService;

    /**
     * Displays login page for administrators
     *
     * @param model
     * @return adminLogin.html
     */
    @GetMapping("/admin")
    public String showAdminLogin(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminLogin";
    }

    /**
     * Checks admin input against "admin" table in database. If the username and
     * password match and are found, it displays the admin's dashboard. 
     * Otherwise it displays incorrect login page.
     *
     * @param admin
     * @param result
     * @return adminLogin.html or admindash.html
     */
    @PostMapping("/adminLogin")
    public String loginAdmin(@ModelAttribute("admin") Admin admin, BindingResult result) {
        String display = "adminLogin";
        try {
            String adminName = admin.getAdminName();
            repo.findById(adminName);
            Optional<Admin> admindata = repo.findById(adminName);
            if (admin.getAdminPassword().equals(admindata.get().getAdminPassword())) {
                display = "admindash";
            }
            else{
                display = "adminLoginError";
            }
        } catch (Exception e) {
            result.hasErrors();
            display = "adminLoginError";
        }
        return display;
    }
   
    /**
     * Retrieves a list of all users stored in database and displays it
     *
     * @param model
     * @return user.html
     */
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "user";
    }

    /**
     * Allows administrator to delete a user from database
     *
     * @param userName
     * @return user.html
     */
    @GetMapping("/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
        return "redirect:/all";
    }
}
