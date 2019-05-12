package a01;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s3607751
 */
public class A01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //A Scanner
        Scanner kbd = new Scanner(System.in);

        List<Food> foodList = new LinkedList<>();

        String foodName;
        double servingSize;
        double sodiumContent;
        double carbContent;

        printIntroduction();
        printPause(kbd);

        System.out.println("Enter a food name (or leave blank to stop): ");
        foodName = kbd.nextLine();

        while (!(foodName.isEmpty())) {
            System.out.println("How many grams per serving: ");
            servingSize = kbd.nextDouble();
            System.out.println("How many milligrams of sodium per serving: ");
            sodiumContent = kbd.nextDouble();
            System.out.println("How many grams of carbohydrates per serving: ");
            carbContent = kbd.nextDouble();

            try {
                Food NewFood = new Food(foodName, servingSize, sodiumContent, carbContent);
                foodList.add(NewFood);
                System.out.println("Added " + foodName);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae);
            }

            System.out.println("Enter a food name (or leave blank to stop): ");
            foodName = kbd.nextLine();

        }

        printPause(kbd);

    }

    private static void printIntroduction() {
        System.out.println("Food Nutrition Information\n"
                + "--------------------------\n\n"
                + "This program reads food nutrition information then prints "
                + "it back out in\nvarious orders.\n\n"
                + "By Aitezaz Siddiqi (A00431079)");
    }

    private static void printPause(Scanner kbd1) {
        System.out.println();
        System.out.println("Press enter to continue...");
        kbd1.nextLine();
        System.out.println();
    }
}
