/*
 * TCSS 305 - Road Rage
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import model.Bicycle;
import model.Car;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;

/**
 * @author diem vu
 * @version 10/26/2018
 */
public class TruckTest {

    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     * Test method for {@link model.AbstractVehicle#isAlive()}. Test method for
     * {@link model.AbstractVehicle#getDeathTime()}. Test method for
     * {@link model.AbstractVehicle#getDirection()}. Test method for
     * {@link model.AbstractVehicle#getX()}. Test method for
     * {@link model.AbstractVehicle#getY()}.
     */
    @Test
    public void testTruckGetXGetYGetDirectionIsAlive() {
        final Truck truck = new Truck(4, 5, Direction.NORTH);
        assertEquals("failed to initialize X value", 4, truck.getX());
        assertEquals("failed to initialize Y value", 5, truck.getY());
        assertEquals("failed to initiate Direction value", Direction.NORTH,
                     truck.getDirection());
        assertEquals("failed to initiate X value", 0, truck.getDeathTime());
        assertTrue("fails to initialize isAlive", truck.isAlive());

    }

    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPass() {
        final Truck truck = new Truck(4, 5, Direction.NORTH);
        assertTrue("failed to set up canPass", truck.canPass(Terrain.STREET, Light.RED));
        assertTrue("failed to set up canPass", truck.canPass(Terrain.LIGHT, Light.RED));
        assertTrue("failed to set up canPass", truck.canPass(Terrain.CROSSWALK, Light.GREEN));
        assertTrue("failed to set up canPass", truck.canPass(Terrain.CROSSWALK, Light.YELLOW));
        assertFalse("failed to set up canPass", truck.canPass(Terrain.CROSSWALK, Light.RED));

    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionWest() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();

        final Truck truck = new Truck(4, 5, Direction.NORTH);

        neighbors.put(Direction.WEST, Terrain.CROSSWALK);
        assertEquals("failed to choose a direction", Direction.WEST,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.WEST);

        neighbors.put(Direction.WEST, Terrain.LIGHT);
        assertEquals("failed to choose a direction", Direction.WEST,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.WEST);

        neighbors.put(Direction.WEST, Terrain.STREET);
        assertEquals("failed to choose a direction", Direction.WEST,
                     truck.chooseDirection(neighbors));
        neighbors.remove(Direction.WEST);
        assertEquals("failed to choose a direction", Direction.SOUTH,
                     truck.chooseDirection(neighbors));
        
        

    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionNorth() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();

        final Truck truck = new Truck(4, 5, Direction.NORTH);

        neighbors.put(Direction.NORTH, Terrain.CROSSWALK);
        assertEquals("failed to choose a direction", Direction.NORTH,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.NORTH);

        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        assertEquals("failed to choose a direction", Direction.NORTH,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.NORTH);

        neighbors.put(Direction.NORTH, Terrain.STREET);
        assertEquals("failed to choose a direction", Direction.NORTH,
                     truck.chooseDirection(neighbors));
        

    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionEast() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();

        final Truck truck = new Truck(4, 5, Direction.NORTH);

        neighbors.put(Direction.EAST, Terrain.CROSSWALK);
        assertEquals("failed to choose a direction", Direction.EAST,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.EAST);

        neighbors.put(Direction.EAST, Terrain.LIGHT);
        assertEquals("failed to choose a direction", Direction.EAST,
                     truck.chooseDirection(neighbors));

        neighbors.remove(Direction.EAST);

        neighbors.put(Direction.EAST, Terrain.STREET);
        assertEquals("failed to choose a direction", Direction.EAST,
                     truck.chooseDirection(neighbors));
    }

    /**
     * Test method for {@link model.AbstractVehicle#collide(model.Vehicle)}.
     * Test method for {@link model.AbstractVehicle#getImageFileName()}.
     */
    @Test
    public void testCollideGetImageFileName() {
        final Truck truck = new Truck(4, 5, Direction.NORTH);
        final Car car = new Car(4, 5, Direction.NORTH);
        final Bicycle bicycle = new Bicycle(4, 5, Direction.NORTH);
        assertEquals(" failed to get Image File Name", "truck.gif", truck.getImageFileName());
        truck.collide(car);
        truck.collide(bicycle);
        car.collide(truck);
        assertEquals(" failed to get Image File Name", "car_dead.gif", car.getImageFileName());
        assertFalse("failed to set up collide", car.isAlive());
        assertTrue("failed to set up collide", truck.isAlive());
        truck.collide(car);
        assertTrue("failed to set up collide", truck.isAlive());
        assertFalse("failed to set up collide", car.isAlive());
        car.collide(bicycle);
        assertFalse("failed to set up collide", car.isAlive());
        assertTrue("failed to set up collide", bicycle.isAlive());

    }

    /**
     * Test method for {@link model.AbstractVehicle#poke()}. Truck's DeathTime =
     * 0 so we will use Car to test poke
     */
    @Test
    public void testPoke() {
        final Car car = new Car(4, 5, Direction.NORTH);
        car.poke();
        car.poke();
        assertEquals("failed to get the object name", "car myDeathTime 15 myPoke 2",
                     car.toString());

    }

    /**
     * Test method for {@link model.AbstractVehicle#reset()}. Test method for
     * {@link model.AbstractVehicle#setX(int)}. Test method for
     * {@link model.AbstractVehicle#setY(int)}. Test method for
     * {@link model.AbstractVehicle#setDirection(model.Direction)}.
     */
    @Test
    public void testResetSetXSetYSetDirection() {
        final Truck truck = new Truck(4, 5, Direction.NORTH);
        truck.setX(6);
        truck.setY(7);
        truck.setDirection(Direction.SOUTH);
        assertEquals("failed to set X", 6, truck.getX());
        assertEquals("failed to set Y", 7, truck.getY());
        assertEquals("failed to set Direction", Direction.SOUTH, truck.getDirection());

        truck.reset();
        assertEquals("failed to set X", 4, truck.getX());
        assertEquals("failed to set Y", 5, truck.getY());
        assertEquals("failed to set X", Direction.NORTH, truck.getDirection());

    }

    /**
     * Test method for {@link model.AbstractVehicle#toString()}.
     */
    @Test
    public void testToString() {
        final Truck truck = new Truck(4, 5, Direction.NORTH);
        truck.poke();
        truck.poke();
        assertEquals("failed to get the object name", "truck myDeathTime 0 myPoke 0",
                     truck.toString());

    }

}
