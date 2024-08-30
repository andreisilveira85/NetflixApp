package com.example.NetflixApp.services;

import com.example.NetflixApp.models.Watchable;
import com.example.NetflixApp.models.Movie;
import com.example.NetflixApp.util.Colors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class for managing movies that have been watched,
 * grouped by the number of times they have been viewed.
 */
public class WatchedMovieService implements Watchable<Movie> {
    private static Map<Integer, List<Movie>> movies;

    /**
     * Initializes the service with a list of movies.
     * @param list The initial list of movies to manage.
     */
    public WatchedMovieService(List<Movie> list) {
        movies = new HashMap<>();
        this.createList(list);
    }

    /**
     * Displays the list of movies, grouped by the number of times they have been watched,
     * using different colors for the count.
     */
    @Override
    public void showList() {
        movies.forEach((timesWatched, movieList) -> {
            System.out.println(Colors.TEXT_RED_BOLD + "Times Watched: " + timesWatched + Colors.TEXT_RESET);
            movieList.forEach(movie -> {
                movie.displayDetails();
                System.out.println();
            });
        });
    }

    /**
     * Groups and creates a map of movies based on the number of times each movie has been watched.
     * @param list The list of movies to group.
     */
    @Override
    public void createList(List<Movie> list) {
        movies = list.stream()
                .collect(Collectors.groupingBy(Movie::getWatched));
    }
}
