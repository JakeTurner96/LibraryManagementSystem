package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
