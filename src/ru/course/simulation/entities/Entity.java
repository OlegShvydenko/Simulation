package ru.course.simulation.entities;

import ru.course.simulation.simulation.Coordinates;

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