package ru.course.simulation.controllers.searcher;

import ru.course.simulation.controllers.Coordinates;

public class Cell {
    public Coordinates parent;
    // f = g + h, where h is heuristic
    public double f, g, h;

    Cell() {
        parent = new Coordinates(-1, -1);
        f = -1;
        g = -1;
        h = -1;
    }

    public Cell(Coordinates parent, double f, double g, double h) {
        this.parent = parent;
        this.f = f;
        this.g = g;
        this.h = h;
    }
}
