package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Rock;

public class SpawnRock extends SpawnAction{

    public SpawnRock(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void perform() {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Rock rock = new Rock(getARandomUnoccupiedPlace());
            spawn(rock);
        }
    }
}
