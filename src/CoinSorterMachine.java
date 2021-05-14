import java.io.File;
import java.util.*;
import java.text.DecimalFormat;

/**
 * CoinSorterMachine.java is a class that a file with coin cents values and creates a list
 * to hold each coin, then printing out the number of each coin and the total value.
 * @version 05/12/2020
 * @author 22ridley
 */

public class CoinSorterMachine {
    private ArrayList<Coin> coins;

    /**
     * Constructs a new CoinSorterMachine object and initializes the coins ArrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<Coin>();
    }

    /**
     * Uses Scanners to prompt for the file name and read the coin values, handles
     * diabolic values, and places all proper data in the coins ArrayList
     */
    public void depositCoins() {
        Scanner file = new Scanner(System.in);
        String fileName = "";
        Scanner in = null;
        try {
            System.out.print("Enter the name of the data file for coin deposit: ");
            fileName = file.nextLine();
            in = new Scanner(new File(fileName));
            System.out.println("Depositing coins...");
            while (in.hasNext()) {
                int next = 0;
                try {
                    next = in.nextInt();
                    }
                catch (Exception e) {
                    System.out.println("Error, bad file data");
                    e.printStackTrace();
                }
                if (next == 1)
                    coins.add(new Penny());
                else if (next == 5)
                    coins.add(new Nickel());
                else if (next == 10)
                    coins.add(new Dime());
                else if (next == 25)
                    coins.add(new Quarter());
                else if (next == 50)
                    coins.add(new HalfDollar());
                else if (next == 100)
                    coins.add(new Dollar());
                else
                    System.out.println("Coin value " + next + " not recognized");
            }
            in.close();
        }
        catch (Exception e) {
                System.out.println("Error, file not found");
                e.printStackTrace();
        }
    }

    /**
     * Prints deposit summary using a DecimalFormat object
     */
    public void printDepositSummary() {
        System.out.println("Summary of deposit: ");
        double penny = 0;
        double nickel = 0;
        double dime = 0;
        double quarter = 0;
        double halfDollar = 0;
        double dollar = 0;
        for (Coin coin : coins) {
            if (coin instanceof Penny) {
                penny+= coin.getValue();
            }
            else if (coin instanceof Nickel) {
                nickel+= coin.getValue();
            }
            else if (coin instanceof Dime) {
                dime+= coin.getValue();
            }
            else if (coin instanceof Quarter) {
                quarter+= coin.getValue();
            }
            else if (coin instanceof HalfDollar) {
                halfDollar+= coin.getValue();;
            }
            else if (coin instanceof Dollar) {
                dollar+= coin.getValue();;
            }
        }
        DecimalFormat currency = new DecimalFormat("$#,##0.00");
        System.out.println("\t" + (int) (penny*100) + " pennies " + currency.format(penny));
        System.out.println("\t" + (int) (nickel*20) + " nickels " + currency.format(nickel));
        System.out.println("\t" + (int) (dime*10) + " dime " + currency.format(dime));
        System.out.println("\t" + (int) (quarter*4) + " quarter " + currency.format(quarter));
        System.out.println("\t" + (int) (halfDollar*2) + " half dollars " + currency.format(halfDollar));
        System.out.println("\t" + (int) (dollar) + " dollars " + currency.format(dollar));
        System.out.println("TOTAL DEPOSIT: " + currency.format(getTotalValue()));
    }

    /**
     * Calculates the total value of all coin objects in coins
     * @return The total value of all coin objects in coins as a double
     */
    public double getTotalValue() {
        double total = 0.0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        return total;
    }

    /**
     * Main method for the CoinSorterMachine class
     * @param args Command line arguments in necessary
     */
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
