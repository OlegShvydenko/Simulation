package GamePackage.Entyties.Creatures;


import GamePackage.Entyties.Creature;
import GamePackage.Entyties.Grass;
import GamePackage.Simulation.Coordinates;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood) {
        super(coordinates, speed, healthPoints, fullnessOfFood);
    }
    @Override
    public void makeMove() {

    }
    public void eat(Grass grass) {
        this.fullnessOfFood += grass.getQuantity();
        grass.setQuantity(0);
    }
}
