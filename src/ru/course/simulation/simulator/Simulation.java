package ru.course.simulation.simulator;


import ru.course.simulation.controllers.Coordinates;
import ru.course.simulation.controllers.CreatureController;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.entities.creatures.Herbivore;
import ru.course.simulation.entities.creatures.Predator;
import ru.course.simulation.factory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.course.simulation.factory.EntityType.*;

public class Simulation {
    private int moveCounter;
    private Map<Coordinates, Entity> map;
    private final int mapSize;

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    public Simulation(int mapSize) {
        this.mapSize = mapSize;
        this.map = new HashMap<>();
    }

    public int getMapSize() {
        return mapSize;
    }

    public void nextTurn() {
        moveCounter++;
    }

    public void startSimulation() {
        EntityFactory factory = new EntityFactory(this.getMap(), this.getMapSize());
        factory.createEntities(30, GRASS);
        factory.createEntities(40, ROCK);
        factory.createEntities(40, TREE);
        factory.createEntities(15, HERBIVORE);
        factory.createEntities(5, PREDATOR);
    }
    public void oneTurn(){
        CreatureController creatureController = new CreatureController();
        map = creatureController.moveCreatures(this.map, this.mapSize);
        addCreatures();
    }
    private void addCreatures(){
        int grasses = 0;
        int herbivores = 0;
        int predators =0;
        EntityFactory factory = new EntityFactory(this.getMap(), this.getMapSize());
        for (Entity entity: map.values()
             ) {
            if (entity instanceof Grass) grasses++;
            if (entity instanceof Herbivore) herbivores++;
            if (entity instanceof Predator) predators++;
        }
        if (grasses < herbivores) factory.createEntities(3, GRASS);
        if (herbivores < predators) factory.createEntities(3, HERBIVORE);
    }

    public void pauseSimulation() {

    }

}
