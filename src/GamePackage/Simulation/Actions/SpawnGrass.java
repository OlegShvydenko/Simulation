package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Grass;


public class SpawnGrass extends SpawnAction {

    public SpawnGrass(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }

    @Override
    public void perform() {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Grass grass = new Grass(getARandomUnoccupiedPlace(), random.nextInt(1, 6));
            spawn(grass);
        }
    }
}
