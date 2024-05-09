package ru.course.simulation.controllers;

import ru.course.simulation.controllers.searcher.AStarSearcher;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.entities.creatures.*;


import java.util.*;

public class CreatureController {
    //private int mapSize;
    //private Map<Coordinates, Entity> map;
    private final Map<Class, Class> relationshipOfEntity = new HashMap<>();
    ;

    public CreatureController() {
        relationshipOfEntity.put(Herbivore.class, Grass.class);
        relationshipOfEntity.put(Predator.class, Herbivore.class);
    }


    public Map<Coordinates, Entity> moveCreatures(Map<Coordinates, Entity> map, int mapSize) {
        eatAll(map);
        AStarSearcher searcher = new AStarSearcher(map, mapSize);
        Map<Coordinates, Entity> newMap = new HashMap<>();
        for (Entity entity : map.values()) {
            if (entity instanceof Creature && !((Creature) entity).isAlreadyMoving()) {
                List<Entity> list = findVictims(entity, map);
                for (Entity entity1 : list
                ) {
                    List<Coordinates> list1 = searcher.search(entity.getCoordinates(), entity1.getCoordinates());
                    if (list1 != null) {
                        if (!map.containsKey(list1.get(checkIndex(list1, (Creature) entity))) && !newMap.containsKey(list1.get(checkIndex(list1, (Creature) entity)))) {
                            newMap.put(list1.get(checkIndex(list1, (Creature) entity)), entity);
                            ((Creature) entity).makeMove(list1.get(checkIndex(list1, (Creature) entity)), map);
                            break;
                        }
                    }
                }
            }
        }

        for (Entity entity : map.values()) {
            newMap.put(entity.getCoordinates(), entity);
        }
        map = newMap;
        deleteDeathEntity(map);
        return map;
    }

    private int checkIndex(List<Coordinates> list, Creature creature) {
        if (creature.getSpeed() >= list.size()) return list.size() - 1;
        return creature.getSpeed();
    }

    private List<Entity> findVictims(Entity entity, Map<Coordinates, Entity> map) {
        List<Entity> listOfVictims = new ArrayList<>();
        for (Entity entity1 : map.values()) {
            if (relationshipOfEntity.get(entity.getClass()) == entity1.getClass()) listOfVictims.add(entity1);
        }
        Collections.sort(listOfVictims, (entity1, entity2) -> Integer.compare(calculateDistance(entity, entity1), calculateDistance(entity, entity2)));
        return listOfVictims;
    }

    private int calculateDistance(Entity entity1, Entity entity2) {
        Coordinates src = entity1.getCoordinates();
        Coordinates dest = entity2.getCoordinates();
        return (int) Math.sqrt(Math.pow((src.x() - dest.x()), 2.0) + Math.pow((src.y() - dest.y()), 2.0));
    }

    private void deleteDeathEntity(Map<Coordinates, Entity> map) {
        List<Coordinates> coordinatesOfDeathEntity = new ArrayList<>();
        for (Entity entity : map.values()
        ) {
            if (entity instanceof Creature) ((Creature) entity).setAlreadyMoving(false);
            if (entity instanceof Grass) {
                if (((Grass) entity).getQuantity() <= 0) coordinatesOfDeathEntity.add(entity.getCoordinates());
            }
            if (entity instanceof Herbivore) {
                if (((Herbivore) entity).getHealthPoints() <= 0) coordinatesOfDeathEntity.add(entity.getCoordinates());
            }
        }
        for (Coordinates coordinates : coordinatesOfDeathEntity
        ) {
            map.remove(coordinates);
        }
    }

    private void eatAll(Map<Coordinates, Entity> map) {
        for (Entity entity : map.values()) {
            if (entity instanceof Creature) eatOrAttackNearestEntity((Creature) entity, map);
        }
    }

    private void eatOrAttackNearestEntity(Creature creature, Map<Coordinates, Entity> map) {
        List<Entity> list = findNeighbour(creature, map);
        for (Entity entity1 : list) {
            if (relationshipOfEntity.get(creature.getClass()) == entity1.getClass()) {
                creature.eat(entity1);
                break;
            }
        }
    }

    private List<Entity> findNeighbour(Creature creature, Map<Coordinates, Entity> map) {
        List<Entity> neighbours = new ArrayList<>();
        int x = creature.getCoordinates().x();
        int y = creature.getCoordinates().y();
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                Coordinates coordinates = new Coordinates(x + xx, y + yy);
                if (map.containsKey(coordinates)) neighbours.add(map.get(coordinates));
            }
        }
        return neighbours;
    }
}
