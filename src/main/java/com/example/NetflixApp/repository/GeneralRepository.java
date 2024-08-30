package com.example.NetflixApp.repository;

/**
 * Generic repository interface defining basic CRUD operations.
 * @param <T> the type of entity this repository manages.
 * @param <U> the type of the identifier used for entities.
 */
public interface GeneralRepository<T, U> {

    /**
     * Creates and stores an entity.
     * @param entity The entity to be created and stored.
     */
    void create(T entity);

    /**
     * Updates an existing entity.
     * @param entity The entity with updated fields that should replace the current entity.
     */
    void update(T entity);

    /**
     * Deletes an entity identified by its ID.
     * @param id The identifier of the entity to be deleted.
     */
    void delete(U id);
}
