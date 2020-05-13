package org.jake.library.controllers;

import org.jake.library.entities.Author;
import org.jake.library.entities.Publisher;
import org.jake.library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/managePublishers")
    public String managePublishers(Model model) {
        List<Publisher> publisherList = publisherService.getPublisherList();
        model.addAttribute("publisherList", publisherList);
        return "publishers/managePublishers";
    }

    @GetMapping("/addPublisher")
    public String addPublisher() {
        return "publishers/addPublisher";
    }

    @RequestMapping("/savePublisher")
    public String savePublisher(Publisher publisher) {
        publisherService.addPublisher(publisher);
        return "redirect:/managePublishers";
    }

    @RequestMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable(name = "id") int id) {
        publisherService.removePublisher(id);
        return "redirect:/managePublishers";
    }
}
