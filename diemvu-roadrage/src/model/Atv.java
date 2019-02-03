/*
 * TCSS 305 - Road Rage
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author diemvu
 * @version 10/26/2018
 */
public class Atv extends AbstractVehicle {
    /**
     * MY_DEATH_TIME is how many clock circle before atv revive.
     */
    static final int MY_DEATH_TIME = 25;
    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Atv(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        if (!(theTerrain == Terrain.WALL)) {
            return true;
        }
        return false;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final List<Direction> list = new ArrayList<>();
        if (theNeighbors.get(getDirection()) != Terrain.WALL) {
            list.add(getDirection());
        }
        if (theNeighbors.get(getDirection().left()) != Terrain.WALL) {
            list.add(getDirection().left());
        }
        if (theNeighbors.get(getDirection().right()) != Terrain.WALL) {
            list.add(getDirection().right());
        }
        final int index = (int) (Math.random() * list.size());
       
        return list.get(index);

    }



}
