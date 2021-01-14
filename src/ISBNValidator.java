import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * ISBNValidator validates data files of ISBN numbers using a few specific criteria
 * @version 01/15/2021
 * @author 22ridley
 */
public class ISBNValidator {
    private String[] validNums;
    private String[] invalidNums;

    /**
     * Simple constructor that initializes arrays
     */
    public ISBNValidator() {
        validNums = new String[1500];
        invalidNums = new String[500];
    }
    /**
     * Imports .dat file, calls isValidISBN method and stores Strings into
     * corresponding arrays.
     */
    public void importData() {
        Scanner in = null;
        final JFileChooser fc = new JFileChooser();
        try {
            fc.setCurrentDirectory(new File("isbn_files/"));
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            in = new Scanner(new File("" + file));
            int valid = 0, invalid = 0;
            while(in.hasNext()) {
                String isbn = in.nextLine(); //doesn't read the new line character
                if (isValidISBN(isbn)) {
                    validNums[valid++] = isbn; //[] takes precedence over ++
                }
                else {
                    invalidNums[invalid++] = isbn;
                }
            }
            in.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Determines validity of supplied ISBN number; called inside importData
     * @param isbn The ISBN number to be tested
     * @return A boolean representing whether or not the ISBN given is valid (true if valid, false if not)
     */
    public boolean isValidISBN(String isbn) {
        isbn = isbn.replace("-", "");
        int prefix = Integer.parseInt(isbn.substring(0,3));
        if (prefix != 978 && prefix != 979)
            return false;
        else {
            int sum = 0, currentMult = 1;
            for(int i = 0; i < isbn.length(); i++) {
                int val = Integer.parseInt("" + isbn.charAt(i));
                sum += currentMult * val;
                currentMult = currentMult == 1 ? 3 : 1;
            }
            return sum % 10 == 0;
        }
    }

    /**
     * Output the user-picked ISBN list or quit the application
     */
    public void runProgram() {
        Scanner scan = new Scanner(System.in);
        System.out.println("All ISBN data has been imported and validated. Would you like to:\n" +
                "\t" + "1) View all valid ISBN numbers\n" + "\t" + "2) View all invalid ISBN numbers\n" +
                "\t" + "3) Quit");
        System.out.print("Your selection: ");
        String selection = scan.nextLine();
        if (selection.equals("1")) {
            for (String num : validNums) {
                if (num != null)
                    System.out.println(num);
            }
        }
        else if (selection.equals("2")) {
            for (String num : invalidNums) {
                if (num != null)
                    System.out.println(num);
            }
        }
        scan.close();
    }

    /** Main method for class ISBNValidator
     * This class uses a imports the data then
     * validates the ISBN numbers.
     * @param args Command line arguments if needed
     */
    public static void main(String[] args){
        ISBNValidator app = new ISBNValidator ();
        System.out.println("* ISBN Validator Program *");
        System.out.println("...Importing data...");
        app.importData(); // imports data from the text file
        app.runProgram(); // runs using a while loop; see examples
        System.out.println("* End of Program *");
    }
}
