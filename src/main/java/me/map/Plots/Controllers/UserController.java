package me.map.Plots.Controllers;

import me.map.Plots.models.MyGrantAuthority;
import me.map.Plots.models.User;
import me.map.Plots.models.dao.MyGrantAuthorityRepository;
import me.map.Plots.models.dao.UserRepository;
import me.map.Plots.models.forms.SignupForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyGrantAuthorityRepository grantRepo;

    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute(new SignupForm());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String processSignup(
            HttpServletRequest request,
            @ModelAttribute @Valid SignupForm form,
            Errors errors,
            Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("signupForm", form);
            return "user/signup";
        }

        if (!form.passwordsMatch()) {
            model.addAttribute("signupForm", form);
            model.addAttribute("error", "Passwords do not match");
            return "user/signup";
        }

        if (userRepository.findByUsername(form.getEmail()) != null) {
            model.addAttribute("signupForm", form);
            model.addAttribute("error", "User already exists");
            return "user/signup";
        }


        // Create user
        Set<MyGrantAuthority> grants = new HashSet<>();
        grants.add(grantRepo.getByRole("USER"));
        User user = new User(form.getEmail(), grants, form.getPassword());
        userRepository.save(user);
        user = userRepository.findByUsername(user.getUsername());

        // Add user to session
        try {
            request.login(form.getEmail(), form.getPassword());
        } catch (ServletException e) {
            System.out.println("Failed to add user to session: " + e.toString());
        }
        return "redirect:/";
    }
}


