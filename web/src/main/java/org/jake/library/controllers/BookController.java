package org.jake.library.controllers;

import org.jake.library.entities.Author;
import org.jake.library.entities.Book;
import org.jake.library.entities.Publisher;
import org.jake.library.services.AuthorService;
import org.jake.library.services.BookService;
import org.jake.library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Autowired
    PublisherService publisherService;

    @GetMapping("/bookServices")
    public String bookServices(Model model) {
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("books", bookList);
        return "books/bookServices";
    }

    @GetMapping("/addAuthor")
    public String addPatron() {
        return "books/addAuthor";
    }

    @RequestMapping("/saveAuthor")
    public String addAuthor(Author author) {
        authorService.addAuthor(author);
        return "redirect:/bookServices";
    }

    @GetMapping("/addPublisher")
    public String addPublisher() {
        return "books/addPublisher";
    }

    @RequestMapping("/savePublisher")
    public String savePublisher(Publisher publisher) {
        publisherService.addPublisher(publisher);
        return "redirect:/bookServices";
    }

    @GetMapping("/addBook")
    public String addBook() {
        return "books/addBook";
    }

    @RequestMapping("/saveBook")
    public String saveBook(Book book) {
        bookService.addBook(book);
        return "redirect:/bookServices";
    }

}
