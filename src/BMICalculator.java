import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * BMICalculator.java is a class that takes the user's height and weight in feet,
 * inches, and pounds, converts them to meters and kilograms, and calculates and
 * prints the user's BMI.
 * @version 11/12/2020
 * @author 22ridley
 */

public class BMICalculator {
    /** This class converts units to metric units, (ft/in to m, lb to kg)
     * This class then calculates the BMI of the user
     * This class also handles bad data
     * @param inches The user's height in inches
     * @param pounds The user's weight in pounds
     * @return A double that represents the user's BMI in weight/height squared
     */
    public static double computeBMI(int inches, int pounds) {
        double meters = inches * 0.0254;
        double kgs = pounds * 0.454;
        if (meters <= 0 || kgs <= 0)
            return 0.0;
        return kgs / (meters * meters);
    }

    /** Main method for class SimpleIOMath
     * This class uses a Scanner to get the user's  info, then processes the
     * feet to inches conversions, uses the computeBMI method, and prints the
     * user's information.
     * @param args Command line arguments if needed
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner in = new Scanner(System.in);
        String textHeight = "";
        int intHeight, intWeight, qtPos, dblQtPos;
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or \"Q\" to quit: ");
                textHeight = in.nextLine();
                if (textHeight.toUpperCase().equals("Q")) {
                    break;
                }
                qtPos = textHeight.indexOf('\'');
                dblQtPos = textHeight.indexOf('\"');
                if (qtPos != -1 && dblQtPos != -1) {
                    intHeight = Integer.parseInt(textHeight.substring(0, qtPos)) * 12 + Integer.parseInt(textHeight.substring(qtPos + 1, dblQtPos));
                    System.out.print("Enter your weight in pounds: ");
                    try {
                        intWeight = in.nextInt();
                        System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(intHeight, intWeight)) + " kg/m^2");
                        in.nextLine();
                    }
                    catch (Exception e) {
                        in.nextLine();
                        System.out.print("Invalid input, more details here: ");
                        System.out.println(e);
                    }
                } else {
                    System.out.println("Invalid input.");
                }
            } catch (Exception e) {
                System.out.print("Invalid input, more details here: ");
                System.out.println(e);
            }
        }
    }
}
