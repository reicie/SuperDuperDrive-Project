package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class signupController {
    private UserService userService;

    public signupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute User user, Model model ) {
        String errorMessage = null;

        // check if the username that is being registered is unique
        if (!userService.isUsernameAvailable(user.getUsername())) {
            errorMessage = "This username is taken. Please select another username";
            // keep track of any errors for later reference
            model.addAttribute("signupError", errorMessage);
        } else {
            // this is a unique username, so we register it and check that a user was successfully created
            int userAdd = userService.createUser(user);
            if (userAdd < 0 ) {
                errorMessage = "There was an error signing up. Please try again.";
                // keep track of any errors for later reference
                model.addAttribute("signupError", errorMessage);
            } else {
                // sign up was successful, so we should display a success error.
                // add attribute to model for later reference
                model.addAttribute("signupSuccess", true);
            }
        }

        return "signup";
    }
}
