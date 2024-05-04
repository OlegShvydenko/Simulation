package ru.course.simulation.factory;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.controllers.Coordinates;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.entities.Rock;
import ru.course.simulation.entities.Tree;
import ru.course.simulation.entities.creatures.Herbivore;
import ru.course.simulation.entities.creatures.Predator;
import ru.course.simulation.simulator.Simulation;

import java.util.Map;
import java.util.Random;

import static ru.course.simulation.factory.EntityType.*;

public class EntityFactory {
    private final Random random = new Random();
    Map<Coordinates, Entity> map;
    int mapSize;
    public void createEntities(int numberOfRepetitions, EntityType type){
        for (int i = 0; i < numberOfRepetitions; i++) {
            createAndSpawnEntity(type);
        }
    }

    private void createAndSpawnEntity(EntityType type) {
        Coordinates coordinates = getARandomUnoccupiedPlace();
        Entity entity = switch (type) {
            case GRASS -> new Grass(coordinates);
            case ROCK -> new Rock(coordinates);
            case TREE -> new Tree(coordinates);
            case PREDATOR -> new Predator(coordinates);
            case HERBIVORE -> new Herbivore(coordinates);
        };
        spawn(entity);

    }

    public EntityFactory(Map<Coordinates, Entity> map, int mapSize) {
        this.map = map;
        this.mapSize = mapSize;
    }


    private void spawn(Entity entity) {
        this.map.put(entity.getCoordinates(), entity);
    }

    private Coordinates getARandomUnoccupiedPlace() {
        while (true) {
            Coordinates coordinates = new Coordinates(random.nextInt(this.mapSize), random.nextInt(this.mapSize));
            if (checkPlace(coordinates)) return coordinates;
        }
    }

    private boolean checkPlace(Coordinates coordinates) {
        return !this.map.containsKey(coordinates);
    }
}
