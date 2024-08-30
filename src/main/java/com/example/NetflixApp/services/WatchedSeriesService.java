package com.example.NetflixApp.services;

import com.example.NetflixApp.models.Series;
import com.example.NetflixApp.models.Watchable;
import com.example.NetflixApp.utilities.Colors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class for managing series that have been watched,
 * grouped by the number of times they have been viewed.
 */
public class WatchedSeriesService implements Watchable<Series> {
    private Map<Integer, List<Series>> series;

    /**
     * Initializes the service with a list of series.
     * @param list The initial list of series to manage.
     */
    public WatchedSeriesService(List<Series> list) {
        this.series = new HashMap<>();
        this.createList(list);
    }

    /**
     * Displays the list of series, grouped by the number of times they have been watched.
     */
    @Override
    public void showList() {
        series.forEach((timesWatched, seriesList) -> {
            System.out.println(Colors.TEXT_RED_BOLD + "Times Watched: " + timesWatched + Colors.TEXT_RESET);
            seriesList.forEach(series -> {
                series.displayDetails();
                System.out.println();
            });
        });
    }

    /**
     * Groups and creates a map of series based on the number of times each series has been watched.
     * @param list The list of series to group.
     */
    @Override
    public void createList(List<Series> list) {
        series = list.stream()
                .collect(Collectors.groupingBy(Series::getWatched));
    }
}

