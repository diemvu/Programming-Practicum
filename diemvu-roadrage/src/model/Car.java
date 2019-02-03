/*
 * TCSS 305 - Road Rage
 */
package model;

import java.util.Map;
/**
 * 
 * @author diemvu
 * @version 10/26/2018
 */
public class Car extends AbstractVehicle {
    /**
     * MY_DEATH_TIME is how many clock circle before car revive.
     */
    static final int MY_DEATH_TIME = 15;
    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Car(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.STREET) {
            canPass = true;
        }
        if (theTerrain == Terrain.LIGHT
            && (theLight == Light.GREEN || theLight == Light.YELLOW)) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            canPass = true;
        }
        return canPass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction chosenDirection;
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection()) == Terrain.STREET
            || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            chosenDirection = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                 || theNeighbors.get(getDirection().left()) == Terrain.STREET
                 || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            chosenDirection = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                 || theNeighbors.get(getDirection().right()) == Terrain.STREET
                 || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            chosenDirection = getDirection().right();
        } else {
            chosenDirection = getDirection().reverse();
        }
        return chosenDirection;
    }
}
