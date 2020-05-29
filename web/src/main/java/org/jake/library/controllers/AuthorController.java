package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Author;
import org.jake.library.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/manageAuthors")
    public String manageAuthors(Model model) {
        List<Author> authorList = authorService.getAuthorList();
        model.addAttribute("authorList", authorList);
        return "authors/manageAuthors";
    }

    @GetMapping("/addAuthor")
    public String addAuthor() {
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

    @RequestMapping("/editAuthor/{id}")
    public ModelAndView editAuthor(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("authors/editAuthor");
        Author author = authorService.getAuthor(id);
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping("/updateAuthor")
    public String updatePatron(@ModelAttribute("newAuthor") Author author) {
        Author updatedAuthor = authorService.getAuthor(author.getId());

        updatedAuthor.setName(author.getName());
        updatedAuthor.setDob(author.getDob());
        authorService.addAuthor(updatedAuthor);

        return "redirect:/manageAuthors";
    }
}
