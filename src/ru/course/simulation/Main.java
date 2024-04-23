package ru.course.simulation;

import ru.course.simulation.simulation.renderers.Renderer;
import ru.course.simulation.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(20);
        simulation.startSimulation();
        Renderer renderer = new Renderer();
        renderer.renderAll(simulation.getMap(), simulation.getMapSize());
    }
}