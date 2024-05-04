package ru.course.simulation.entities;

import ru.course.simulation.controllers.Coordinates;

import java.util.Random;

public abstract class Entity {
    private Coordinates coordinates;
    protected final Random random = new Random();
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
