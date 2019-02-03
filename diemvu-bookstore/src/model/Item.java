/*
 * TCSS 305 Assignment 2 UW Bookstore
 */

package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author diemvu
 * @version 10/12/2018
 *
 */
public final class Item {
    /**
     * name String representation of name of an item.
     */
    private String myName;
    /**
     * price price of an item.
     */
    private BigDecimal myPrice;
    /**
     * bulkQuantity a person can buy a bulkQuantity of items at cheaper price.
     */
    private int myBulkQuantity;
    /**
     * bulkPrice price for a bulkQuantity.
     */
    private BigDecimal myBulkPrice;

    /**
     * 
     * @param theName name of an item
     * @param thePrice price of an item
     */

    public Item(final String theName, final BigDecimal thePrice) {
        if ("".equals(theName)) {
            throw new IllegalArgumentException("name is empty");
        }
        if (thePrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException(" price must be positive");
        }
       
        this.myName = Objects.requireNonNull(theName, " The name is null");
        this.myPrice = Objects.requireNonNull(thePrice, " The price is null");
        this.myBulkQuantity = 0;
        //this.bulkPrice = null;
    }

    /**
     * 
     * @param theName name of an item
     * @param thePrice price of an item
     * @param theBulkQuantity numbers of same items can be bought with different
     *            price
     * @param theBulkPrice price for a BulkQuantity of items
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        if ("".equals(theName)) {
            throw new IllegalArgumentException("name can not be empty");
        }
        
        if (thePrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException(" price can not be negative");
        }
        if (theBulkPrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException(" price is negative");
        }
        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException(" the quantity can not be negative");
        }
        this.myName = Objects.requireNonNull(theName, " The name can not be null");
        this.myPrice = Objects.requireNonNull(thePrice, " The price can't be null");
        this.myBulkQuantity = theBulkQuantity;
        this.myBulkPrice = Objects.requireNonNull(theBulkPrice, " The price can not be null");
    }

    /**
     * 
     * @return price of an item
     */
    public BigDecimal getPrice() {

        return this.myPrice;
    }

    /**
     * 
     * @return bulkQuantity of an item
     */
    public int getBulkQuantity() {

        if (isBulk()) {
            return this.myBulkQuantity;
        }
        return 0;
    }

    /**
     * 
     * @return bulkPrice of an item
     */
    public BigDecimal getBulkPrice() {
        if (isBulk()) {
            return this.myBulkPrice;
        }
        return null;
    }

    /**
     * 
     * @return true if a item has bulkPrice
     */
    public boolean isBulk() {
        if (this.myBulkQuantity > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String x = "";
        if (isBulk()) {
            x = myPrice.toPlainString() + " (" + myBulkQuantity + " for " + myBulkPrice + ")";

        } else {
        

            x = myPrice.toPlainString();
        }
        return myName + ", " + x;

    }

    @Override
    public boolean equals(final Object theOther) {
        
        final Item other = (Item) theOther;
//        if (this.equals(null) && other.equals(null)) return true;
//        if (!this.equals(null) && other.equals(null)) return false;
//        if (this.equals(null) && !other.equals(null)) return false;
//        
        if (myBulkQuantity != 0 && myBulkPrice != null) {
            if (this.myName.equals(other.myName) && this.myPrice.equals(other.myPrice)
                && (this.myBulkQuantity == other.myBulkQuantity)
                && this.myBulkPrice.compareTo(other.myBulkPrice) == 0) {
                return true;
            }
        } else {
        

            if (this.myName.equals(other.myName) && this.myPrice.equals(other.myPrice)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        if (!isBulk()) {
            return Objects.hash(myName, myPrice);
        }
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }

}
