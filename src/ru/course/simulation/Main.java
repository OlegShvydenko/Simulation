package ru.course.simulation;

import ru.course.simulation.renderers.Renderer;
import ru.course.simulation.simulator.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(40);
        Renderer renderer = new Renderer(simulation);

    }
}