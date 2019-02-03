/*
 * TCSS 305 Assignment 2 UW Bookstore
 */

package model;

import java.util.Objects;

// import java.util.Objects;
/**
 * 
 * @author diemvu
 * @version 10/12/2018
 */
public final class ItemOrder {
    /**
     * myItem ordered item.
     */
    private Item myItem;
    /**
     * myQuantity the quantity of an ordered item.
     */
    private int myQuantity;

    /**
     * 
     * @param theItem the ordered item
     * @param theQuantity the quantity of the ordered item
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theQuantity < 0) {
            throw new IllegalArgumentException(" The Quantity is negative");
        }
        // if (theItem.equals(null))
        // throw new NullPointerException("The item is null");
        this.myItem = Objects.requireNonNull(theItem);
        this.myQuantity = theQuantity;
    }

    /**
     * 
     * @return ordered item
     */
    public Item getItem() {

        return this.myItem;
    }

    /**
     * 
     * @return quantity of the ordered item
     */
    public int getQuantity() {
        return this.myQuantity;
    }

    @Override
    public String toString() {
        return this.getItem().toString();
        //return this.getQuantity() + " of " + this.getItem().toString();
    }

}
