package GamePackage.Simulation;


import GamePackage.Entyties.Entity;
import GamePackage.Simulation.Actions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private static int moveCounter;

    private static ArrayList<Action> initActions;
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
        initActions = new ArrayList<>();
        map = new HashMap<>();
        initActions.add(new SpawnGrass(10));
        initActions.add(new SpawnRock(25));
        initActions.add(new SpawnTree(25));
        initActions.add(new SpawnHerbivore(7));
        initActions.add(new SpawnPredator(5));
        for (Action action: initActions
             ) {
            action.perform();
        }
    }

    public void pauseSimulation() {

    }

}
