package com.example.NetflixApp.controllers;

import com.example.NetflixApp.controllers.interfaces.MediaController;
import com.example.NetflixApp.models.Movie;
import com.example.NetflixApp.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Controller class for managing movies. Implements MovieRepository and MediaController interfaces.
 */
@Slf4j
public class MovieController implements MovieRepository, MediaController {
    private static final List<Movie> movies = new CopyOnWriteArrayList<>();

    public MovieController() {
    }

    @Override
    public void addMovie(Movie movie) {
        if (movie != null) {
            movies.add(movie);
            log.info("Movie added: {}", movie.getTitle());
        } else {
            log.warn("Attempted to add null movie");
        }
    }

    @Override
    public List<Movie> listMovies() {
        return new ArrayList<>(movies);
    }

    @Override
    public Movie findMovieByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void removeMovieByTitle(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null && movies.remove(movie)) {
            log.info("Movie removed: {}", title);
        } else {
            log.error("Movie not found to remove: {}", title);
        }
    }

    @Override
    public void updateMovie(Movie updatedMovie) {
        movies.replaceAll(movie -> movie.getTitle().equalsIgnoreCase(updatedMovie.getTitle()) ? updatedMovie : movie);
    }

    public void listAllMovies() {
        if (movies.isEmpty()) {
            log.info("No movies registered!");
        } else {
            movies.forEach(movie -> {
                movie.displayDetails();
                log.info("");
            });
        }
    }

    public Movie getMovieByTitle(String title) {
        return findMovieByTitle(title);
    }

    @Override
    public List<Movie> getMostWatched() {
        return List.of();
    }
}
