/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package wordgames.wordgames;

/**
 * A Word Game program consisting of 3 main elements:
 *   - A SubString Problem Word Game
 *   - A Points Problem Word Game
 *   - A Menu that allows a user to select which of the above games they would like to play.
 *   - A dictionary of words (as a separate file) for use in each of the word games.
 * @author jessicabull
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Word Games Class
 * 
 * This class includes the main() method for processing menu selections.
 */

public class WordGames {
    private static final String DICTIONARY = "src/main/java/wordgames/wordgames/dictionary.txt";

    public static void main(String[] args) {
        int selection = getSelection();
        while (selection != 3) {
            switch (selection) {
                case 1:
                    substringProblem();
                    break;
                case 2:
                    pointsProblem();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            selection = getSelection();
        }
        System.out.println("Goodbye!");
    }

    private static int getSelection() {
        System.out.println("Welcome to the Word Games program menu.");
        System.out.println("Select from one of the following options.");
        System.out.println("1. Substring problem.");
        System.out.println("2. Points problem.");
        System.out.println("3. Exit.");
        System.out.print("Enter your selection: ");
        Scanner scanner = new Scanner(System.in); // Gets user input
        int selection = 0;
        boolean validInput = false;
        while (!validInput) { // Error  handling while loop
            try {
                String input = scanner.nextLine();
                selection = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter your selection: ");
            }
        }
        
        return selection;
    }

    
/**
 * Initializes a new instance of the WordGames class.
 * 
 * @param substringProblem is a game in the WordGames class. 
 * To solve the problem, you need to determine whether a substringProblem
    * - is a prefix of a given word
    * - is an infix of a given word
    * - is a suffix of a given word
*/
    
    private static void substringProblem() {
        System.out.println("Substring problem.");
        System.out.print("Enter a substring: ");
        Scanner scanner = new Scanner(System.in); // Scanner to get user input
        String substring = scanner.nextLine().toLowerCase();
        try {
            File file = new File(DICTIONARY);
            Scanner fileScanner = new Scanner(file);
            // While loop to identify if the word is a prefix, infix and/or suffix
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().toLowerCase();
                if (word.startsWith(substring))
                    System.out.println(word + " - prefix");
                if (word.contains(substring) && !word.startsWith(substring) && !word.endsWith(substring))
                    System.out.println(word + " - infix");
                if (word.endsWith(substring))
                    System.out.println(word + " - suffix");
                else
                    System.out.println(word + " - not found");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found."); // Handle when dictionary is not found
        }
         System.out.println();
    }

    
/**
 * Initializes a new instance of the WordGames class.
 * 
 * @param pointsProblem is a game in the WordGames class. 
 * To solve the points problem, you need to calculate the number of points for a given word.
*/
    
    private static void pointsProblem() {
        System.out.println("Points problem.");
        try {
            File file = new File(DICTIONARY);
            Scanner fileScanner = new Scanner(file); // Scanner to read dictionary
            while (fileScanner.hasNextLine()) { // While loop uses dictionary to identify how many points the words are worth
                String word = fileScanner.nextLine().toLowerCase(); // Making sure all lowercase
                int points = pointsProblem(word); // pointsProblem in Foreign key 
                System.out.println(word + " is worth " + points + " points.");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found."); //Error handling
        }
         System.out.println();
    }

/**
 * Initializes a new instance of the WordGames class.
 * 
 * @param pointsProblem is a method in the WordGames class. 
*/
    
    private static int pointsProblem(String word) { // Where the calculations are made
        int points = 0;
        for (char c : word.toCharArray()) { // "for-each" loop, which iterates over each character in a string
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'l':
                case 'n':
                case 'o':
                case 'r':
                case 's':
                case 't':
                case 'u':
                    points += 1;
                    break;
                case 'd':
                case 'g':
                    points += 2;
                    break;
                case 'b':
                case 'c':
                case 'm':
                case 'p':
                    points += 3;
                    break;
                case 'f':
                case 'h':
                case 'v':
                case 'w':
                case 'y':
                    points += 4;
                    break;
                case 'k':
                    points += 5;
                    break;
                case 'j':
                case 'x':
                    points += 8;
                    break;
                case 'q':
                case 'z':
                    points += 10;
                    break;
            }
        }
        return points;
    }
}

