package controllers;

import apiServices.AuthorService;
import entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/library")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/add/{name}")
    public @ResponseBody String addAuthor(@PathVariable String name, @PathVariable Date dob){
        Author author = new Author();
        author.setName(name);
        author.setDob(dob);
        authorService.addAuthor(author);

        return "Author added";
    }
}
