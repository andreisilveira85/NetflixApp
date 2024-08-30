package com.example.NetflixApp.models;

import com.example.NetflixApp.util.CounterIds;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Genre genre;

    @JsonIgnore
    private int watched;

    private int duration;

    /**
     * Constructs a new Movie with specified title, release date, genre, and duration.
     * @param title The title of the movie.
     * @param date The release date of the movie.
     * @param genre The genre of the movie.
     * @param duration The duration of the movie in minutes.
     */
    public Movie(String title, LocalDate date, Genre genre, int duration) {
        this.id = CounterIds.getNextMovieId();
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.duration = duration;
        this.watched = 0;
    }

    /**
     * Displays the list of genres available for the movie.
     */
    public void showGenreList() {
        System.out.println("Available genres: Action, Comedy, Drama, etc.");
    }

    /**
     * Prints detailed information about the movie.
     */
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre.getGenreName());
        System.out.println("Date: " + date);
        System.out.println("Duration: " + duration + " minutes");
    }
}

