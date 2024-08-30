package com.example.NetflixApp.menus;

import com.example.NetflixApp.controllers.MovieController;
import com.example.NetflixApp.models.Movie;
import com.example.NetflixApp.models.Genre;
import com.example.NetflixApp.services.WatchedMovieService;
import com.example.NetflixApp.utilities.ScanValidation;
import com.example.NetflixApp.utilities.Colors;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MoviesMenu {
    private static final MovieController movieController = new MovieController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void adminMenu() {
        int option;

        while (true) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                    Movies Menu                     
                                                                     
                *****************************************************
                            1 - Add Movie                       
                            2 - List All Movies               
                            3 - Search Movie by Title              
                            4 - Update Movie
                            5 - Remove Movie
                            6 - Most Watched Movies
                            7 - Watch Movie
                            8 - Exit
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            option = ScanValidation.getValidIntInput(scanner);

            if (option == 8) {
                System.out.println(Colors.TEXT_BLUE_BOLD + "\nNetflix - Your Movie Manager!");
                NetflixMenu.about();
                scanner.close();
                System.exit(0);
            }

            switch (option) {
                case 1 -> {
                    newMovieOption();
                    NetflixMenu.keyPress();
                }
                case 2 -> {
                    listMoviesOption();
                    NetflixMenu.keyPress();
                }
                case 3 -> {
                    searchMovieOption();
                    NetflixMenu.keyPress();
                }
                case 4 -> {
                    updateMovieOption();
                    NetflixMenu.keyPress();
                }
                case 5 -> {
                    deleteMovieOption();
                    NetflixMenu.keyPress();
                }
                case 6 -> {
                    mostWatchedOption();
                    NetflixMenu.keyPress();
                }
                case 7 -> {
                    watchMovieOption();
                    NetflixMenu.keyPress();
                }
                default -> {
                    System.out.println(Colors.TEXT_BLUE_BOLD + "\nInvalid option!\n" + Colors.TEXT_RESET);
                    NetflixMenu.keyPress();
                }
            }
        }
    }

    public static void clientMenu() {
        int option;

        while (true) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                    Movies Menu                     
                                                                     
                *****************************************************
                            1 - List All Movies               
                            2 - Search Movie by Title              
                            3 - Most Watched Movies             
                            4 - Watch Movie
                            5 - Exit
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            option = ScanValidation.getValidIntInput(scanner);

            if (option == 5) {
                System.out.println(Colors.TEXT_BLUE_BOLD + "\nNetflix - Your Movie Manager!");
                NetflixMenu.about();
                scanner.close();
                System.exit(0);
            }

            switch (option) {
                case 1 -> {
                    listMoviesOption();
                    NetflixMenu.keyPress();
                }
                case 2 -> {
                    searchMovieOption();
                    NetflixMenu.keyPress();
                }
                case 3 -> {
                    mostWatchedOption();
                    NetflixMenu.keyPress();
                }
                case 4 -> {
                    watchMovieOption();
                    NetflixMenu.keyPress();
                }
                default -> {
                    System.out.println(Colors.TEXT_BLUE_BOLD + "\nInvalid option!\n" + Colors.TEXT_RESET);
                    NetflixMenu.keyPress();
                }
            }
        }
    }

    private static void newMovieOption() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "Add Movie\n");

        System.out.println("Enter the title: ");
        String title = scanner.nextLine();
        System.out.println("Choose the genre: ");
        Genre genre = getGenreInput();
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        System.out.println("Enter the duration in minutes: ");
        int duration = scanner.nextInt();

        Movie newMovie = new Movie(title, LocalDate.now(), genre, duration);
        movieController.addMovie(newMovie);
        System.out.println(Colors.TEXT_BLUE_BOLD + "Movie added successfully!\n" + Colors.TEXT_RESET);
    }

    private static Genre getGenreInput() {
        Genre selectedGenre = null;

        while (selectedGenre == null) {
            IntStream.range(0, Genre.values().length)
                    .forEach(i -> System.out.println((i + 1) + " - " + Genre.values()[i]));

            int option = ScanValidation.getValidIntInput(scanner);

            if (option >= 1 && option <= Genre.values().length) {
                selectedGenre = Genre.values()[option - 1];
            } else {
                System.out.println(Colors.TEXT_BLUE_BOLD + "Invalid option, please try again.\n" + Colors.TEXT_RESET);
            }
        }

        return selectedGenre;
    }

    private static void listMoviesOption() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "List All Movies\n" + Colors.TEXT_RESET);
        movieController.listAllMovies();
    }

    private static void searchMovieOption() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "Search Movie by Title\n");

        System.out.println("Enter the title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Movie foundMovie = movieController.findMovieByTitle(title);

        if (foundMovie != null) {
            foundMovie.displayDetails();
        } else {
            System.out.println(Colors.TEXT_BLUE_BOLD + "Movie not found!\n" + Colors.TEXT_RESET);
        }
    }

    private static void updateMovieOption() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "Update Movie\n");

        System.out.println("Enter the title of the movie to be updated: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        Movie movieToUpdate = movieController.getMovieByTitle(title);
        if (movieToUpdate != null) {
            System.out.println("Choose the new genre: ");
            Genre genre = getGenreInput();
            System.out.println("Enter the new year: ");
            int year = scanner.nextInt();
            System.out.println("Enter the new duration in minutes: ");
            int duration = scanner.nextInt();

            movieToUpdate.setGenre(genre);
            movieToUpdate.setDate(LocalDate.now());
            movieToUpdate.setDuration(duration);
            movieController.updateMovie(movieToUpdate);
            System.out.println(Colors.TEXT_BLUE_BOLD + "Movie updated successfully!\n" + Colors.TEXT_RESET);
        } else {
            System.out.println(Colors.TEXT_BLUE_BOLD + "Movie not found.\n" + Colors.TEXT_RESET);
        }
    }

    private static void deleteMovieOption() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "Remove Movie\n");

        System.out.println("Enter the title of the movie to be removed: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        movieController.removeMovieByTitle(title);
        System.out.println(Colors.TEXT_BLUE_BOLD + "Movie removed successfully!\n" + Colors.TEXT_RESET);
    }

    private static void watchMovieOption() {
        movieController.listAllMovies();
        NetflixMenu.keyPress();

        while (true) {
            System.out.println("Which movie would you like to watch? Enter 'S' to exit.");
            String title = ScanValidation.getValidStringInput(scanner, 1);

            if (title.equalsIgnoreCase("S")) {
                break;
            }

            Movie movie = movieController.getMovieByTitle(title);
            if (movie != null) {
                System.out.println("Watching movie: " + movie.getTitle());
                movie.setWatched(movie.getWatched() + 1);
                break;
            } else {
                System.out.println(Colors.TEXT_BLUE_BOLD + "Movie not found, please try again.\n" + Colors.TEXT_RESET);
            }
        }
    }

    private static void mostWatchedOption() {
        WatchedMovieService watchedMovieService = new WatchedMovieService(movieController.listMovies());
        watchedMovieService.showList();
    }
}
