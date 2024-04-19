package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Tree;

public class SpawnTree extends SpawnAction{
    public SpawnTree(int numberOfRepetitions) {
        super(numberOfRepetitions);
    }
    @Override
    public void perform() {
        for (int i = 0; i < this.numberOfRepetitions; i++) {
            Tree tree = new Tree(getARandomUnoccupiedPlace());
            spawn(tree);
        }
    }
}
