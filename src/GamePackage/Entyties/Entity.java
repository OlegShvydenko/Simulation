package GamePackage.Entyties;

import GamePackage.Simulation.Coordinates;

public abstract class Entity {
    private Coordinates coordinates;
    public Entity(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
