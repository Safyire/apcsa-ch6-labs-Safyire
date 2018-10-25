package Shopping;

/**
 * Name: Nathan Piedad
 * Date: 10/19/2018
 * Period: 1
 *
 * Shopping.ShoppingCart.java
 *
 * Represents a shopping cart as an array of items
 */

import java.text.NumberFormat;

public class ShoppingCart2 {
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    //Declare a cart instance variable
    private Item[] cart;

    /**
     * Creates an empty shopping cart with a capacity of 5 items
     */
    public ShoppingCart2() {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        //Initialize the cart instance variable to the appropriate size
        cart = new Item[capacity];
    }

    /**
     * Adds an item to the shopping cart.
     * @param itemName
     * @param price
     * @param quantity
     */
    public void addToCart(String itemName, double price, int quantity) {
        //Complete the addToCart method
        //Increase size if itemCount is greater than 5
        if (itemCount > 4)
            increaseSize();
        //Create a new Item and place it into the cart at index itemCount
        cart[itemCount] = new Item(itemName, price, quantity);
        // increment the itemCount
        itemCount++;
        //Update totalPrice
        totalPrice += price * quantity;
    }

    //Complete the getter method getTotalPrice. Remember the getter should not print anything.
    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCartLength() {
        return cart.length;
    }

    /**
     *
     * @return the contents of the cart together with summary information
     */
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart\n";
        contents += String.format("%-15s%10s%10s%10s","Item","Price","Quantity","Total\n");

        for (int i = 0; i < itemCount; i++) {
            //contents += cart[i].toString() + "\n";
            contents += String.format("%-15s%10.2f%10d%10.2f\n",cart[i].getName(),cart[i].getPrice(), cart[i].getQuantity(),
                                                                (cart[i].getPrice()*cart[i].getQuantity()));
        }

        contents += "\nTotal Price: " + fmt.format(totalPrice);
        contents += "\n";

        return contents;
    }

    /**
     * Increases the size of the shopping cart by 3.
     */
    private void increaseSize() {
        Item[] tempCart = new Item[cart.length+3];
        for (int i = 0; i < cart.length; i++) {
            tempCart[i] = cart[i];
        }
        cart = tempCart;
    }
}
