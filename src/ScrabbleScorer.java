import java.util.*;
import java.io.*;

/**
 * ScrabbleScorer builds a dictionary and checks to make sure user-inputted  words are in the
 * dictionary and returns a score based on the points of each letter
 * @version 01/24/2021
 * @author 22ridley
 */
public class ScrabbleScorer {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    ArrayList<String> dictionary;

    /**
     * Simple constructor for ScrabbleScorer class
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        buildDictionary();
    }

    /**
     * This method imports, builds, and sorts the dictionary of valid words
     */
    public void buildDictionary() {
        Scanner in = null;
        try {
            in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while (in.hasNext()) {
                dictionary.add(in.nextLine().toUpperCase());
            }
            Collections.sort(dictionary); //binary searches function best when the data is in alphabetical order
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
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
            if (alphabet.indexOf(word.charAt(i)) >= 0) {
                sum += points[alphabet.indexOf(word.charAt(i))];
            }
        }
        return sum;
    }

    /**
     * EXTRA: This method determines the highest scoring word in the dictionary
     * @return The String that has the highest score in the dictionary
     */
    public String extraHighestWord() {
        int highestScore = 0, index = 0;
        String word;
        for (int i = 0; i < dictionary.size(); i++) {
            word = dictionary.get(i);
            if (getWordScore(word) > highestScore) {
                highestScore = getWordScore(word);
                index = i;
            }
        }
        return dictionary.get(index);
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
        //--EXTRA--
        String highestWord = score.extraHighestWord();
        System.out.println("*EXTRA* The highest scoring word is " + highestWord + " with a score of " + score.getWordScore(highestWord) + " points.");
        //---------
        System.out.println("Exiting the program thanks for playing");
        in.close();
    }
}
