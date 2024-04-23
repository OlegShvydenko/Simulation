package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;
import java.util.Random;

public abstract class Spawner {
    protected final Random random = new Random();
    protected int numberOfRepetitions;

    public Spawner(int numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {

    }

    protected void spawn(Entity entity, Map<Coordinates, Entity> map) {
        map.put(entity.getCoordinates(), entity);
    }

    protected Coordinates getARandomUnoccupiedPlace(Map<Coordinates, Entity> map, int mapSize) {
        while (true) {
            Coordinates coordinates = new Coordinates(random.nextInt(mapSize), random.nextInt(mapSize));
            if (checkPlace(map, coordinates)) return coordinates;
        }
    }

    private boolean checkPlace(Map<Coordinates, Entity> map, Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }
}
