package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.BookLoan;
import org.jake.library.entities.Patron;
import org.jake.library.services.BookLoanService;
import org.jake.library.services.BookService;
import org.jake.library.services.PatronService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatronController {

    private final BookLoanService bookLoanService;
    private final PatronService patronService;
    private final BookService bookService;

    @GetMapping("/managePatrons")
    public String managePatrons(Model model) {
        List<Patron> patronList = patronService.getPatronList();
        model.addAttribute("patronList", patronList);
        return "patrons/managePatrons";
    }

    @GetMapping("/addPatron")
    public String addPatron() {
        return "patrons/addPatron";
    }

    @RequestMapping("/savePatron")
    public String savePatron(@ModelAttribute("patron") Patron patron) {
        patronService.addPatron(patron);
        return "redirect:/patronSearch?keyword=" + patron.getName();
    }

    @RequestMapping("/deletePatron/{id}")
    public String deletePatron(@PathVariable(name = "id") int id) {

        List<BookLoan> bookLoanList = bookLoanService.getPatronBookLoans(id);
        bookLoanList.forEach(bookLoan -> {
            bookService.incrementCopies(bookLoan.getBook());
            bookLoanService.removeBookLoan(bookLoan.getId());
        });
        patronService.removePatron(id);

        return "redirect:/patronSearch?keyword=";
    }

    @RequestMapping("/editPatron/{id}")
    public ModelAndView editPatron(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("patrons/editPatron");
        Patron patron = patronService.getPatron(id);
        modelAndView.addObject("patron", patron);
        return modelAndView;
    }

    @RequestMapping("/updatePatron")
    public String updatePatron(@ModelAttribute("newPatron") Patron patron) {
        Patron updatedPatron = patronService.getPatron(patron.getId());

        updatedPatron.setName(patron.getName());
        updatedPatron.setEmail(patron.getEmail());
        updatedPatron.setMemberSince(patron.getMemberSince());
        updatedPatron.setMembershipExpires(patron.getMembershipExpires());
        updatedPatron.setPatronType(patron.getPatronType());

        patronService.addPatron(updatedPatron);
        return "redirect:/patronSearch?keyword=" + updatedPatron.getName();
    }
}
