package com.example.NetflixApp.views;

import com.example.NetflixApp.controllers.SeriesController;
import com.example.NetflixApp.models.Series;
import com.example.NetflixApp.models.Genre;
import com.example.NetflixApp.services.WatchedSeriesService;
import com.example.NetflixApp.util.ScanValidation;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the menu operations for series management.
 */
public class SeriesMenu {
    private final SeriesController seriesController = new SeriesController();

    /**
     * Displays the admin menu and processes user input.
     */
    public void adminMenu() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                *****************************************************
                                                                     
                                     Series Menu                     
                                                                     
                *****************************************************
                              1 - Add series                       
                              2 - Update series               
                              3 - Remove series              
                              4 - View series details
                              5 - Most watched series
                              6 - Back to main menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    newSeriesOption();
                    validInput = true;
                    adminMenu();
                }
                case 2 -> {
                    if (seriesController.seriesListIsEmpty()) {
                        System.out.println("The series list is empty!\n");
                    } else {
                        Series pickedSeries = pickASeries();
                        updateOptions(pickedSeries);
                        validInput = true;
                    }
                    adminMenu();
                }
                case 3 -> {
                    if (seriesController.seriesListIsEmpty()) {
                        System.out.println("The series list is empty!\n");
                    } else {
                        Series pickedSeries = pickASeries();
                        seriesController.removeSeries(pickedSeries);
                        System.out.println("Series removed successfully!\n");
                        validInput = true;
                    }
                    adminMenu();
                }
                case 4 -> {
                    if (seriesController.seriesListIsEmpty()) {
                        System.out.println("The series list is empty!\n");
                    } else {
                        printSeriesDetails();
                    }
                }
                case 5 -> {
                    mostWatchedOption();
                    NetflixMenu.keyPress();
                }
                case 6 -> {
                    NetflixMenu.mainMenu();
                    validInput = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Displays the client menu and processes user input.
     */
    public void clientMenu() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                *****************************************************
                                                                     
                                     Series Menu                     
                                                                     
                *****************************************************
                              1 - List all series                       
                              2 - Search series by title               
                              3 - Watch series              
                              4 - Most watched series
                              5 - Back to main menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    seriesController.printSeries();
                    validInput = true;
                    clientMenu();
                }
                case 2 -> {
                    getSeriesByTitle();
                    validInput = true;
                    clientMenu();
                }
                case 3 -> {
                    watchSeriesOption();
                    validInput = true;
                    clientMenu();
                }
                case 4 -> {
                    mostWatchedOption();
                    NetflixMenu.keyPress();
                }
                case 5 -> NetflixMenu.mainMenu();
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Prompts the user to search for a series by title.
     */
    public void getSeriesByTitle() {
        System.out.println("Enter the title: ");
        String title = ScanValidation.getValidStringInput(new Scanner(System.in), 4);
        Series series = seriesController.getSeries(title);

        if (series != null) {
            System.out.println(series);
        } else {
            System.out.println("Series not found!\n");
        }
    }

    /**
     * Adds a new series to the list.
     */
    public void newSeriesOption() {
        String title = "";
        LocalDate date = null;
        int genreIndex = 0;

        System.out.println("Enter the series title: ");
        title = ScanValidation.getValidStringInput(new Scanner(System.in), 5);
        date = newDate();
        genreIndex = genreOptions();

        seriesController.addSeries(new Series(title, date, Genre.values()[genreIndex - 1]));
        System.out.println("Series: " + title + " added successfully.");
    }

    /**
     * Displays the available genre options and returns the user's choice.
     * @return The selected genre index.
     */
    public int genreOptions() {
        List<String> genreList = Arrays.stream(Genre.values()).map(Genre::getGenreName).toList();

        System.out.println("\nAvailable genres:");
        for (int i = 0; i < genreList.size(); i++) {
            System.out.println((i + 1) + " - " + genreList.get(i));
        }

        System.out.println("\nYour option: ");
        return ScanValidation.getValidIntBetweenInput(new Scanner(System.in), 1, genreList.size());
    }

    /**
     * Prints the details of the selected series.
     */
    public void printSeriesDetails() {
        System.out.println("\n" + pickASeries());
    }

    /**
     * Prompts the user to select a series from the list.
     * @return The selected series.
     */
    public Series pickASeries() {
        System.out.println("Select a series:");
        seriesController.printSeries();
        System.out.println("Your option:");
        int option = ScanValidation.getValidIntInput(new Scanner(System.in));

        return seriesController.getSeries(option);
    }

    /**
     * Updates the selected series based on user input.
     * @param series The series to update.
     */
    public void updateOptions(Series series) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                *****************************************************
                                                                     
                                     Update Series                    
                                                                     
                *****************************************************
                              1 - Update title                       
                              2 - Update release date               
                              3 - Update title and release date              
                              4 - Manage seasons
                              5 - Back to series menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    updateTitleOption(series);
                    validInput = true;
                }
                case 2 -> {
                    updateDateOption(series);
                    validInput = true;
                }
                case 3 -> {
                    updateSeriesOption(series);
                    validInput = true;
                }
                case 4 -> {
                    SeasonMenu seasonMenu = new SeasonMenu();
                    seasonMenu.show(series);
                    validInput = true;
                }
                case 5 -> {
                    adminMenu();
                    validInput = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Updates the title of the selected series.
     * @param series The series to update.
     */
    public void updateTitleOption(Series series) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter the new title: ");
            String newTitle = ScanValidation.getValidStringInput(new Scanner(System.in), 4);

            if (!seriesController.existTitle(newTitle)) {
                seriesController.updateTitle(series, newTitle);
                System.out.println("Title updated successfully!\n");
                validInput = true;
            } else {
                System.out.println("A series with this title already exists, please try again.\n");
            }
        }
    }

    /**
     * Updates the release date of the selected series.
     * @param series The series to update.
     */
    public void updateDateOption(Series series) {
        series.setDate(newDate());
    }

    /**
     * Prompts the user to enter a new release date.
     * @return The new release date.
     */
    public LocalDate newDate() {
        System.out.println("Enter the release day: ");
        String day = ScanValidation.getValidDayInput(new Scanner(System.in));
        System.out.println("Enter the release month: ");
        String month = ScanValidation.getValidMonthInput(new Scanner(System.in));
        System.out.println("Enter the release year: ");
        String year = ScanValidation.getValidYearInput(new Scanner(System.in));

        return seriesController.formatDate(day + month + year);
    }

    /**
     * Updates both the title and release date of the selected series.
     * @param series The series to update.
     */
    public void updateSeriesOption(Series series) {
        updateTitleOption(series);
        updateDateOption(series);
    }

    /**
     * Allows the user to watch a series by title.
     */
    private void watchSeriesOption() {
        String title;

        seriesController.printSeries();
        NetflixMenu.keyPress();
        while (true) {
            System.out.println("Which series would you like to watch? Enter 'S' to exit.");
            title = ScanValidation.getValidStringInput(new Scanner(System.in), 1);
            Series series = seriesController.getSeries(title);
            if (series != null) {
                System.out.println("Watching series: " + series.getTitle());
                series.setWatched(series.getWatched() + 1);
                break;
            }
            if (title.equalsIgnoreCase("S")) {
                break;
            }
            System.out.println("Series not found");
        }
    }

    /**
     * Displays the most-watched series.
     */
    private void mostWatchedOption() {
        WatchedSeriesService watchedSeriesService = new WatchedSeriesService(SeriesController.getSeriesList());
        watchedSeriesService.showList();
    }
}
