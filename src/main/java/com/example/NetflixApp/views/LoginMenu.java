package com.example.NetflixApp.views;

import com.example.NetflixApp.controllers.UserController;
import com.example.NetflixApp.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * Handles the login and registration menu for the application.
 */
@Getter
@Setter
public class LoginMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static User currentUser;

    /**
     * Displays the login menu and handles user input.
     */
    public static void show() {
        System.out.println("""
              _   _      _    __ _ _      
             | \\ | |    | |  / _| (_)     
             |  \\| | ___| |_| |_| |___  __
             | . ` |/ _ \\ __|  _| | \\ \\/ /
             | |\\  |  __/ |_| | | | | > <
             |_| \\_|\\___|\\__|_| |_|_/_/\\_\\
        """);
        System.out.println("NETFLIX - Welcome!");

        boolean isActive = true;
        while (isActive) {
            System.out.println("Choose an option:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Prompts the user for registration information and creates a new user.
     */
    public static void register() {
        String name = promptName();
        String email = promptEmail();
        String password = promptPassword();

        User user = new User(name, email, password);
        userController.create(user);

        System.out.println("Registration successful!\n");
        System.out.println("Please login:");
        login();
    }

    /**
     * Prompts the user for their name.
     * @return The user's name.
     */
    public static String promptName() {
        String name = "";
        while (name.isEmpty()) {
            System.out.println("Enter your name:");
            name = scanner.nextLine();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        }
        return name;
    }

    /**
     * Prompts the user for their email.
     * @return The user's email.
     */
    public static String promptEmail() {
        String email = "";
        while (email.isEmpty()) {
            System.out.println("Enter your email:");
            email = scanner.nextLine();

            if (email.isEmpty()) {
                System.out.println("Email cannot be empty.");
            }
        }
        return email;
    }

    /**
     * Prompts the user for their password.
     * @return The user's password.
     */
    public static String promptPassword() {
        String password = "";
        while (password.isEmpty()) {
            System.out.println("Enter a password:");
            password = scanner.nextLine();

            if (password.isEmpty()) {
                System.out.println("Password cannot be empty.");
            }
        }
        return password;
    }

    /**
     * Authenticates the user based on provided email and password.
     */
    public static void login() {
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        currentUser = userController.authenticate(email, password);

        if (currentUser != null) {
            NetflixMenu.mainMenu();
        } else {
            System.out.println("Invalid email or password, please try again.");
        }
    }
}
