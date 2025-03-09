package org.lessons.java.bestoftheyear.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("name", "Mattia");
        model.addAttribute("surname", "Placido");
        model.addAttribute("class", 134);
        return "homePage";
    }
    
}
