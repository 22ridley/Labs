/*
primitives (holdover from C/C++):
int (32 bits), double (256 bits), boolean, char
Objects:
- Starts with a capital letter
- Every string is an object, a scanner is an object
- Every object is an object
 */

// this imports a library when I compile this file
// java language, util package, scanner class
import java.util.Scanner;
/**
 * HolyGrail.java is the first lab I will write
 * it is a simple UI program that talks to the user.
 * @version 09/15/2020
 * @author 22ridley
 */

public class HolyGrail {
    public static void main(String[] args){
        // the jvm assigns the memory address when you use 'new'
        Scanner scanner = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        System.out.print( "Question 1: What is your name? " );
        String name = scanner.nextLine();
        System.out.print( "Question 2: What is your quest? " );
        String quest = scanner.nextLine();
        System.out.print( "Question 3: What is your favorite color? " );
        String color = scanner.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");
    }
}
