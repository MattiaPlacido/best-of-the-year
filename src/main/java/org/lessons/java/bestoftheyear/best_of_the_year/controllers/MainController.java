package org.lessons.java.bestoftheyear.best_of_the_year.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import classes.Movie;
import classes.Song;
import org.springframework.web.bind.annotation.RequestParam;




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
    
    //*****************MOVIES
    @GetMapping("/movies")
    public String moviesPage(Model model) {
            model.addAttribute("movies", getBestMovies());
            return "moviespage";
    }
    
    @GetMapping("/movies/{id}")
    public String showMoviePage(@PathVariable int id, Model model) {
            
            Movie specifiedMovie = null;
            
            ArrayList<Movie> filmList = getBestMovies();

            for (Movie movie : filmList) {
                if(movie.getId() == id){
                    specifiedMovie = movie; //Prende il primo film a cui corrisponde l'id, si parte dal presupposto che l'id è univoco e non debba prendere più di un film
                    break;
                }    
            }

        //Se specifiedMovie è null il film non è stato trovato
        if (specifiedMovie == null) {
            throw new IllegalArgumentException("Film non trovato.");
        }
            model.addAttribute("movie",specifiedMovie);

        return "showMoviePage";
    }
    
    private ArrayList<Movie> getBestMovies(){
        //Dichiaro la lista di canzoni
        ArrayList<Movie> listaFilm = new ArrayList<>();
    
        ArrayList<String> listaAttori = new ArrayList<>();
        listaAttori.add("Gianni");
        listaAttori.add("Gigi");
        listaAttori.add("Gino");
        Movie filmProva = new Movie(2, "Titolo di prova", listaAttori, "Paolo il direttore", "Trash productions", 1, 33);
        Movie filmDefault = new Movie();
    
        listaFilm.add(filmDefault);
        listaFilm.add(filmProva);

        return listaFilm;
    }
    

    //SONGS************************************************

    @GetMapping("/songs")
    public String songsPage(Model model) {
            model.addAttribute("songs",getBestSongs()); 
            return "songspage";
    }

    @GetMapping("/songs/{id}")
    public String showSongPage(@PathVariable int id, Model model) {
            
            Song specifiedSong = null;
            
            ArrayList<Song> songList = getBestSongs();

            for (Song song : songList) {
                if(song.getId() == id){
                    specifiedSong = song; //Prende il primo film a cui corrisponde l'id, si parte dal presupposto che l'id è univoco e non debba prendere più di un film
                    break;
                }    
            }

        //Se specifiedMovie è null il film non è stato trovato
        if (specifiedSong == null) {
            throw new IllegalArgumentException("Canzone non trovata.");
        }
        
        model.addAttribute("song",specifiedSong);

        return "showSongPage";
    }



    private ArrayList<Song> getBestSongs(){
        //Dichiaro la lista di canzoni
        ArrayList<Song> listaCanzoni = new ArrayList<>();
        
        //Dichiaro alcune canzoni
        ArrayList<String> listaArtisti = new ArrayList<>();
        listaArtisti.add("Scrittore");
        listaArtisti.add("Cantante");
        listaArtisti.add("Produttore");
        Song canzoneProva = new Song(2, "Titolo di prova", listaArtisti, "Etichetta di prova", 77);
        Song canzoneDefault = new Song();
        
        listaCanzoni.add(canzoneDefault);
        listaCanzoni.add(canzoneProva);

        return listaCanzoni;
    }

}
