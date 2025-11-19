/*
 * Brody Thomas
 */
//I had help from a tutor
import java.util.Scanner;

public class TriangleMaker {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

///////////////////////////////////////////////////////////////////////////////////////////// 
        //Should ask for the size of the triangle
        System.out.println("Welcome to Triangle Maker! Enter the size of the triangle.");

        //Should only look for whole numbers
        if(!scanner.hasNextInt()) {
            System.out.println("The gotta has to be a positive, non-zero whole number.");
            scanner.close();
            return;
        }
///////////////////////////////////////////////////////////////////////////////////////////// 

        int size = scanner.nextInt();

        //Should not be zero or less
        if(size <= 0) {
            System.out.println("The input gotta to be a positive, non-zero whole number.");
            scanner.close();
            return;
        }
///////////////////////////////////////////////////////////////////////////////////////////// 
        //Should draw higher
        for(int i = 1; i <= size; i++) {
            printStars(i);
        }

        //Should draw lower
        for(int i = size - 1; i >= 1; i--) {
            printStars(i);
        }

        System.out.println("DONE!");

        scanner.close();
    }
///////////////////////////////////////////////////////////////////////////////////////////// 
    //Should print a line with the given number of star things (*)
    private static void printStars(int count) {
        for(int i = 0; i < count; i++) {
            System.out.print("*");
        }
        //M A K E  T R I A N G L E
        System.out.println();
    }
} 