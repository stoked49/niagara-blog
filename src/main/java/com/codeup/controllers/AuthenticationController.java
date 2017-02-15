package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Irby on 2/13/17.
 */

@Controller
public class AuthenticationController {
    private UsersRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public AuthenticationController(UsersRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
     //   System.out.println(new BCryptPasswordEncoder().encode("password"));
        return "login";
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "users/register";
    }

        // CSRF => Cross Site Request Forgery -> Random token
        // DOS => Denial Of Service

    @PostMapping("/users/create")
    public String registerUser(
            @Valid User user, // create the user form the input values, and apply validations
            Errors validation,
            Model viewModel
    ) {
        if (validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("user", user);
            return "users/register";
        }
        String hashedPassword  = encoder.encode(user.getPassword()); // has the user's password
        user.setPassword(hashedPassword);

            repository.save(user); //save the user to the database

        return "redirect:/login"; // redirect the user to the login page
    }
}
