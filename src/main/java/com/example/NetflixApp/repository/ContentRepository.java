package com.example.NetflixApp.repository;

/**
 * Defines the contract for repositories to list all content items.
 * This interface can be implemented by various repository classes that manage different types of content.
 */
public interface ContentRepository {

    /**
     * Lists all content items managed by the repository.
     * Implementations should handle the retrieval and display of all content items in a user-friendly format.
     */
    void listAll();
}
