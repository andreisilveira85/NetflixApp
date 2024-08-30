package com.example.NetflixApp.services;

import com.example.NetflixApp.models.Episode;
import com.example.NetflixApp.models.Season;
import com.example.NetflixApp.models.Series;
import java.util.List;

/**
 * Service class for managing seasons within a series.
 */
public class SeasonService {

    public SeasonService() {
    }

    /**
     * Returns the size of the season list.
     * @param seasonList The list of seasons.
     * @return The number of seasons in the list.
     */
    public int seasonListSize(List<Season> seasonList) {
        return seasonList.size();
    }

    /**
     * Prints all seasons in the season list.
     * @param seasonList The list of seasons to print.
     */
    public void printSeasons(List<Season> seasonList) {
        int seasonListSize = seasonListSize(seasonList);

        for (int i = 0; i < seasonListSize; i++) {
            System.out.println("Season " + (i + 1));
        }
    }

    /**
     * Prints all episodes in a single season.
     * @param season The season to print episodes from.
     */
    public void printSeason(Season season) {
        int episodeListSize = season.getEpisodes().size();
        for (int i = 0; i < episodeListSize; i++) {
            System.out.println("Episode - " + (i + 1) +
                    " Title - " + season.getEpisodes().get(i).getTitle());
        }
    }

    /**
     * Retrieves a season by index from a list of seasons.
     * @param seasonList The list of seasons.
     * @param id The index of the season to retrieve.
     * @return The season at the specified index.
     */
    public Season getSeason(List<Season> seasonList, int id) {
        if (id >= 0 && id < seasonList.size()) {
            return seasonList.get(id);
        } else {
            throw new IndexOutOfBoundsException("Invalid season index.");
        }
    }

    /**
     * Checks if the season list is empty.
     * @param seasonList The list of seasons.
     * @return true if the list is empty, false otherwise.
     */
    public boolean seasonListIsEmpty(List<Season> seasonList) {
        return seasonList.isEmpty();
    }

    /**
     * Adds a new season to a series.
     * @param series The series to which the season will be added.
     * @param episodeList The list of episodes for the new season.
     */
    public void addSeason(Series series, List<Episode> episodeList) {
        if (series != null && episodeList != null && !episodeList.isEmpty()) {
            Season newSeason = new Season(episodeList); // Create a new Season with the provided episodes
            series.getSeasonList().add(newSeason);      // Add the new Season to the series
        } else {
            throw new IllegalArgumentException("Series or episode list cannot be null or empty.");
        }
    }

    /**
     * Removes a season from a series.
     * @param series The series from which the season will be removed.
     * @param season The season to be removed.
     */
    public void removeSeason(Series series, Season season) {
        series.getSeasonList().remove(season);
    }
}
