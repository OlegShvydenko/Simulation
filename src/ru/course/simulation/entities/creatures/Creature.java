package ru.course.simulation.entities.creatures;


import ru.course.simulation.entities.Entity;
import ru.course.simulation.controllers.Coordinates;

import java.util.Map;


public abstract class Creature extends Entity {
    private int speed;
    private int healthPoints;
    private boolean alreadyMoving;

    public Creature(Coordinates coordinates){
        super(coordinates);

    }


    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return speed;
    }


    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlreadyMoving() {
        return alreadyMoving;
    }

    public void setAlreadyMoving(boolean alreadyMoving) {
        this.alreadyMoving = alreadyMoving;
    }

    public void makeMove(Coordinates coordinates, Map<Coordinates, Entity> map) {
        this.setCoordinates(coordinates);
        this.alreadyMoving = true;
    }
    public abstract void eat(Entity entity);


}
