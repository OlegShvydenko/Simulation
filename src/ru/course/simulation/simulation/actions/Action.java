package ru.course.simulation.simulation.actions;


import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.Map;

public abstract class Action {
    public abstract void perform(Map<Coordinates, Entity> map, int mapSize);

}
