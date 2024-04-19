package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Entity;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

import java.util.Random;

public abstract class SpawnAction extends Action {
    protected int numberOfRepetitions;
    protected Random random = new Random();

    public SpawnAction(int numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    @Override
    public void perform() {

    }

    protected void spawn(Entity entity) {
        Simulation.getMap().put(entity.getCoordinates(), entity);
    }

    protected Coordinates getARandomUnoccupiedPlace() {
        while (true) {
            Coordinates coordinates = new Coordinates(random.nextInt(Simulation.getMapSize()), random.nextInt(Simulation.getMapSize()));
            if (checkPlace(coordinates)) return coordinates;
        }
    }

    private boolean checkPlace(Coordinates coordinates) {
        return !Simulation.getMap().containsKey(coordinates);
    }
}
