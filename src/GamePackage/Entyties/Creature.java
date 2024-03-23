package GamePackage.Entyties;


import GamePackage.Entity;

public abstract class Creature extends Entity {
    protected int speed;
    protected int healthPoints;

    protected int fullnessOfFood;

    public abstract void makeMove();

    public abstract void eat();
}
