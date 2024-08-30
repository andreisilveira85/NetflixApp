package com.example.NetflixApp.models;

import com.example.NetflixApp.util.CounterIds;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an episode in a series with a title, preview text, and episode number.
 */
@Entity
@Table(name = "episodes")
@Getter
@Setter
@ToString
public class Episode {

    private String title;

    private String preview;

    private final Integer number;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Constructs a new Episode with specified title, preview, and episode number.
     * @param title The title of the episode.
     * @param preview A brief preview or summary of the episode.
     * @param number The episode number within its series.
     */
    public Episode(String title, String preview, Integer number) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (number == null || number < 1) {
            throw new IllegalArgumentException("Episode number must be positive");
        }

        this.title = title;
        this.preview = preview;
        this.number = number;
        this.id = CounterIds.getNextEpisodeId();
    }
}


