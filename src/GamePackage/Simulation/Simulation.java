package GamePackage.Simulation;


import GamePackage.Entity;
import GamePackage.Simulation.Actions.Action;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private static int moveCounter;

    private ArrayList<Action> initActions;
    private ArrayList<Action> turnActions;
    private static HashMap<Coordinates, Entity> map;
    private static int mapSize;

    public static HashMap<Coordinates, Entity> getMap() {
        return map;
    }
    public Simulation(int mapSize){
        Simulation.mapSize = mapSize;
    }

    public static int getMapSize() {
        return mapSize;
    }

    public void setMap(HashMap<Coordinates, Entity> map) {
        Simulation.map = map;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public void nextTurn() {
        moveCounter++;
    }

    public void startSimulation() {

    }

    public void pauseSimulation() {

    }

}
