package com.example.NetflixApp.utilities;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Utility class for validating and retrieving user input from the console.
 */
public class ScanValidation {

    /**
     * Prompts the user for a valid integer input.
     * @param scanner The Scanner instance to read input.
     * @return A valid integer entered by the user.
     */
    public static int getValidIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Prompts the user for an integer within a specified range.
     * @param scanner The Scanner instance to read input.
     * @param min The minimum acceptable value.
     * @param max The maximum acceptable value.
     * @return A valid integer within the specified range.
     */
    public static int getValidIntBetweenInput(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    scanner.nextLine();
                    return choice;
                } else {
                    System.out.printf("Invalid input. Please enter a number between %d and %d: %n", min, max);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Prompts the user for a valid string input with a minimum length.
     * @param scanner The Scanner instance to read input.
     * @param minLength The minimum required length for the input string.
     * @return A valid string that meets the minimum length requirement.
     */
    public static String getValidStringInput(Scanner scanner, int minLength) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() >= minLength) {
                return input;
            } else {
                System.out.printf("Invalid input. Please enter a string with at least %d characters: %n", minLength);
            }
        }
    }

    /**
     * Prompts the user for a valid day input (1-31).
     * @param scanner The Scanner instance to read input.
     * @return A valid day as a string in the format "DD/".
     */
    public static String getValidDayInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                String choiceParsed = String.format("%02d", choice);

                if (choice >= 1 && choice <= 31) {
                    return choiceParsed + "/";
                } else {
                    System.out.println("Invalid input. Please enter a valid day (01-31): ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Prompts the user for a valid month input (1-12).
     * @param scanner The Scanner instance to read input.
     * @return A valid month as a string in the format "MM/".
     */
    public static String getValidMonthInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                String choiceParsed = String.format("%02d", choice);

                if (choice >= 1 && choice <= 12) {
                    return choiceParsed + "/";
                } else {
                    System.out.println("Invalid input. Please enter a valid month (01-12): ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Prompts the user for a valid year input.
     * @param scanner The Scanner instance to read input.
     * @return A valid year as a string.
     */
    public static String getValidYearInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                int currentYear = LocalDate.now().getYear();
                if (choice >= 1 && choice <= currentYear && String.valueOf(choice).length() == 4) {
                    return String.valueOf(choice);
                } else {
                    System.out.println("Invalid input. Please enter a valid year (e.g., 2023): ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.nextLine();
            }
        }
    }
}
