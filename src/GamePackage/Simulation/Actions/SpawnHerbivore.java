package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Creatures.Herbivore;

public class SpawnHerbivore extends SpawnAction{
    public SpawnHerbivore(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void perform() {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Herbivore herbivore = new Herbivore(getARandomUnoccupiedPlace(), random.nextInt(3, 7), random.nextInt(5, 11), 10);
            spawn(herbivore);
        }
    }
}
