package GamePackage.Entyties;

import GamePackage.Entity;
import GamePackage.Simulation.Coordinates;

public class Grass extends Entity {
    private int quantity;

    public Grass(Coordinates coordinates, int quantity){
        super(coordinates);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
