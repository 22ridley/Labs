import java.util.Scanner;

/**
 * SimpleIOMath.java is a simple class that takes input from a user, stores
 * that information in class variables and then defines a few helper methods.
 * @version 09/24/2020
 * @author 22ridley
 */

public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    /**
     * Ask the user for some info, there is no return value
     */
    public void promptUser() {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        Scanner scan = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = scan.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = scan.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = scan.nextInt();
    }

    private int smallestPrimeFactor(int age) {
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61};
        for(int factor : primes) {
            if(age % factor == 0)
                return factor;
        }
        return age;
    }

    private int letterCount(String name) {
        int nameLength = name.length();
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)))
                nameLength = nameLength - 1;
        }
        return nameLength;
    }
    /**
     * Print the user's info with a few twists calculated by the computer
     * There is also no return value here
     */
    public void printInfo() {
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1) + ".");
        System.out.println("The first prime factor of " + age + " is: " + smallestPrimeFactor(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + (int)Math.pow(favNumber, 2));
        System.out.println("Your name has " + letterCount(name) + " letters.");
        System.out.println("The number of letters in your name multiplied by your favorite number is: " + letterCount(name) * favNumber);
        System.out.println("The square root of " + letterCount(name) * favNumber + " is " + Math.sqrt(letterCount(name) * favNumber));

        System.out.println("* end of program *");
    }

    /**
     * Main method for class SimpleIOMath
     * @param args Command line arguments if needed
     */
    public static void main(String[] args) {
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }
}
