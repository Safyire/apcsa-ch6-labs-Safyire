package Shopping;

/**
 * Name: Nathan Piedad
 * Date: 10/19/2018
 * Period: 1
 *
 * Shopping.ShopTest.java
 *
 * Simulates shopping with user input
 */

import java.util.Scanner;

public class ShopTest3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String itemName;
        double itemCost;
        int itemQuantity;
        String isShopping;
        ShoppingCart3 shopCart = new ShoppingCart3();

        System.out.print("Would you like to go shopping? (Y/N) ");
        isShopping = s.next();
        while (isShopping.equalsIgnoreCase("y")) {
            System.out.print("What would you like to buy? ");
            itemName = s.next();

            System.out.print("How much does it cost? ");
            itemCost = s.nextDouble();

            System.out.print("How many do you want? ");
            itemQuantity = s.nextInt();

            shopCart.addToCart(itemName, itemCost, itemQuantity);

            System.out.print("Would you like to continue shopping? (Y/N) ");
            isShopping = s.next();
        }
        System.out.println(shopCart.toString());
    }
}
