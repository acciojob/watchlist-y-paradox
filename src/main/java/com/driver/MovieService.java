package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String movie){
        return movieRepository.findMovie(movie);
    }

    public Director getDirectorByName(String director) {
        return movieRepository.findDirector(director);
    }

    public List<String> getListOfMovie(String director) {
        return movieRepository.findMovieFromDirector(director);
    }

    public List<String> getAllMovie() {
        return movieRepository.findAllMovie();
    }

    public void deleteMovie(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
