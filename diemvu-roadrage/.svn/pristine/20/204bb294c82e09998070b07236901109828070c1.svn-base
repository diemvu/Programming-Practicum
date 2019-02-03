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
public class Bicycle extends AbstractVehicle {
    /**
     * MY_DEATH_TIME is how many clock circle before bicycle revive.
     */
    static final int MY_DEATH_TIME = 35;

    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Bicycle(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.TRAIL) {
            canPass = true;
        }
        if (theTerrain == Terrain.STREET) {
            canPass = true;
        }
        if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            canPass = true;
        }

        return canPass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction x;
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            x = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            x = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            x = getDirection().right();
        } else {
            x = chooseDirectionNonTrail(theNeighbors);
        }
        return x;
        

    }
/**
 * 
 * @param theNeighbors Terrain around the vehicle
 * @return chosen Direction.
 */
    private Direction chooseDirectionNonTrail(final Map<Direction, Terrain> theNeighbors) {
        final Direction x;
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection()) == Terrain.STREET
            || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            x = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                 || theNeighbors.get(getDirection().left()) == Terrain.STREET
                 || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            x = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                 || theNeighbors.get(getDirection().right()) == Terrain.STREET
                 || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            x = getDirection().right();
        } else {
            x = getDirection().reverse();
        }
        return x;
    }

}
