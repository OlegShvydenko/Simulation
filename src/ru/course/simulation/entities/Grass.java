package ru.course.simulation.entities;

import ru.course.simulation.controllers.Coordinates;

public class Grass extends Entity {
    private int quantity;

    public Grass(Coordinates coordinates){
        super(coordinates);
        this.quantity = random.nextInt(1, 4);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
