package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Creatures.Predator;


public class SpawnPredator extends SpawnAction {
    public SpawnPredator(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }

    @Override
    public void perform() {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Predator predator = new Predator(getARandomUnoccupiedPlace(), random.nextInt(2, 6), random.nextInt(3, 9), 10, random.nextInt(3, 11));
            spawn(predator);
        }
    }
}
