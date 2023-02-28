package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam() String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie and director added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie){
        Movie movie1 = movieService.getMovieByName(movie);
        return new ResponseEntity<>(movie1, HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name") String director){
        Director director1 = movieService.getDirectorByName(director);
        return new ResponseEntity<>(director1, HttpStatus.CREATED);
    }

    @GetMapping("/get_movies_by_director_name/{director}")
    public ResponseEntity<List<String>> getMovieByDirectorName(@PathParam("director") String directorName){
        List<String> listOfMovie = new ArrayList<>();
        listOfMovie = movieService.getListOfMovie(directorName);
        return new ResponseEntity<>(listOfMovie, HttpStatus.CREATED);
    }
     @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> getAllMovies(){
        List<String> listOfAllMovie = new ArrayList<>();
        listOfAllMovie = movieService.getAllMovie();
        return new ResponseEntity<>(listOfAllMovie, HttpStatus.CREATED);
     }
     @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Movie deleted successfully", HttpStatus.CREATED);
     }

     @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Movie and Director removed successfully",HttpStatus.CREATED);
     }
}
