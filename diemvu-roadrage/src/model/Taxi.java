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

public class Taxi extends AbstractVehicle {
    /**
     * MY_DEATH_TIME is how many clock circle before car revive.
     */
    private static final int  MY_DEATH_TIME = 15;
    /**
     * myClockCircle how many clock circle a taxi has to wait in front of 
     * red cross walk light until it can move through through cross walk.
     */
    private static final int CLOCK_CIRCLE = 3;
     
    /**
     * myClockCircle how many clock circle a taxi has wait in front of 
     * red cross walk light. 
     */
   
    private short myClockCircle;
    
    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Taxi(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
        myClockCircle = 0;
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.STREET) {
            canPass = true;
        } else if (theTerrain == Terrain.LIGHT
                 && (theLight == Light.GREEN || theLight == Light.YELLOW)) {
            canPass = true;
        } else {
            canPass = canPassCrossWalk(theTerrain, theLight);
        }
        return canPass;
        
    }
    /**
     * 
     * @param theTerrain the Terrain in front of vehicle
     * @param theLight the light ( green, red, yellow) in front of vehicle
     * @return if a vehicle can move forward
     */
    private boolean canPassCrossWalk(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            myClockCircle = 0;
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.YELLOW) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            if (myClockCircle == CLOCK_CIRCLE) {
                myClockCircle = 0;
                return true;
            } else {
                myClockCircle++;
            }
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
