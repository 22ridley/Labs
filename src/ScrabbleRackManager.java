import java.io.File;
import java.util.*;

/**
 * Scrabble Rack Manager gets seven random letters and prints all the possible words
 * @version 03/18/21
 * @author 22ridley
 */

public class ScrabbleRackManager {
    String[] rack;

    /** Class constructor for ScrabbleRackManager Class
     * Creates the ArrayList to hold the letters in the player's rack
     * and fills it up with the getRack method
     */
    public ScrabbleRackManager(){
        rack = new String[7];
        rack = getRack();
    }

    private String[] getRack() {
        String[] newRack = new String[7];
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            letters.add("E");
        }
        for (int i = 0; i < 9; i++) {
            letters.add("A");
            letters.add("I");
        }
        for (int i = 0; i < 8; i++) {
            letters.add("O");
        }
        for (int i = 0; i < 6; i++) {
            letters.add("N");
            letters.add("R");
            letters.add("T");
        }
        for (int i = 0; i < 4; i++) {
            letters.add("L");
            letters.add("S");
            letters.add("U");
            letters.add("D");
        }
        for (int i = 0; i < 3; i++) {
            letters.add("G");
        }
        for (int i = 0; i < 2; i++) {
            letters.add("B");
            letters.add("C");
            letters.add("M");
            letters.add("P");
            letters.add("F");
            letters.add("H");
            letters.add("V");
            letters.add("W");
            letters.add("Y");
        }
        letters.add("K");
        letters.add("J");
        letters.add("X");
        letters.add("Q");
        letters.add("Z");
        Collections.shuffle(letters);
        Collections.shuffle(letters);
        for (int j = 0; j < newRack.length; j++) {
            newRack[j] = letters.get(j);
        }
        return newRack;
    }

    /** Prints the contents of the player's tile rack to the console*/
    public void printRack() {
        System.out.print("Letters in the rack: [");
        int counter = 0;
        for (String letter : rack) {
            System.out.print(letter);
            if (counter < rack.length - 1)
                System.out.print(", ");
            counter++;
        }
        System.out.println("]");
    }

    /** Builds an ArrayList of String objects that are values pulled from the text file
     * based on the available letters in the user's tile rack
     * @return an ArrayList of all playable words
     */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<String> playlist = new ArrayList();
        Scanner in = null;
        try {
            in = new Scanner(new File("2019_collins_scrabble.txt"));
            while (in.hasNext()) {
                dict.add(in.nextLine().toUpperCase());
            }
            Collections.sort(dict); //binary searches function best when the data is in alphabetical order
            in.close();
            String simpleString = "";
            for (String letter : rack)
                simpleString += letter;
            boolean printable = true;
            for (String word : dict) {
                String temp = simpleString;
                for (int i = 0; i < word.length(); i++) {
                    String currentLetter = word.substring(i, i+1);
                    if (temp.indexOf(currentLetter) == -1)
                        printable = false;
                    else
                        temp = temp.substring(0, temp.indexOf(currentLetter)) + temp.substring(temp.indexOf(currentLetter) + 1);
                }
                if (printable) {
                    playlist.add(word);
                }
                printable = true;
            }
        }
        catch (Exception e) {
            System.out.println("Error, file not found: ");
            e.printStackTrace();
        }
        return playlist;
    }

    /** Prints all of the playable words in the playlist ArrayList */
    public void printMatches() {
        System.out.println("You can play the following words from the letters in your rack:");
        ArrayList<String> playlist = getPlaylist();
        int counter = 0;
        boolean anyWords = false;
        for (String word: playlist) {
            anyWords = true;
            System.out.print(word);
            if (word.length() == 7)
                System.out.print("*\t");
            else if (word.length() < 4)
                System.out.print("\t\t\t");
            else if (word.length() >= 4)
                System.out.print("\t\t");
            counter++;
            if (counter >= 10) {
                System.out.println();
                counter = 0;
            }
        }
        if (!anyWords)
            System.out.println("There are no possible words to make from your rack.");
        System.out.println("\n* denotes BINGO");
    }

    /** Main method for the class
     * @param args Command line arguments if needed
     */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
