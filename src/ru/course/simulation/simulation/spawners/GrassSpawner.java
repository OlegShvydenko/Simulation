package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.Grass;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;
import ru.course.simulation.simulation.spawners.Spawner;

import java.util.Map;


public class GrassSpawner extends Spawner {

    public GrassSpawner(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }

    @Override
    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Grass grass = new Grass(getARandomUnoccupiedPlace(map, mapSize), random.nextInt(1, 6));
            spawn(grass, map);
        }
    }
}
