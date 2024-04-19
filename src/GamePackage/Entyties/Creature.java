package GamePackage.Entyties;


import GamePackage.Entity;
import GamePackage.Simulation.Coordinates;


public abstract class Creature extends Entity {
    protected int speed;
    protected int healthPoints;

    protected int fullnessOfFood;
    protected boolean alreadyMoving;

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

    public abstract void makeMove();



}
