/**
 * HolyGrail.java is the first lab I will write
 * it is a simple tUI program that talks to the user.
 * 09/15/2020
 * @author 22ridley
 */


import java.util.Scanner;

public class HolyGrail {
    public static void main(String[] args){
        Scanner scanner = new Scanner( System.in );
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these\n" +
                "questions three, ere the other side he see.");
        System.out.print( "Question 1: What is your name? " );
        String name = scanner.nextLine();
        System.out.print( "Question 2: What is your quest? " );
        String quest = scanner.nextLine();
        System.out.print( "Question 3: What is your favorite color? " );
        String color = scanner.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a\n" +
                "king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");
    }
}
