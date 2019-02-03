/*
 * TCSS 305 Assignment 2 UW Bookstore
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import org.junit.Test;

//import org.junit.Before;


/**
 * @author diemvu
 * @version 10/12/2018
 */
public class ItemTest {

    /**
     * @throws java.lang.Exception
     */
    /**
     * myItem1 an item has bulkPrice.
     */
    private final Item myItem1 =
                    new Item("Java", BigDecimal.valueOf(3.00), 3, BigDecimal.valueOf(5.00));
    /**
     * myItem 2 is the same as Item 1.
     */
    private final Item myItem2 =
                    new Item("Java", BigDecimal.valueOf(3.00), 3, BigDecimal.valueOf(5.00));
    /**
     * myItem3 an item does not have bulkPrice.
     */
    private final Item myItem3 = new Item("Java", BigDecimal.valueOf(3.00));
    /**
     * myItem3 is the same as myItem4.
     */
    private final Item myItem4 = new Item("Java", BigDecimal.valueOf(3.00));

//    @Before
//    public void setUp() throws Exception {
//    }

    /**
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertTrue(myItem1.hashCode() == myItem2.hashCode());
        assertFalse(myItem1.hashCode() == myItem3.hashCode());
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimal1() {
        // final Item myItem3 = new Item("", BigDecimal.valueOf(3.00));
        new Item("", BigDecimal.valueOf(3.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimal2() {
        // final Item myItem3 = new Item("", BigDecimal.valueOf(3.00));
        new Item(null, BigDecimal.valueOf(3.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimal3() {
        // final Item myItem3 = new Item("", BigDecimal.valueOf(3.00));
        new Item("Java", null);
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimal4() {
        // final Item myItem3 = new Item("", BigDecimal.valueOf(3.00));
        new Item("Java", BigDecimal.valueOf(-3.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     *  ,java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimal1() {
        new Item("", BigDecimal.valueOf(3.00), 3, BigDecimal.valueOf(5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimal2() {
        new Item("Java", BigDecimal.valueOf(-3.00), 3, BigDecimal.valueOf(5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimal3() {
        new Item("Java", BigDecimal.valueOf(3.00), -3, BigDecimal.valueOf(5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalIntBigDecimal4() {
        new Item("Java", BigDecimal.valueOf(3.00), 3, BigDecimal.valueOf(-5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimalIntBigDecimal5() {
        new Item(null, BigDecimal.valueOf(3.00), 3, BigDecimal.valueOf(5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimalIntBigDecimal6() {
        new Item("Java", null, 3, BigDecimal.valueOf(5.00));
    }

    /**
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal, int
     * , java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testItemStringBigDecimalIntBigDecimal7() {
        new Item("Java", BigDecimal.valueOf(3.00), 3, null);
    }

    /**
     * Test method for {@link model.Item#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(BigDecimal.valueOf(3.00), myItem1.getPrice());
    }

    /**
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(3, myItem1.getBulkQuantity());
        assertEquals(0, myItem3.getBulkQuantity());
    }

    /**
     * Test method for {@link model.Item#getBulkPrice()}.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(BigDecimal.valueOf(5.00), myItem1.getBulkPrice());
        assertEquals(null, myItem3.getBulkPrice());
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertEquals(true, myItem1.isBulk());
        assertEquals(false, myItem3.isBulk());
    }

    /**
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Java, 3.0 (3 for 5.0)", myItem1.toString());
        assertEquals("Java, 3.0", myItem3.toString());
    }

    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        assertTrue(myItem1.equals(myItem2));
        assertTrue(myItem3.equals(myItem4));
        assertFalse(myItem1.equals(myItem3));
    }

}
