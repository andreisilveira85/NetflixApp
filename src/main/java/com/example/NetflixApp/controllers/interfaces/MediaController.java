package com.example.NetflixApp.controllers.interfaces;

import java.util.List;

/**
 * Defines the contract for media controllers to retrieve lists of media items,
 * specifically to identify the most watched items in a category.
 * @param <T> The type of media item managed by the controller.
 */
public interface MediaController<T> {

    /**
     * Retrieves a list of the most watched media items.
     * Implementations should provide logic to accurately fetch media items based on
     * viewership or usage statistics.
     *
     * @return A list of the most watched media items of type T.
     */
    List<T> getMostWatched();
}
