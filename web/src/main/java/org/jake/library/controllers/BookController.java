package org.jake.library.controllers;

import org.jake.library.entities.*;
import org.jake.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookLoanService bookLoanService;

    @GetMapping("/bookServices")
    public String bookServices(Model model) {
        return "books/bookServices";
    }

    @GetMapping("/bookSearch")
    public String bookSearch() {
        return "books/bookSearch";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Book> bookList = bookService.searchBook(keyword);
        ModelAndView modelAndView = new ModelAndView("books/bookSearch");
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }

    @RequestMapping("/bookLoanSearch")
    public ModelAndView bookLoanSearch(@RequestParam Integer patronID) {
        List<BookLoan> bookLoanList = bookLoanService.searchBookLoan(patronID);
        ModelAndView modelAndView = new ModelAndView("books/bookLoans");
        modelAndView.addObject("bookLoanList", bookLoanList);
        return modelAndView;
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

    @RequestMapping("/loan/{bookID}")
    public ModelAndView loan(@PathVariable(name = "bookID") int bookID) {
        ModelAndView modelAndView = new ModelAndView("books/loanBook");
        Book book = bookService.getBook(bookID);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping("/loanBook")
    public String loanBook(@ModelAttribute("bookLoan") BookLoan bookLoan) {
        bookLoan.setDateOut(LocalDate.now());
        bookLoan.setDateDue(LocalDate.now().plusDays(7));
        bookLoanService.addBookLoan(bookLoan);
        return "redirect:/patronServices";
    }

    @GetMapping("/bookLoans")
    public String bookLoans() {
        return "books/bookLoans";
    }

}
