package com.example.NetflixApp.controllers;

import com.example.NetflixApp.models.User;
import com.example.NetflixApp.repository.GeneralRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Controller class for managing users, providing methods to authenticate, create, update, and delete users.
 */
@Slf4j
public class UserController implements GeneralRepository<User, String> {
    private final List<User> users = new CopyOnWriteArrayList<>();

    public UserController() {
    }

    /**
     * Authenticates a user based on their email and password.
     * @param email    The email of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @return The authenticated user, or null if authentication fails.
     */
    public User authenticate(String email, String password) {
        User user = this.findUser(email);
        if (user != null && user.getPassword().equals(password)) {
            log.info("User successfully authenticated!");
            return user;
        } else {
            log.info("Invalid email or password");
            return null;
        }
    }

    /**
     * Finds a user by their email.
     * @param email The email to search the user by.
     * @return The user if found, or null.
     */
    private User findUser(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create(User user) {
        if (this.findUser(user.getEmail()) != null) {
            log.info("Email already registered!");
            return;
        }
        users.add(user);
        log.info("User successfully registered!");
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equalsIgnoreCase(user.getEmail())) {
                users.set(i, user);
                log.info("User successfully updated!");
                return;
            }
        }
        log.info("User not found for update.");
    }

    @Override
    public void delete(String email) {
        User toDelete = findUser(email);
        if (toDelete != null && users.remove(toDelete)) {
            log.info("User successfully deleted!");
        } else {
            log.info("Error deleting user.");
        }
    }
}
