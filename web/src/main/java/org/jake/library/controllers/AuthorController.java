package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Author;
import org.jake.library.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping(path = "/add/{name}")
    public String addAuthor(@PathVariable String name, @PathVariable Date dob) {
        Author author = new Author();
        author.setName(name);
        author.setDob(dob);
        authorService.addAuthor(author);
        return "Author added";
    }
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
