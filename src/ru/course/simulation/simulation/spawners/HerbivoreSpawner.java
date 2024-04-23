package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.creatures.Herbivore;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;

public class HerbivoreSpawner extends Spawner {
    public HerbivoreSpawner(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Herbivore herbivore = new Herbivore(getARandomUnoccupiedPlace(map, mapSize), random.nextInt(3, 7), random.nextInt(5, 11), 10);
            spawn(herbivore, map);
        }
    }
}
