/*
 * TCSS 305 assignment 3.
 */

package model;

/**
 * 
 * @author diemvu
 * @version 10/26/2018
 */
public abstract class AbstractVehicle implements Vehicle {
    /**
     * myX X coordinate of vehicle.
     */
    private int myX;
    /**
     * myY Y coordinate of vehicle.
     */
    private int myY;
    /**
     * myDirection direction of a vehicle moving forward.
     */
    private Direction myDirection;
    
    /**
     * myDeathTime How many pokes before they revive after a vehicle is killed.
     */
    private int myDeathTime;
    /**
     * myStartX the originnal X coordinate.
     */
    private int myStartX;
    /**
     * myStartY the originnal coordinate.
     */
    private int myStartY;
    /**
     * myStartDirection the original direction.
     */
    private Direction myStartDirection;
    /**
     * myClassName the vehicle name.
     */
    private String myClassName;
    /**
     * isAlive true if the vehicle is not killed.
     */
    private boolean myAlive;
    /**
     * myPoke how many times a vehicle is poked after it is killed.
     */
    private int myPoke;
    /**
     * 
     * @param theX X coordinate of vehicle
     * @param theY Y coordinate of vehicle
     * @param theDirection Direction a vehicle moving forward
     * @param theDeathTime how many time it needed to be poked after being killed
     */

    protected AbstractVehicle(final int theX, final int theY, final Direction theDirection,
                              final int theDeathTime) {
        myX = theX;
        myStartX = theX;
        myY = theY;
        myStartY = theY;

        myDirection = theDirection;
        myStartDirection = theDirection;
        myDeathTime = theDeathTime;
        myClassName = this.getClass().getSimpleName().toLowerCase();
        myAlive = true;
        myPoke = 0;

    }

    @Override
    public void collide(final Vehicle theOther) {
        if (isAlive() && theOther.isAlive()) {
            if (myDeathTime > theOther.getDeathTime()) {
                myAlive = false;
            }
        }
        // System.out.print(isAlive());
    }

    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    @Override
    public String getImageFileName() {
        final String s = myClassName;
        if (!isAlive()) {
            return s + "_dead.gif";
        }
        return s + ".gif";
    }

    @Override
    public Direction getDirection() {
        return myDirection;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public boolean isAlive() {
        return myAlive;
    }

    @Override
    public void poke() {
        if (myPoke == myDeathTime) {
            setDirection(Direction.random());
            myAlive = true;
            myPoke = 0;
        } else {
            myPoke++;
        }
    }

    @Override
    public void reset() {
        setX(myStartX);
        setY(myStartY);
        setDirection(myStartDirection);
        myAlive = true;
        myPoke = 0;
    }

    @Override
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
    }

    @Override
    public void setX(final int theX) {
        myX = theX;
    }

    @Override
    public void setY(final int theY) {
        myY = theY;
    }

    @Override
    public String toString() {
        String s = "";
        s = myClassName + " myDeathTime " + myDeathTime + " myPoke " + myPoke;
        return s;
    }

}
