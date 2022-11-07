package com.FinalTest.demo.admin;

/**
 * Last updated: 10/31/2022 
 * Purpose: This class takes admin input and turns it into a model to be 
 * displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author llove
 */
@Controller
public class AdminController {
    
    //Allows AdminController to use AdminRepository
    @Autowired
    private AdminRepository repo;

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
     * @return
     */
    @PostMapping("/adminLogin")
    public String loginUser(@ModelAttribute("admin") Admin admin) {
        String result = "adminLoginError";
        try {
            String adminName = admin.getAdminName();
            repo.findById(adminName);
            Optional<Admin> admindata = repo.findById(adminName);
            if (admin.getAdminPassword().equals(admindata.get().getAdminPassword())) {
                result = "admindash";
            }
        } catch (Exception e) {
            result = "adminLoginError";
        }
        return result;
    }
}
