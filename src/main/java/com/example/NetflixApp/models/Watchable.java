package com.example.NetflixApp.models;

import java.util.List;

/**
 * Interface for objects that are watchable, allowing for management of a list of items.
 * @param <T> the type of elements that this watchable object handles in its list.
 */
public interface Watchable<T> {

    /**
     * Displays the list of items.
     */
    void showList();

    /**
     * Creates a new list of items from the provided list.
     * @param list the list of items to be managed.
     */
    void createList(List<T> list);
}
