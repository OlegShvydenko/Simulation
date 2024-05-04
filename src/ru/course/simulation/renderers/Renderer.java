package ru.course.simulation.renderers;


import ru.course.simulation.controllers.CreatureController;
import ru.course.simulation.entities.creatures.Herbivore;
import ru.course.simulation.entities.creatures.Predator;
import ru.course.simulation.entities.Entity;
import ru.course.simulation.entities.Grass;
import ru.course.simulation.entities.Rock;
import ru.course.simulation.entities.Tree;
import ru.course.simulation.controllers.Coordinates;
import ru.course.simulation.simulator.Simulation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Renderer {
    private Map<Class, BufferedImage> sprites;
    Simulation simulation;
    JFrame frame = new JFrame("Simulation");

    public Renderer(Simulation simulation) {
        this.sprites = new HashMap<>();
        this.simulation = simulation;
        setImages(this.sprites);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAndAddButtons(frame.getContentPane());
        frame.setBounds(560, 140, 800, 800);
        frame.setVisible(true);
    }

    public void renderAll() {
        frame.getContentPane().removeAll();
        createAndAddButtons(frame.getContentPane());
        frame.getContentPane().add(new MapRenderer(simulation.getMap(), simulation.getMapSize(), this.sprites));
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    private void createAndAddButtons(Container container) {

        JButton button1 = new JButton("Начать симуляцию");
        JButton button2 = new JButton("Сделать ход");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.startSimulation();
                renderAll();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.oneTurn();
                renderAll();
            }
        });

        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        btnPanel.add(button1);
        btnPanel.add(button2);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flow.add(btnPanel);
        container.add(flow, BorderLayout.NORTH);
    }

    private void setImages(Map<Class, BufferedImage> sprites) {
        try {
            sprites.put(Grass.class, ImageIO.read(new File("src/ru/course/simulation/sprites/Grass.png")));
            sprites.put(Rock.class, ImageIO.read(new File("src/ru/course/simulation/sprites/Rock.png")));
            sprites.put(Tree.class, ImageIO.read(new File("src/ru/course/simulation/sprites/Tree.png")));
            sprites.put(Herbivore.class, ImageIO.read(new File("src/ru/course/simulation/sprites/Herbivore.png")));
            sprites.put(Predator.class, ImageIO.read(new File("src/ru/course/simulation/sprites/Predator.png")));
        } catch (IOException e) {
            System.out.println("Ошибочка");
            System.out.println(e);
        }
    }
}