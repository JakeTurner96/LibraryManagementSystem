package org.jake.library.controllers;

import org.jake.library.entities.*;
import org.jake.library.repositories.PatronRepository;
import org.jake.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookLoanService bookLoanService;

    @Autowired
    PatronRepository patronRepository;

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

    @GetMapping("/addBook")
    public String addBook() {
        return "books/addBook";
    }

    @RequestMapping("/saveBook")
    public String saveBook(Book book) {
        bookService.addBook(book);
        return "redirect:/manageBooks";
    }

    @RequestMapping("/bookLoans")
    public String bookLoans(Model model) {
        List<BookLoan> bookLoanList = bookLoanService.getBookLoanList();
        model.addAttribute("bookLoanList", bookLoanList);
        return "books/bookLoans";
    }

    @RequestMapping("/patronBookLoans")
    public String patronBookLoans(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Patron> p = patronRepository.findByEmail(authentication.getName());

        List<BookLoan> patronBookLoanList = bookLoanService.getPatronBookLoans(p.get().getId());
        model.addAttribute("patronBookLoanList", patronBookLoanList);
        return "books/patronBookLoans";
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

    @RequestMapping("/returnBook/{id}")
    public String returnBook(@PathVariable(name = "id") int id) {
        bookLoanService.removeBookLoan(id);
        return "redirect:/bookLoans";
    }

    @GetMapping("/manageBooks")
    public String manageBooks(Model model) {
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "books/manageBooks";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name = "id") int id) {
        bookService.removeBook(id);
        return "redirect:/manageBooks";
    }

    @RequestMapping("/editBook/{id}")
    public ModelAndView editBook(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("books/editBook");
        Book book = bookService.getBook(id);
        modelAndView.addObject("book", book);
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

        return "redirect:/manageBooks";
    }
}
