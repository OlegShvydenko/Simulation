package ru.course.simulation.simulation.spawners;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Tree;
import ru.course.simulation.simulation.Coordinates;
import ru.course.simulation.simulation.spawners.Spawner;

import java.util.Map;

public class TreeSpawner extends Spawner {
    public TreeSpawner(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void spawnEntities(Map<Coordinates, Entity> map, int mapSize) {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Tree tree = new Tree(getARandomUnoccupiedPlace(map, mapSize));
            spawn(tree, map);
        }
    }
}
