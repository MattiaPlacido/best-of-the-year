package org.lessons.java.bestoftheyear.best_of_the_year.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import classes.Song;



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
    
    @GetMapping("/songs")
    public String songsPage(Model model) {
        ArrayList<String> listaArtisti = new ArrayList<>();
        listaArtisti.add("Scrittore");
        listaArtisti.add("Cantante");
        listaArtisti.add("Produttore");
        Song canzoneProva = new Song(2, "Titolo di prova", listaArtisti, "Etichetta di prova", 77);
        model.addAttribute("song",canzoneProva);
        return "songspage";
    }
    

}
