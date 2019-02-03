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
public class Human extends AbstractVehicle {

    /**
     * MY_DEATH_TIME is how many clock circle before human revive.
     */
    static final int MY_DEATH_TIME = 45;
    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Human(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        if (theTerrain == Terrain.GRASS) {
            return true;
        }
        if (theTerrain == Terrain.CROSSWALK
            && (theLight == Light.RED || theLight == Light.YELLOW)) {
            return true;
        }
        return false;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        final Direction x;
        if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            x = getDirection().right();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            x = getDirection().left();
        } else if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            x = getDirection();
        } else {
            final List<Direction> list = new ArrayList<>();
            if (theNeighbors.get(getDirection().right()) == Terrain.GRASS) {
                list.add(getDirection().right());
            }
            if (theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
                list.add(getDirection().left());
            }
            if (theNeighbors.get(getDirection()) == Terrain.GRASS) {
                list.add(getDirection());
            }
            if (list.isEmpty()) {
                x = getDirection().reverse();
            } else {
                final int index = (int) (Math.random() * list.size());
                x = list.get(index);
            }
        }
        return x;

    }
}
