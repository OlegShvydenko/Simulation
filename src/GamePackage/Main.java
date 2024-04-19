package GamePackage;

import GamePackage.Simulation.Renderer;
import GamePackage.Simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(20);
        simulation.startSimulation();
        Renderer renderer = new Renderer();
        renderer.renderAll();
    }
}