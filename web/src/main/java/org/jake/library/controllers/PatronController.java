package org.jake.library.controllers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Patron;
import org.jake.library.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping("/patronServices")
    public String patronServices(Model model) {
        List<Patron> patronList = patronService.getPatronList();
        model.addAttribute("patrons", patronList);
        return "patrons/patronServices";
    }

    @GetMapping("/add/patron")
    public String addPatron() {
        return "patrons/addPatron";
    }

    @RequestMapping("/savePatron")
    public String savePatron(Patron patron) {
        patronService.addPatron(patron);
        return "redirect:/patronServices";
    }

    @RequestMapping("/deletePatron/{id}")
    public String deletePatron(@PathVariable(name = "id") int id) {
        patronService.removePatron(id);
        return "redirect:/patronServices";
    }

    @RequestMapping("/editPatron/{id}")
    public ModelAndView editPatron(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("editPatron");
        Patron patron = patronService.getPatron(id);
        modelAndView.addObject("patron", patron);
        return modelAndView;
    }

}
