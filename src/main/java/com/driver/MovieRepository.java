package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie>movieMap;
    private HashMap<String, Director>directorMap;
    private HashMap<String, List<String>>directorMovieMap;


    public MovieRepository() {
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMap = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> currentMovie = new ArrayList<>();
            if(directorMovieMap.containsKey(director)) currentMovie = directorMovieMap.get(director);
            currentMovie.add(movie);
            directorMovieMap.put(director,currentMovie);
        }
    }

    public Movie findMovie(String movie) {
        return movieMap.get(movie);
    }


    public Director findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMovieFromDirector(String director) {
        List<String> movieList = new ArrayList<>();
        if(directorMovieMap.containsKey(director)) movieList = directorMovieMap.get(director);
        return movieList;
    }

    public List<String> findAllMovie() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorByName(String director) {
        if(directorMap.containsKey(director) && directorMovieMap.containsKey(director)){
            for(String movie : directorMovieMap.get(director)) movieMap.remove(movie);
            directorMovieMap.remove(director);
        }
    }
    public void deleteAllDirectors() {
        for(String director : directorMap.keySet()){
            if(directorMap.containsKey(director)){
                for(String movie : directorMovieMap.get(director)){
                    movieMap.remove(movie);
                }
                directorMovieMap.remove(director);
            }
            else{
                directorMap.remove(director);
            }
        }
    }
}
