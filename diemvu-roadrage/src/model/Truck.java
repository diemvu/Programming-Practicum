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
public class Truck extends AbstractVehicle {
    /**
     * 
     * @param theX x coordinate of vehicle.
     * @param theY y coordinate of vehicle.
     * @param theDirection direction the vehicle is facing.
     */
    public Truck(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, 0);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.STREET) {
            canPass = true;

        }
        if (theTerrain == Terrain.LIGHT) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK
            && (theLight == Light.GREEN || theLight == Light.YELLOW)) {
            canPass = true;
        }
        return canPass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        if (list(theNeighbors).isEmpty()) {
            return getDirection().reverse();
        } else {
            final int index = (int) (Math.random() * list(theNeighbors).size());

            return list(theNeighbors).get(index);
        }
    }
    /**
     * 
     * @param theNeighbors the terrain surrounding the vehicle
     * @return the possible direction the vihicle can move
     */
    private List<Direction> list(final Map<Direction, Terrain> theNeighbors) {
        final List<Direction> list = new ArrayList<>();
        if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection().left()) == Terrain.STREET
            || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            list.add(getDirection().left());
        }
        if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection().right()) == Terrain.STREET
            || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            list.add(getDirection().right());
        }
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection()) == Terrain.STREET
            || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            list.add(getDirection());
        }
        return list;
    }

}
