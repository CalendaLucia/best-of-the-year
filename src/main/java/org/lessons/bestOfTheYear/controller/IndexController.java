package org.lessons.bestOfTheYear.controller;

import org.lessons.bestOfTheYear.models.Movie;
import org.lessons.bestOfTheYear.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//passo 1 - per dire a spring che questa classe è un controller dobbiamo usare un Annotations Controller
//passo 2 - possiamo dare qualche parametro in più dicendo che questa classe ha i metodi che
         // risponderanno ad una particolare rotta con l annotation requestMapping con parametri
//
@Controller // dice a Spring che questa classe è un Controller
@RequestMapping("/") // a quale rotta rispondono i metodi di questo Controller in questo caso alla root (pagina principale)
public class IndexController {

    //metodi controller
    @GetMapping // risponde a richieste di tipo HTTP GET
    //@ResponseBody // mette la stringa restituita direttamente nel body della response
    public String home(Model model) { //chiediamo a Spring di invocare questo metodo passandogli il Model
        String nome = "Lucia";
        model.addAttribute("nome", nome);
        return "index"; // ritorno il nome del tamplate index.html che si trova nella cartella resources/template
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> bestMovies = getBestMovies();
        List<String> movieTitles = new ArrayList<>();
        for (Movie movie : bestMovies) {
            movieTitles.add(movie.getTitolo());
        }
        model.addAttribute("movieTitles", movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> bestSongs = getBestSongs();
        List<String> songTitles = new ArrayList<>();
        for (Song song : bestSongs) {
            songTitles.add(song.getTitolo());
        }
        model.addAttribute("songTitles", songTitles);
        return "songs";

    }

    private List<Movie> getBestMovies() {
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie(1, "Le ali della libertà"));
        moviesList.add(new Movie(2, "Resident evils"));
        moviesList.add(new Movie(3, "Vi presento Joe Black"));
        moviesList.add(new Movie(4, "Papillon"));
        return  moviesList;
    }

    private List<Song> getBestSongs() {
        List<Song> songsList = new ArrayList<>();
        songsList.add(new Song(1, "Smells like Teen Spirit"));
        songsList.add(new Song(2, "Imagine"));
        songsList.add(new Song(3, "Bohemian Rhapsody"));
        songsList.add(new Song(4, "Respect"));
        return songsList;
    }


}
