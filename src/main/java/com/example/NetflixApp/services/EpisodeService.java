package com.example.NetflixApp.services;

import com.example.NetflixApp.models.Episode;
import java.util.List;

/**
 * Service class for managing operations on a list of episodes.
 */
public class EpisodeService {

    /**
     * Adds an episode to the episode list.
     * @param episodeList The list of episodes.
     * @param episode The episode to add.
     */
    public void addEpisode(List<Episode> episodeList, Episode episode) {
        episodeList.add(episode);
    }

    /**
     * Updates the title of a specific episode in the list.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to update.
     * @param title The new title for the episode.
     */
    public void updateTitle(List<Episode> episodeList, int episodeIndex, String title) {
        if (episodeIndex >= 0 && episodeIndex < episodeList.size()) {
            episodeList.get(episodeIndex).setTitle(title);
        } else {
            throw new IndexOutOfBoundsException("Invalid episode index.");
        }
    }

    /**
     * Updates the preview text of a specific episode in the list.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to update.
     * @param preview The new preview text for the episode.
     */
    public void updatePreview(List<Episode> episodeList, int episodeIndex, String preview) {
        if (episodeIndex >= 0 && episodeIndex < episodeList.size()) {
            episodeList.get(episodeIndex).setPreview(preview);
        } else {
            throw new IndexOutOfBoundsException("Invalid episode index.");
        }
    }

    /**
     * Removes an episode from the list by index.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to remove.
     */
    public void removeEpisode(List<Episode> episodeList, int episodeIndex) {
        if (episodeIndex >= 0 && episodeIndex < episodeList.size()) {
            episodeList.remove(episodeIndex);
        } else {
            throw new IndexOutOfBoundsException("Invalid episode index.");
        }
    }

    /**
     * Prints all episodes in the list.
     * @param episodeList The list of episodes to print.
     */
    public void printEpisodes(List<Episode> episodeList) {
        if (episodeList.isEmpty()) {
            System.out.println("No episodes registered.");
        } else {
            for (int i = 0; i < episodeList.size(); i++) {
                System.out.println("Episode " + (i + 1) + " Title - " + episodeList.get(i).getTitle());
            }
        }
    }

    /**
     * Retrieves an episode by index.
     * @param episodeList The list of episodes.
     * @param episodeIndex The index of the episode to retrieve.
     * @return The episode at the specified index.
     */
    public Episode getEpisode(List<Episode> episodeList, int episodeIndex) {
        if (episodeIndex >= 0 && episodeIndex < episodeList.size()) {
            return episodeList.get(episodeIndex);
        } else {
            throw new IndexOutOfBoundsException("Invalid episode index.");
        }
    }
}
