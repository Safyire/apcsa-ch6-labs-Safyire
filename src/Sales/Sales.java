package Sales;
/**
 * Name: Nathan Piedad
 * Date: 10/18/2018
 * Period: 1
 *
 * Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Prompt the user for the number of sales people that they need to enter
        //and modify the program to create an appropriately sized array.
        System.out.print("Enter the number of salespeople: ");
        int salesSize = scan.nextInt();
        if (salesSize < 1) {
            throw new IllegalStateException("You cannot have less than one salesperson!");
        }
        int[] sales = new int[salesSize];
        int sum;

        for (int i=0; i < sales.length; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        //print the array for verification
        //System.out.println(Arrays.toString(sales));

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i = 0; i < sales.length; i++) {
            System.out.println("\t " + (i + 1) + "\t\t\t" + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);

        //Use your average method to print the average sales
        System.out.println("Sales average: " + average(sales));

        //Use your indexOfMax method to print the index of the best sales person
        //and the sales amount for that sales person.
        System.out.println("Best sales: Salesperson " + (indexOfMax(sales) + 1) +
                " with " + sales[indexOfMax(sales)] + " sales.");

        //Do the same for the worst sales person
        System.out.println("Worst sales: Salesperson " + (indexOfMin(sales) + 1) +
                " with " + sales[indexOfMin(sales)] + " sales.");
    }

    public static double average(int[] arr) throws IllegalStateException {
        //compute and return the average of arr
        if (arr.length < 1) {
            throw new IllegalStateException("arr length cannot be less than 1!");
        }
        int average = 0;
        for (int x : arr) {
            average += x;
        }
        return average / (double) arr.length;
    }

    public static int indexOfMax(int[] arr) {
        //find and return the index of the max value in arr
        int currentMax = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentMax < arr[i]) {
                currentMax = arr[i];
                index = i;
            }
        }
        return index;
    }

    //Do the same for an indexOfMin method
    public static int indexOfMin(int[] arr) {
        int currentMin = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentMin > arr[i]) {
                currentMin = arr[i];
                index = i;
            }
        }
        return index;
    }
}
