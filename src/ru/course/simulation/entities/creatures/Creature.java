package ru.course.simulation.entities.creatures;


import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;


public abstract class Creature extends Entity {
    private int speed;
    private int healthPoints;

    private int fullnessOfFood;
    private boolean alreadyMoving;

    public Creature(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood){
        super(coordinates);
        this.speed = speed;
        this.healthPoints = healthPoints;
        this.fullnessOfFood = fullnessOfFood;
    }

    public int getFullnessOfFood() {
        return fullnessOfFood;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setFullnessOfFood(int fullnessOfFood) {
        this.fullnessOfFood = fullnessOfFood;
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
        map.remove(this.getCoordinates());
        this.setCoordinates(coordinates);
        map.put(coordinates, this);
        this.alreadyMoving = true;
    }
    public abstract void eat(Entity entity, Map<Coordinates, Entity> map);


}
