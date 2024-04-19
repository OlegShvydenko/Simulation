package GamePackage.Entyties.Creatures;

import GamePackage.Entyties.Creature;
import GamePackage.Simulation.Coordinates;

public class Predator extends Creature {
    private final int attackPower;
    public Predator(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood, int attackPower){
        super(coordinates, speed, healthPoints, fullnessOfFood);
        this.attackPower = attackPower;
    }
    @Override
    public void makeMove() {

    }

    public void eat() {
        this.fullnessOfFood += 5;
    }
    public void attack(Herbivore herbivore) {
        herbivore.setHealthPoints(herbivore.getHealthPoints() - this.attackPower);
    }

}
