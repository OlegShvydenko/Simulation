package GamePackage.Entyties.Creatures;


import GamePackage.Entyties.Entity;
import GamePackage.Entyties.Grass;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int healthPoints, int fullnessOfFood) {
        super(coordinates, speed, healthPoints, fullnessOfFood);
    }

    @Override
    public void eat(Entity entity) {
        this.fullnessOfFood += ((Grass) entity).getQuantity();
        Simulation.getMap().remove(entity.getCoordinates());
        this.setAlreadyMoving(true);
    }

}
