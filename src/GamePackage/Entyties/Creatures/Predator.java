package GamePackage.Entyties.Creatures;

import GamePackage.Entyties.Entity;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

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
    public void eat(Entity entity) {
        this.fullnessOfFood += 5;
        Simulation.getMap().remove(entity.getCoordinates());
        this.setAlreadyMoving(true);
    }
}
