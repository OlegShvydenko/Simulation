package ru.course.simulation.entities.creatures;


import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.controllers.Coordinates;

import java.util.Map;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        this.setSpeed(random.nextInt(1, 3));
        this.setHealthPoints(random.nextInt(4, 10));
    }

    @Override
    public void eat(Entity entity) {
        this.setHealthPoints(this.getHealthPoints() + ((Grass) entity).getQuantity());
        ((Grass) entity).setQuantity(0);
        this.setAlreadyMoving(true);
    }

}
