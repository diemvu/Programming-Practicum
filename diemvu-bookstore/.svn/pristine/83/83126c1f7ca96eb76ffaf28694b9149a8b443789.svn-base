/*
 *  TCSS 305 Assignment 2 UW Bookstore
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author diemvu
 * @version 10/12/2018
 */
public class Cart {
    /**
     * myCart a map consists of ordered items and their quantities.
     */
    private Map<ItemOrder, Integer> myCart;

    /**
     * myMembership a person has membership when Membership check box is
     *            chosen.
     */
    private boolean myMembership;

    /**
     * @ return a hash map of items and their quantities
     */
    public Cart() {
        myCart = new HashMap<ItemOrder, Integer>();
        
    }

    /**
     * @param theOrder is the ordered item
     * 
     */
    public void add(final ItemOrder theOrder) {
        if (theOrder.equals(null)) {
            throw new NullPointerException(" the Order is null");
        }
        if (myCart.isEmpty()) {
            myCart.put(theOrder, theOrder.getQuantity());
        } else {     

            final Iterator<ItemOrder> iterator = myCart.keySet().iterator();
            while (iterator.hasNext()) {
                final ItemOrder anItem = iterator.next();
                if (theOrder.getItem().equals(anItem.getItem())) {
                    iterator.remove();
                }
            }
            myCart.put(theOrder, theOrder.getQuantity());
           // System.out.println(myCart.toString());
        }
    }

    /**
     * 
     * @param theMembership is a boolean type parameter. theMembership is true
     *            when membership check box is clicked
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * 
     * @return BigDecimal value of total cost of order items
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        final Iterator<ItemOrder> iterator = myCart.keySet().iterator();

        while (iterator.hasNext()) {
            final ItemOrder items = iterator.next();
            // Integer i = Cart.get(iterator.next());
            final BigDecimal quantity = BigDecimal.valueOf(items.getQuantity());
            // myItem.getItem().getPrice();
            if (myMembership && items.getItem().isBulk()
                && (items.getQuantity() >= items.getItem().getBulkQuantity())) {
                BigDecimal bulk = BigDecimal.valueOf(items.getQuantity()
                                                     / items.getItem().getBulkQuantity());
                BigDecimal notBulk = BigDecimal.valueOf(items.getQuantity()
                                                        % items.getItem().getBulkQuantity());
                bulk = bulk.multiply(items.getItem().getBulkPrice());
                notBulk = notBulk.multiply(items.getItem().getPrice());
                total = total.add(bulk).add(notBulk);
            } else {
            
                total = total.add(items.getItem().getPrice().multiply(quantity));
            }
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);

    }

    /**
     * clear the cart when clear box is clicked.
     * 
     */
    public void clear() {
        myCart = new HashMap<ItemOrder, Integer>();
    }

    @Override
    public String toString() {
        String string = "";
        final Iterator<ItemOrder> iterator = myCart.keySet().iterator();
        while (iterator.hasNext()) {
            final ItemOrder anItem = iterator.next();
           // System.out.println(anItem.toString());
            string = string +  anItem.getItem().toString() + "    ";
            
        }
        return string;
    }

}
