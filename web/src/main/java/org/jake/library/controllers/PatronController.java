package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.BookLoan;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.BookLoanRepository;
import org.jake.library.services.BookLoanService;
import org.jake.library.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatronController {

    @Autowired
    private BookLoanRepository bookLoanRepository;
    @Autowired
    private BookLoanService bookLoanService;
    @Autowired
    private PatronService patronService;

    @GetMapping("/managePatrons")
    public String patronServices(Model model) {
//        List<Patron> patronList = patronService.getPatronList();
//        model.addAttribute("patrons", patronList);
        return "patrons/managePatrons";
    }

    @RequestMapping("/patronSearch")
    public ModelAndView searchPatron(@RequestParam String keyword) {
        List<Patron> patronList = patronService.searchPatron(keyword);
        ModelAndView modelAndView = new ModelAndView("patrons/managePatrons");
        modelAndView.addObject("patronList", patronList);
        return modelAndView;
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

        for (BookLoan bookLoan : bookLoanList) {
            bookLoanService.removeBookLoan(bookLoan.getId());
        }
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
