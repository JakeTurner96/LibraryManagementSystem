package org.jake.library.controllers;

import org.jake.library.entities.Author;
import org.jake.library.entities.Book;
import org.jake.library.entities.BookLoan;
import org.jake.library.entities.Publisher;
import org.jake.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    BookLoanService bookLoanService;
    @Autowired
    PatronService patronService;

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

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Book> bookList = bookService.searchBook(keyword);
        ModelAndView modelAndView = new ModelAndView("books/bookSearch");
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }

    @RequestMapping("/loanBook/{id}")
    public String loanBook(@PathVariable(name = "id") int id){
        BookLoan bookLoan = new BookLoan();

        bookLoan.setDateOut(LocalDate.now());
        bookLoan.setDateDue(LocalDate.now().plusDays(7));
        bookLoan.setBook(bookService.getBook(id));
        bookLoan.setPatron(patronService.getPatron(1));


        bookLoanService.addBookLoan(bookLoan);

        return "redirect:/bookServices";

    }
}
