package com.example.NetflixApp.views;

import com.example.NetflixApp.util.Colors;
import com.example.NetflixApp.util.ScanValidation;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles the main menu for the Netflix application.
 */
public class NetflixMenu {

    /**
     * Displays the main menu and processes user input.
     */
    public static void mainMenu() {
        SeriesMenu seriesMenu = new SeriesMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Colors.TEXT_BLUE_BOLD + """
                *****************************************************
                                                                     
                                       Netflix Menu                   
                                                                     
                *****************************************************
                              1 - Movies                       
                              2 - Series               
                              3 - Exit              
                                                                     
                *****************************************************
                Please choose an option:                                   
                """ + Colors.TEXT_RESET);

            int option = ScanValidation.getValidIntInput(scanner);

            if (option == 3) {
                System.out.println(Colors.TEXT_BLUE_BOLD + "\nNetflix - Your Movie Manager!");
                about();
                scanner.close();
                System.exit(0);
            }

            switch (option) {
                case 1 -> MoviesMenu.clientMenu();
                case 2 -> seriesMenu.clientMenu();
                default -> {
                    System.out.println(Colors.TEXT_BLUE_BOLD + "\nInvalid option!\n" + Colors.TEXT_RESET);
                    keyPress();
                }
            }
        }
    }

    /**
     * Waits for the user to press Enter to continue.
     */
    public static void keyPress() {
        try {
            System.out.println(Colors.TEXT_RESET + "\n\nPress Enter to continue...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("You pressed a key other than Enter!");
        }
    }

   public static void about() {
        System.out.println(Colors.TEXT_BLUE_BOLD + "Netflix - The best place to manage your movies and series!" + Colors.TEXT_RESET);
    }
}
