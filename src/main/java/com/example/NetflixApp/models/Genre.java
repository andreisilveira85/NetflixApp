package com.example.NetflixApp.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing various genres of movies and series.
 */
public enum Genre {
    DRAMA("Drama"),
    COMEDY("Comedy"),
    HORROR("Horror"),
    ACTION("Action"),
    DOCUMENTARY("Documentary"),
    SCIENCE_FICTION("Science Fiction"),
    ANIMATION("Animation"),
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    FANTASY("Fantasy"),
    MUSICAL("Musical"),
    ADVENTURE("Adventure"),
    HISTORICAL("Historical"),
    BIOGRAPHY("Biography"),
    SPORTS("Sports");

    private final String genreName;

    /**
     * Constructs a genre with the specified name.
     * @param genreName The name of the genre.
     */
    Genre(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Returns the name of the genre.
     * @return The name of the genre, used in JSON serialization.
     */
    @JsonValue
    public String getGenreName() {
        return genreName;
    }

    @Override
    public String toString() {
        return genreName;
    }
}
