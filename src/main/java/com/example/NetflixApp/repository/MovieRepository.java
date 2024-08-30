package com.example.NetflixApp.repository;

import com.example.NetflixApp.models.Movie;
import java.util.List;

/**
 * Repository interface for managing Movie objects.
 * Defines methods for adding, listing, finding, removing, and updating movies.
 */
public interface MovieRepository {

    /**
     * Adds a new movie to the repository.
     * @param movie The Movie object to be added.
     */
    void addMovie(Movie movie);

    /**
     * Retrieves a list of all movies in the repository.
     * @return A List of Movie objects.
     */
    List<Movie> listMovies();

    /**
     * Finds a movie by its title.
     * @param title The title of the movie to find.
     * @return The Movie object if found, or null otherwise.
     */
    Movie findMovieByTitle(String title);

    /**
     * Removes a movie from the repository based on its title.
     * @param title The title of the movie to be removed.
     */
    void removeMovieByTitle(String title);

    /**
     * Updates the details of a movie in the repository.
     * @param movie The Movie object containing updated information.
     */
    void updateMovie(Movie movie);
}
