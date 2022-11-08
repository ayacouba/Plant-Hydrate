package com.FinalTest.demo.email;
/**
 * Last updated: 11/07/2022 
 * Purpose: This class takes email input and turns it
 * into a model to be displayed by the view. 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import com.FinalTest.demo.user.User;
import com.FinalTest.demo.user.UserRepository;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author llove
 */
@Controller
public class EmailController {

    //Allows EmailController to access UserRepository
    @Autowired
    UserRepository userRepo;

    //Allows EmailController to access EmailService
    @Autowired
    EmailService emailService;

    /**
     * Displays reset password page
     *
     * @return reset.html
     */
    @GetMapping("/reset")
    public String reset() {
        return "reset";
    }

    /**
     * Takes user email and sends otp message to user's email
     *
     * @param email
     * @param session
     * @return newpassword.html or reset.html
     */
    @PostMapping("/reset")
    public String resetPassword(@RequestParam("email") String email, HttpSession session) {
        Random random = new Random();
        int otp = random.nextInt(999999);
        String subject = "Plant Hydrate OTP";
        String message = ""
                + "<div style='border:1px solid #e2e2e2; padding:20px'>"
                + "<h1>"
                + "OTP is "
                + "<b>" + otp
                + "</n>"
                + "</h1>"
                + "</div>";
        boolean flag = this.emailService.sendEmail(subject, message, email);
        if (flag) {

            session.setAttribute("myotp", otp);
            session.setAttribute("email", email);
            return "newPassword";

        } else {
            session.setAttribute("message", "Check your email id");

            return "reset";
        }
    }

    /**
     * Verifies if user's otp matches the one sent to user's email
     *
     * @param otp
     * @param session
     * @return passwordChange.html, newpassword.html, or reset.html
     */
    @PostMapping("/verifyOTP")
    public String verifyOTP(@RequestParam("otp") int otp, HttpSession session) {

        int myOTP = (int) session.getAttribute("myotp");
        String email = (String) session.getAttribute("email");
        if (myOTP == otp) {
            User user = this.userRepo.getUserByUserName(email);
            if (user == null) {
                session.setAttribute("message", "No user found with this email");
                return "reset";
            } else {
            }
            return "passwordChange";
        } else {
            session.setAttribute("message", "You have entered incorrect otp");
            return "newPassword";
        }
    }

    /**
     * Updates user's password in user table
     *
     * @param newpassword
     * @param session
     * @return dashboard.html
     */
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("newpassword") String newpassword, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = this.userRepo.getUserByUserName(email);
        user.setPassword(newpassword);
        this.userRepo.save(user);

        return "dashboard";
    }
}
