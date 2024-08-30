package com.example.NetflixApp.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "series")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Genre genre;

    @JsonIgnore
    private int watched;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasonList = new ArrayList<>();

    /**
     * Constructs a new Series with specified title, release date, and genre.
     * Initializes an empty list of seasons.
     *
     * @param title The title of the series.
     * @param date The release date of the series.
     * @param genre The genre of the series.
     */
    public Series(String title, LocalDate date, Genre genre) {
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.watched = 0;
    }

    /**
     * Adds a season to the series.
     *
     * @param season The season to add.
     */
    public void addSeason(Season season) {
        seasonList.add(season);
    }

    /**
     * Displays the list of genres available for the series.
     */
    public void showGenreList() {
        System.out.println("Available genres: Action, Comedy, Drama, etc.");
    }

    /**
     * Prints detailed information about the series.
     */
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre.getGenreName());
        System.out.println("Date: " + date);
        System.out.println("Number of Seasons: " + seasonList.size());
    }
}
