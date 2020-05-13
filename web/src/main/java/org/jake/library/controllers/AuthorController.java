package org.jake.library.controllers;

import org.jake.library.entities.Author;
import org.jake.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/manageAuthors")
    public String manageAuthors(Model model) {
        List<Author> authorList = authorService.getAuthorList();
        model.addAttribute("authorList", authorList);
        return "authors/manageAuthors";
    }

    @GetMapping("/addAuthor")
    public String addPatron() {
        return "authors/addAuthor";
    }

    @RequestMapping("/saveAuthor")
    public String addAuthor(Author author) {
        authorService.addAuthor(author);
        return "redirect:/manageAuthors";
    }

    @RequestMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable(name = "id") int id) {
        authorService.removeAuthor(id);
        return "redirect:/manageAuthors";
    }
}