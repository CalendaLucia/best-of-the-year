package org.lessons.bestOfTheYear.controller;

import org.lessons.bestOfTheYear.models.Movie;
import org.lessons.bestOfTheYear.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

//passo 1 - per dire a spring che questa classe è un controller dobbiamo usare un Annotations Controller
//passo 2 - possiamo dare qualche parametro in più dicendo che questa classe ha i metodi che
         // risponderanno ad una particolare rotta con l annotation requestMapping con parametri

@Controller                        // dice a Spring che questa classe è un Controller
@RequestMapping("/")              // a quale rotta rispondono i metodi di questo Controller in questo caso alla root
public class IndexController {

                                    //metodi controller
    @GetMapping
    public String home(Model model) {      //chiediamo a Spring di invocare questo metodo passandogli il Model
        String nome = "Lucia";
        model.addAttribute("nome", nome);
        return "index";    // ritorno il nome del tamplate index.html che si trova nella cartella resources/template
    }

    @GetMapping("/movies")   // dico a Spring che il metodo deve essere chiamato solo quando arriva una richiesta HTTP di tipo GET a un percorso specifico.
    public String getMovies (Model model) {
        List<Movie> bestMovies = getBestMovies();                          // Ottiene la lista dei migliori film
        model.addAttribute("movieTitles", bestMovies);        // Aggiunge la lista movieTitles al model
        model.addAttribute("movie", true);       //
        return "movies";                                                // ritorno il nome del tamplate movies.html
    }


    //METODO CHE PORTA ALLA PAGINA DI DETTAGLIO DEI FILMS
    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable Integer id, Model model) {
        //recupero l'id del film dal path
        Movie currentMovie = null;
        for (Movie movie: getBestMovies()) {
            if (movie.getId() == id) {
                currentMovie = movie;
            }
        }
        // aggiungo il nome del film al model
        model.addAttribute("movie", currentMovie);
        return "detail";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> bestSongs = getBestSongs();
        model.addAttribute("songTitles", bestSongs);
        model.addAttribute("song", true);
        return "songs";// ritorno il nome del tamplate songs.html
    }

    //METODO CHE PORTA ALLA PAGINA DI DETTAGLIO DELLE SONGS
    @GetMapping("songs/{id}")
    public String songDetail(@PathVariable Integer id, Model model) {
        //recupero l'id delle song dal path
        Song currentSong = null;
        for (Song song: getBestSongs()) {
            if (song.getId() == id) {
                currentSong = song;
            }
        }
        // aggiungo il nome del film al model
        model.addAttribute("song", currentSong);
        return "detail";
    }





    // Metodo privato che restituisce una lista di oggetti Movie
    private List<Movie> getBestMovies() {
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie(1, "Le ali della libertà"));
        moviesList.add(new Movie(2, "Resident evil"));
        moviesList.add(new Movie(3, "Vi presento Joe Black"));
        moviesList.add(new Movie(4, "Papillon"));
        return  moviesList;  // Restituisce la lista dei migliori film
    }

    // Metodo privato che restituisce una lista di oggetti Song
    private List<Song> getBestSongs() {
        List<Song> songsList = new ArrayList<>();
        songsList.add(new Song(1, "Smells like Teen Spirit"));
        songsList.add(new Song(2, "Imagine"));
        songsList.add(new Song(3, "Bohemian Rhapsody"));
        songsList.add(new Song(4, "Respect"));
        return songsList;
    }


}
