import java.io.File;
import java.util.*;
import java.text.DecimalFormat;

public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    // initializes coins ArrayList
    public CoinSorterMachine() {
        coins = new ArrayList<Coin>();
    }
    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename – MUST handle diabolic values!
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
                int next = in.nextInt();
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
                else {
                    System.out.println("Coin value " + next + " not recognized");
                }
            }
            in.close();
        }
        catch (Exception e) {
                System.out.println("Error, bad input in file name or within file");
                e.printStackTrace();
        }
    }
    // Prints deposit summary using a DecimalFormat object (see output section)
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
        System.out.println("\t" + (int) (dollar*100) + " dollars " + currency.format(dollar));
        System.out.println("TOTAL DEPOSIT: " + currency.format(getTotalValue()));
    }
    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        double total = 0.0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        return total;
    }
    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
