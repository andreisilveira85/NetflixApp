package com.example.NetflixApp.views;

import com.example.NetflixApp.models.Episode;
import com.example.NetflixApp.models.Series;
import com.example.NetflixApp.services.EpisodeService;
import com.example.NetflixApp.util.Colors;
import com.example.NetflixApp.util.ScanValidation;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the episode menu options for a given series and season.
 */
@RequiredArgsConstructor
public class EpisodeMenu {

    private final EpisodeService episodeService = new EpisodeService();
    private int episodeInt = 0;

    /**
     * Displays the episode menu and handles user input.
     * @param series The series to manage.
     * @param seasonId The season ID within the series.
     */
    public void show(Series series, int seasonId) {
        SeasonMenu seasonMenu = new SeasonMenu();
        List<Episode> episodeList = series.getSeasonList().get(seasonId).getEpisodes();

        boolean active = true;

        while (active) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                    Episodes Menu                     
                                                                     
                *****************************************************
                            1 - Add episode               
                            2 - Update episode              
                            3 - Remove episode             
                            4 - View episode details
                            5 - Back to season menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    newEpisodeOption(episodeList);
                    active = false;
                    show(series, seasonId);
                }
                case 2 -> {
                    if (episodeList.isEmpty()) {
                        System.out.println("Episode list is empty!\n");
                    } else {
                        updateOptions(series, episodeList, seasonId);
                        active = false;
                        show(series, seasonId);
                    }
                }
                case 3 -> {
                    if (episodeList.isEmpty()) {
                        System.out.println("Episode list is empty!\n");
                    } else {
                        removeEpisodeOption(episodeList);
                        active = false;
                        show(series, seasonId);
                    }
                }
                case 4 -> {
                    if (episodeList.isEmpty()) {
                        System.out.println("Episode list is empty!\n");
                    } else {
                        printEpisodeDetails(episodeList);
                    }
                }
                case 5 -> {
                    seasonMenu.show(series);
                    active = false;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Prints details of a selected episode.
     * @param episodeList The list of episodes.
     */
    public void printEpisodeDetails(List<Episode> episodeList) {
        System.out.println(pickAEpisode(episodeList).toString());
    }

    /**
     * Allows the user to select an episode from the list.
     * @param episodeList The list of episodes.
     * @return The selected episode.
     */
    public Episode pickAEpisode(List<Episode> episodeList) {
        System.out.println("Select an episode:");
        episodeService.printEpisodes(episodeList);
        System.out.println("Your option:");
        int option = ScanValidation.getValidIntBetweenInput(new Scanner(System.in), 1, episodeList.size());
        episodeInt = option;

        return episodeService.getEpisode(episodeList, (option - 1));
    }

    /**
     * Adds a new episode to the list.
     * @param episodeList The list of episodes.
     */
    public void newEpisodeOption(List<Episode> episodeList) {
        Episode newEpisode = makeEpisode(episodeList.size() + 1);
        episodeService.addEpisode(episodeList, newEpisode);
    }

    /**
     * Creates a new episode with user-provided details.
     * @param number The episode number.
     * @return The created episode.
     */
    public Episode makeEpisode(Integer number) {
        System.out.println("Enter the episode title:");
        String title = ScanValidation.getValidStringInput(new Scanner(System.in), 1);
        System.out.println("Enter the episode summary:");
        String preview = ScanValidation.getValidStringInput(new Scanner(System.in), 25);
        return new Episode(title, preview, number);
    }

    /**
     * Retrieves the index of an episode selected by the user.
     * @param episodeList The list of episodes.
     * @return The index of the selected episode.
     */
    public int getEpisodeIndex(List<Episode> episodeList) {
        episodeService.printEpisodes(episodeList);
        System.out.println("Your option:");
        return ScanValidation.getValidIntBetweenInput(new Scanner(System.in), 1, episodeList.size()) - 1;
    }

    /**
     * Removes an episode from the list.
     * @param episodeList The list of episodes.
     */
    public void removeEpisodeOption(List<Episode> episodeList) {
        int episodeIndex = getEpisodeIndex(episodeList);
        episodeService.removeEpisode(episodeList, episodeIndex);
        System.out.println("Episode successfully removed.\n");
    }

    /**
     * Updates an episode's title and/or summary.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to update.
     */
    public void updateEpisode(List<Episode> episodeList, int episodeIndex) {
        updateTitle(episodeList, episodeIndex);
        updatePreview(episodeList, episodeIndex);
    }

    /**
     * Updates the title of an episode.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to update.
     */
    public void updateTitle(List<Episode> episodeList, int episodeIndex) {
        System.out.println("Enter the episode title:");
        String title = ScanValidation.getValidStringInput(new Scanner(System.in), 1);
        episodeService.updateTitle(episodeList, episodeIndex, title);
    }

    /**
     * Updates the summary of an episode.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to update.
     */
    public void updatePreview(List<Episode> episodeList, int episodeIndex) {
        System.out.println("Enter the episode summary:");
        String preview = ScanValidation.getValidStringInput(new Scanner(System.in), 25);
        episodeService.updatePreview(episodeList, episodeIndex, preview);
    }

    /**
     * Displays update options for an episode and processes user input.
     * @param series The series containing the episodes.
     * @param episodeList The list of episodes.
     * @param seasonId The season ID within the series.
     */
    public void updateOptions(Series series, List<Episode> episodeList, int seasonId) {
        int episodeIndex = getEpisodeIndex(episodeList);

        boolean validInput = false;

        while (!validInput) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                  Update Episode                     
                                                                     
                *****************************************************
                            1 - Title               
                            2 - Summary              
                            3 - Title and summary             
                            4 - View episode details
                            5 - Back to episode menu
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            switch (ScanValidation.getValidIntInput(new Scanner(System.in))) {
                case 1 -> {
                    updateTitle(episodeList, episodeIndex);
                    validInput = true;
                }
                case 2 -> {
                    updatePreview(episodeList, episodeIndex);
                    validInput = true;
                }
                case 3 -> {
                    updateEpisode(episodeList, episodeIndex);
                    validInput = true;
                }
                case 4 -> {
                    show(series, seasonId);
                    validInput = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }
}
