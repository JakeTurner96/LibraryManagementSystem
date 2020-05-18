package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/patronServices")
    public String patronServices(Model model) {
        return "/patronServices";
    }

    @GetMapping("/librarianServices")
    public String librarianServices() {
        return "/librarianServices";
    }

    @GetMapping("/adminServices")
    public String adminServices() {
        return "/adminServices";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/logout";
    }
}
