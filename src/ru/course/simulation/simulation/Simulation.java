package ru.course.simulation.simulation;


import ru.course.simulation.simulation.actions.*;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.spawners.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simulation {
    private int moveCounter;

    private ArrayList<Action> turnActions;
    private HashMap<Coordinates, Entity> map;
    private final int mapSize;

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }
    public Simulation(int mapSize){
        this.mapSize = mapSize;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMap(HashMap<Coordinates, Entity> map) {
        this.map = map;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public void nextTurn() {
        moveCounter++;
    }

    public void startSimulation() {
        List<Spawner> spawners = new ArrayList<>();
        map = new HashMap<>();
        spawners.add(new GrassSpawner(10));
        spawners.add(new RockSpawner(25));
        spawners.add(new TreeSpawner(25));
        spawners.add(new HerbivoreSpawner(7));
        spawners.add(new PredatorSpawner(5));
        for (Spawner spawner: spawners
             ) {
            spawner.spawnEntities(this.getMap(), this.getMapSize());
        }
    }

    public void pauseSimulation() {

    }

}
