package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String showUserInfo(@CurrentSecurityContext(expression = "authentication.principal") User principal,
                               Model model) {
        model.addAttribute("user", principal);
        Boolean isAdmin = principal.getAuthorities().stream().anyMatch(s -> s.getAuthority().contains("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);
        return "user";
    }
}