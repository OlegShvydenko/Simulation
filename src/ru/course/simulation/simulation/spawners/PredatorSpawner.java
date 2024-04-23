package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.creatures.Predator;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;


public class PredatorSpawner extends Spawner {
    public PredatorSpawner(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }

    @Override
    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Predator predator = new Predator(getARandomUnoccupiedPlace(map, mapSize), random.nextInt(2, 6), random.nextInt(3, 9), 10, random.nextInt(3, 11));
            spawn(predator, map);
        }
    }
}
