package com.example.NetflixApp.utilities;

import lombok.Getter;
import lombok.Setter;

/**
 * Utility class for generating unique IDs for various entities in the application.
 * The class is thread-safe, ensuring that ID generation is synchronized.
 */
public class CounterIds {

    @Getter @Setter
    private static Long userId = 0L;

    @Getter @Setter
    private static Long seriesId = 0L;

    @Getter @Setter
    private static Long seasonId = 0L;

    @Getter @Setter
    private static Long episodeId = 0L;

    @Getter @Setter
    private static Long movieId = 0L;

    /**
     * Generates the next unique user ID.
     * @return The next user ID.
     */
    public static synchronized Long getNextUserId() {
        return ++userId;
    }

    /**
     * Generates the next unique series ID.
     * @return The next series ID.
     */
    public static synchronized Long getNextSeriesId() {
        return ++seriesId;
    }

    /**
     * Generates the next unique season ID.
     * @return The next season ID.
     */
    public static synchronized Long getNextSeasonId() {
        return ++seasonId;
    }

    /**
     * Generates the next unique episode ID.
     * @return The next episode ID.
     */
    public static synchronized Long getNextEpisodeId() {
        return ++episodeId;
    }

    /**
     * Generates the next unique movie ID.
     * @return The next movie ID.
     */
    public static synchronized Long getNextMovieId() {
        return ++movieId;
    }
}
