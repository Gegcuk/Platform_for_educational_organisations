package com.gegcuk.university_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gegcuk.university_management.model.User;
import com.gegcuk.university_management.service.UserService;

@Controller
@RequestMapping("/web/users")
public class UserWebController {

    @Autowired
    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping
    public String createUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("successMessage", "User succesfully created/updated");
        } catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/web/users";
    }
}
