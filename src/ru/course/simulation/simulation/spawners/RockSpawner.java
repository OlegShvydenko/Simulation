package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Rock;
import ru.course.simulation.simulation.Coordinates;
import ru.course.simulation.simulation.spawners.Spawner;

import java.util.Map;

public class RockSpawner extends Spawner {

    public RockSpawner(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Rock rock = new Rock(getARandomUnoccupiedPlace(map, mapSize));
            spawn(rock, map);
        }
    }
}
