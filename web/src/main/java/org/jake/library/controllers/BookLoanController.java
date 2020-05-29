package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Book;
import org.jake.library.entities.BookLoan;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.PatronRepository;
import org.jake.library.services.BookLoanService;
import org.jake.library.services.BookService;
import org.jake.library.services.PatronService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookLoanController {

    private final BookLoanService bookLoanService;
    private final PatronService patronService;
    private final PatronRepository patronRepository;
    private final BookService bookService;

    @RequestMapping("/bookLoans")
    public String bookLoans(Model model) {
        List<BookLoan> bookLoanList = bookLoanService.getBookLoanList();
        model.addAttribute("bookLoanList", bookLoanList);
        return "bookLoans/bookLoans";
    }

    @RequestMapping("/patronBookLoans")
    public String patronBookLoans(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Patron> p = patronRepository.findByEmail(authentication.getName());

        List<BookLoan> patronBookLoanList = bookLoanService.getPatronBookLoans(p.get().getId());
        model.addAttribute("patronBookLoanList", patronBookLoanList);
        return "bookLoans/patronBookLoans";
    }

    @RequestMapping("/loan/{bookID}")
    public ModelAndView loan(@PathVariable(name = "bookID") int bookID) {
        List<Patron> patronList = patronService.getPatronList();

        ModelAndView modelAndView = new ModelAndView("bookLoans/loanBook");
        Book book = bookService.getBook(bookID);
        modelAndView.addObject("book", book);
        modelAndView.addObject("patronList", patronList);
        return modelAndView;
    }

    @RequestMapping("/patronLoan/{id}")
    public String patronLoan(@PathVariable(name = "id") int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Patron> patron = patronRepository.findByEmail(authentication.getName());

        BookLoan bookLoan = new BookLoan();

        bookLoan.setPatron(patron.get());
        bookLoan.setBook(bookService.getBook(id));
        bookLoan.setDateOut(LocalDate.now());
        bookLoan.setDateDue(LocalDate.now().plusDays(7));

        bookLoanService.addBookLoan(bookLoan);
        bookService.decrementCopies(bookLoan.getBook());

        return "redirect:/patronBookLoans";
    }

    @RequestMapping("/loanBook")
    public String loanBook(@ModelAttribute("bookLoan") BookLoan bookLoan) {
        bookLoan.setDateOut(LocalDate.now());
        bookLoan.setDateDue(LocalDate.now().plusDays(7));

        bookLoanService.addBookLoan(bookLoan);
        bookService.decrementCopies(bookLoan.getBook());

        return "redirect:/bookLoans";
    }

    @RequestMapping("/returnBook/{id}")
    public String returnBook(@PathVariable(name = "id") int bookLoanID) {
        bookService.incrementCopies(bookLoanService.getBookLoan(bookLoanID).getBook());
        bookLoanService.removeBookLoan(bookLoanID);
        return "redirect:/patronBookLoans";
    }

    @RequestMapping("/librarianBookReturn/{id}")
    public String librarianBookReturn(@PathVariable(name = "id") int bookLoanID) {
        bookService.incrementCopies(bookLoanService.getBookLoan(bookLoanID).getBook());
        bookLoanService.removeBookLoan(bookLoanID);
        return "redirect:/bookLoans";
    }
}
