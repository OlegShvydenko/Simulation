package GamePackage.Entyties.Creatures;


import GamePackage.Entyties.Entity;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;


public abstract class Creature extends Entity {
    private int speed;
    private int healthPoints;

    int fullnessOfFood;
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

    public void makeMove(Coordinates coordinates) {
        Simulation.getMap().remove(this.getCoordinates());
        this.setCoordinates(coordinates);
        Simulation.getMap().put(coordinates, this);
        this.alreadyMoving = true;
    }
    public abstract void eat(Entity entity);


}
