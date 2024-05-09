package ru.course.simulation.entities.creatures;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.controllers.Coordinates;

import java.util.Map;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        this.setSpeed(random.nextInt(1, 2));
        this.setHealthPoints(random.nextInt(6, 10));
        this.attackPower = random.nextInt(3, 8);
    }


    private void attack(Creature creature) {
        creature.setHealthPoints(creature.getHealthPoints() - this.attackPower);
        this.setAlreadyMoving(true);
    }

    @Override
    public void eat(Entity entity) {
        attack((Creature) entity);
    }
}
