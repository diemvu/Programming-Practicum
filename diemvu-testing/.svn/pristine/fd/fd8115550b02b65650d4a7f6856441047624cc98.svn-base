/*
 * A JUnit Test for Circle TCS305 Assignment 1
 */

package shapes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;

/**
 * @author diemvu
 * @version 4.0
 */
public class CircleTest {
    /** A TOLERANCE used when comparing double values for equality. */
    private static final double TOLERANCE = .000001;

    /** TWO_PI is used when calculating circumference. */
    private static final double TWO_PI = 2 * Math.PI;

    /** myCircle is a circle to use in the test. */
    private Circle myCircle;

    /**
     * @throws java.lang.Exception myCircle is Circle with radius 1.0, center at
     *             (0,0) and color black.
     */
    @Before
    public void setUp() {
        myCircle = new Circle();
    }

    /**
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}. 
     * if the radius <= 0, Circle (double,Point,Color) should throw
     *                 an Illegal Argument Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleDoublePointColor() {
        new Circle(-5, new Point(5, 5), Color.black);
    }

    /**
     * Test method for {@link shapes.Circle#Circle()}.
     * 
     */
    @Test
    public void testCircle() {
        final Circle circle = new Circle();
        // The circle constructed should have a radius of 1
        assertEquals("failed to construct a circle with 1 unit radius", 1, circle.getRadius(),
                     TOLERANCE);
     // The circle constructed should have a center at (0,0)
        assertEquals("failed to construct a circle with center at the origin", new Point(0, 0),
                     circle.getCenter());
       // The circle constructed should have a black color
        assertEquals("failed to construct a circle with black color", Color.black,
                     circle.getColor());
    }

    /**
     * Test method for {@link shapes.SetRadius} to check the Exception 
     * when Radius is negative the method SetRadius() should throw Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusIAP0() {
        myCircle.setRadius(-5);
    }

    /**
     * Test method for {@link shapes.SetRadius} to check the Illegal Argument Exception. 
     * when set Radius is 0 The method SetRadius() should throw Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusIAPNEG() {
        myCircle.setRadius(0);
    }

    /**
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(5.0);
        assertEquals("setRadius failed to set value correctly!", 5.0, myCircle.getRadius(),
                     TOLERANCE);

    }

    /**
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenter() {
        myCircle.setCenter(new Point(1, 1));
        // The center should have x and y coordinate both equal to 1.0 
        assertEquals("setCenter failed to set the x value correctly!", 1.0,
                     myCircle.getCenter().getX(), TOLERANCE);
        assertEquals("setCenter failed to set the y value correctly!", 1.0,
                     myCircle.getCenter().getY(), TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(Color.black);
        assertEquals("setColor failed to set the Color correctly!", Color.black,
                     myCircle.getColor());
    }

    /**
     * Test method for {@link shapes.Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        final Circle oneCircle = new Circle(3, new Point(1, 2), Color.black);
        assertEquals("getRadius failed to get the Radius correctly!", 3, oneCircle.getRadius(),
                     TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {
        final Circle oneCircle = new Circle(5, new Point(1, 2), Color.black);
        assertEquals("getCenter failed to get the Center correctly", new Point(1, 2),
                     oneCircle.getCenter());
    }

    /**
     * Test method for {@link shapes.Circle#getColor()}.
     */
    @Test
    public void testGetColor() {
        final Circle oneCircle = new Circle(3, new Point(1, 2), Color.black);
        assertEquals("getColor failed to get the Color correctly", Color.black,
                     oneCircle.getColor());
    }

    /**
     * Test method for {@link shapes.Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {

        assertEquals("failed!", 2.0, myCircle.calculateDiameter(), TOLERANCE);

    }

    /**
     * Test method for {@link shapes.Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        assertEquals("failed!", TWO_PI * 1.0, myCircle.calculateCircumference(), TOLERANCE);

    }

    /**
     * Test method for {@link shapes.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        // The CalculateArea() method in Circle class is wrong. I fixed it the
        // Circle class
        assertEquals("failed!", Math.PI * 1.0, myCircle.calculateArea(), TOLERANCE);

    }

    /**
     * Test method for {@link shapes.Circle#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("failed!", "Circle [radius=1.00, center=java.awt.Point[x=0,y=0]"
                                + ", color=java.awt.Color[r=0,g=0,b=0]]",
                     myCircle.toString());

    }

}
