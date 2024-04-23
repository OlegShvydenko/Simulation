package ru.course.simulation.entities.creatures;


import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood) {
        super(coordinates, speed, healthPoints, fullnessOfFood);
    }

    @Override
    public void eat(Entity entity, Map<Coordinates, Entity> map) {
        this.setFullnessOfFood(this.getFullnessOfFood() + ((Grass) entity).getQuantity());
        map.remove(entity.getCoordinates());
        this.setAlreadyMoving(true);
    }

}
