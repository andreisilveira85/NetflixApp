package com.example.NetflixApp.menus;

import com.example.NetflixApp.models.Episode;
import com.example.NetflixApp.models.Season;
import com.example.NetflixApp.models.Series;
import com.example.NetflixApp.services.SeasonService;
import com.example.NetflixApp.utilities.Colors;
import com.example.NetflixApp.utilities.ScanValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the season menu for a specific series.
 */
public class SeasonMenu {
    private int seasonIndex = 0;

    /**
     * Displays the season menu for the given series and processes user input.
     * @param series The series for which the seasons are managed.
     */
    public void show(Series series) {
        SeriesMenu seriesMenu = new SeriesMenu();
        SeasonService seasonService = new SeasonService();

        boolean validInput = false;

        while (!validInput) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                      Seasons Menu                   
                                                                     
                *****************************************************
                              1 - Add season                       
                              2 - Update season               
                              3 - Remove season              
                              4 - View season details
                              5 - Back to series menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    newSeasonOption(series);
                    validInput = true;
                    show(series);
                }
                case 2 -> {
                    if (seasonService.seasonListIsEmpty(series.getSeasonList())) {
                        System.out.println("The season list is empty!\n");
                    } else {
                        pickASeason(series.getSeasonList());
                        updateSeasonOption(series);
                        validInput = true;
                        show(series);
                    }
                }
                case 3 -> {
                    if (seasonService.seasonListIsEmpty(series.getSeasonList())) {
                        System.out.println("The season list is empty!\n");
                    } else {
                        Season season = pickASeason(series.getSeasonList());
                        removeSeasonOption(series, season);
                        validInput = true;
                        show(series);
                    }
                }
                case 4 -> {
                    if (seasonService.seasonListIsEmpty(series.getSeasonList())) {
                        System.out.println("The season list is empty!\n");
                    } else {
                        Season season = pickASeason(series.getSeasonList());
                        printSeasonDetails(season);
                        validInput = true;
                        show(series);
                    }
                }
                case 5 -> {
                    seriesMenu.adminMenu();
                    validInput = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Prints the details of the selected season.
     * @param season The season to display.
     */
    public void printSeasonDetails(Season season) {
        SeasonService seasonService = new SeasonService();

        System.out.println("Season - " + seasonIndex);
        seasonService.printSeason(season);
    }

    /**
     * Allows the user to select a season from the list.
     * @param seasonList The list of seasons.
     * @return The selected season.
     */
    public Season pickASeason(List<Season> seasonList) {
        SeasonService seasonService = new SeasonService();

        System.out.println("Select a season:");
        seasonService.printSeasons(seasonList);
        System.out.println("Your option:");
        int option = ScanValidation.getValidIntBetweenInput(new Scanner(System.in), 1, seasonList.size());
        seasonIndex = option;

        return seasonService.getSeason(seasonList, (option - 1));
    }

    /**
     * Adds a new season to the series with the specified number of episodes.
     * @param series The series to which the season is added.
     */
    public void newSeasonOption(Series series) {
        EpisodeMenu episodeMenu = new EpisodeMenu();
        List<Episode> newEpisodeList = new ArrayList<>();

        System.out.println("How many episodes will the season have?");
        int episodeNum = ScanValidation.getValidIntInput(new Scanner(System.in));

        for (int i = 0; i < episodeNum; i++) {
            newEpisodeList.add(episodeMenu.makeEpisode(i + 1));
        }

        SeasonService seasonService = new SeasonService();
        seasonService.addSeason(series, newEpisodeList);
        System.out.println("Season added successfully.");
    }

    /**
     * Updates the selected season by managing its episodes.
     * @param series The series to which the season belongs.
     */
    public void updateSeasonOption(Series series) {
        EpisodeMenu episodeMenu = new EpisodeMenu();

        episodeMenu.show(series, (seasonIndex - 1));
    }

    /**
     * Removes the selected season from the series.
     * @param series The series from which the season is removed.
     * @param season The season to be removed.
     */
    public void removeSeasonOption(Series series, Season season) {
        SeasonService seasonService = new SeasonService();
        seasonService.removeSeason(series, season);
        System.out.println("Season removed successfully.\n");
    }
}
