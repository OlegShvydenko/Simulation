package ru.course.simulation.entities.creatures;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood, int attackPower) {
        super(coordinates, speed, healthPoints, fullnessOfFood);
        this.attackPower = attackPower;
    }


    public void attack(Herbivore herbivore) {
        herbivore.setHealthPoints(herbivore.getHealthPoints() - this.attackPower);
        this.setAlreadyMoving(true);
    }

    @Override
    public void eat(Entity entity, Map<Coordinates, Entity> map) {
        this.setFullnessOfFood(this.getFullnessOfFood() + 5);
        map.remove(entity.getCoordinates());
        this.setAlreadyMoving(true);
    }
}
