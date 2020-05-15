package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.services.AuthorService;
import org.jake.library.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private PatronService patronService;

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
