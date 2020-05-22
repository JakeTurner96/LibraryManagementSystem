package org.jake.library.controllers;

import org.jake.library.entities.*;
import org.jake.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;

    @GetMapping("/bookSearch")
    public String bookSearch() {
        return "books/bookSearch";
    }

    @RequestMapping("/searchBook")
    public ModelAndView search(@RequestParam String keyword) {
        List<Book> bookList = bookService.searchBook(keyword);
        ModelAndView modelAndView = new ModelAndView("books/bookSearch");
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }

    @GetMapping("/addBook")
    public ModelAndView addBook() {

        List<Author> authorList = authorService.getAuthorList();
        List<Publisher> publisherList = publisherService.getPublisherList();

        ModelAndView modelAndView = new ModelAndView("books/addBook");
        modelAndView.addObject("authorList", authorList);
        modelAndView.addObject("publisherList", publisherList);
        return modelAndView;
    }

    @RequestMapping("/saveBook")
    public String saveBook(Book book) {
        bookService.addBook(book);
        return "redirect:/bookSearch";
    }

//    @GetMapping("/manageBooks")
//    public String manageBooks(Model model) {
//        List<Book> bookList = bookService.getBookList();
//        model.addAttribute("bookList", bookList);
//        return "books/manageBooks";
//    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name = "id") int id) {
        bookService.removeBook(id);
        return "redirect:/bookSearch";
    }

    @RequestMapping("/editBook/{id}")
    public ModelAndView editBook(@PathVariable(name = "id") int id) {
        List<Author> authorList = authorService.getAuthorList();
        List<Publisher> publisherList = publisherService.getPublisherList();

        ModelAndView modelAndView = new ModelAndView("books/editBook");
        Book book = bookService.getBook(id);
        modelAndView.addObject("book", book);
        modelAndView.addObject("authorList", authorList);
        modelAndView.addObject("publisherList", publisherList);
        return modelAndView;
    }

    @RequestMapping("/updateBook")
    public String updatePatron(@ModelAttribute("newBook") Book book) {
        Book updatedBook = bookService.getBook(book.getId());

        updatedBook.setName(book.getName());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setPages(book.getPages());
        updatedBook.setCopies(book.getCopies());
        updatedBook.setAvailable(book.isAvailable());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPublisher(book.getPublisher());

        bookService.addBook(updatedBook);

        return "redirect:/bookSearch";
    }
}