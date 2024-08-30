package com.example.NetflixApp.controllers;

import com.example.NetflixApp.controllers.interfaces.MediaController;
import com.example.NetflixApp.models.Series;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for managing series, implementing the MediaController interface.
 * Provides methods to add, remove, and query series, as well as update information.
 */
@Slf4j
public class SeriesController implements MediaController {
    private static final List<Series> seriesList = new CopyOnWriteArrayList<>();

    public SeriesController() {
    }

    public void addSeries(Series series) {
        seriesList.add(series);
        log.info("Series added: {}", series.getTitle());
    }

    public void removeSeries(Series series) {
        if (series != null && seriesList.remove(series)) {
            log.info("Series removed: {}", series.getTitle());
        } else {
            log.warn("Failed to remove series or series not found: {}", series.getTitle());
        }
    }

    public static List<Series> getSeriesList() {
        return Collections.unmodifiableList(seriesList);
    }

    public Series getSeries(int id) {
        return seriesList.stream()
                .filter(series -> series.getId() == id)
                .findFirst().orElse(null);
    }

    public Series getSeries(String title) {
        return seriesList.stream()
                .filter(series -> series.getTitle().equals(title))
                .findFirst().orElse(null);
    }

    public void printSeries() {
        log.info("Available series:");
        seriesList.forEach(series -> log.info("{} - {}", series.getId(), series.getTitle()));
    }

    public boolean existTitle(String title) {
        return seriesList.stream().anyMatch(series -> series.getTitle().equals(title));
    }

    public void updateTitle(Series series, String newTitle) {
        if (series != null) {
            log.info("Updating title of series from {} to {}", series.getTitle(), newTitle);
            series.setTitle(newTitle);
        }
    }

    public LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public boolean seriesListIsEmpty() {
        return seriesList.isEmpty();
    }

    @Override
    public List<Series> getMostWatched() {
        return List.of();
    }
}
