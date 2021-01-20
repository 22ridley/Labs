import java.util.*;
import java.io.*;

/**
 * ScrabbleScorer checks to make sure given words are in the dictionary and
 * returns a score based on the points of each letter
 * @version 01/24/2021
 * @author 22ridley
 */
public class ScrabbleScorer {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    ArrayList<String> dictionary;
    /**
     * Basic, empty constructor
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        buildDictionary();
    }

    /**
     * This method  imports and builds the dictionary of valid words
     */
    public void buildDictionary() {
        Scanner in = null;
        try {
            in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while (in.hasNext()) {
                dictionary.add(in.nextLine());
            }
            Collections.sort(dictionary);
            in.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method checks whether a supplied word is in the dictionary
     * @param word The user supplied word, a String
     * @return A boolean representing the supplied word's validity (true if valid, false if not)
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word.toUpperCase()) >= 0;
    }

    /**
     * This method determines a word's score based on the points from the individual letters
     * @param word The user supplied word, a String
     * @return An integer representing the supplied word's score
     */
    public int getWordScore(String word) {
        word = word.toLowerCase();
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += points[alphabet.indexOf(word.charAt(i))];
        }
        return sum;
    }

    /**
     * Main method for class ScrabbleScorer
     * This method takes and tests input from the user until they quit the program
     * @param args Command line arguments if needed
     */
    public static void main(String[] args) {
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        Scanner in = new Scanner(System.in);
        ScrabbleScorer score = new ScrabbleScorer();
        String word = new String("");
        while (true) {
            System.out.print("Enter a word to score or 0 to quit: ");
            word = in.nextLine();
            if (word.equals("0")) {
                break;
            }
            if (score.isValidWord(word)) {
                System.out.println(word + " = " + score.getWordScore(word) + " points");
            }
            else {
                System.out.println(word + " is not a valid word in the dictionary");
            }
        }
        System.out.println("Exiting the program thanks for playing");
        in.close();
    }
}
