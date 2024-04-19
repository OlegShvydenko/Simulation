package GamePackage.Simulation;

import GamePackage.Entyties.Creatures.Herbivore;
import GamePackage.Entyties.Creatures.Predator;
import GamePackage.Entyties.Entity;
import GamePackage.Entyties.Grass;
import GamePackage.Entyties.Rock;
import GamePackage.Entyties.Tree;

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

    public Renderer() {
        setImages();
        sprites = new HashMap<>();
    }

    public void renderAll(Map<Coordinates, Entity> map) {
        JFrame frame = new JFrame("Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createAndAddButtons(frame.getContentPane());
        frame.getContentPane().add(new MapRenderer(map, sprites));
        frame.setBounds(760, 340, 400, 400);
        frame.setVisible(true);
    }

    private void createAndAddButtons(Container container) {

        JButton button1 = new JButton("Начать симуляцию");
        JButton button2 = new JButton("Остановить симуляцию");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
            }
        });

        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        btnPanel.add(button1);
        btnPanel.add(button2);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flow.add(btnPanel);
        container.add(flow, BorderLayout.NORTH);
    }

    private void setImages() {
        try {
            sprites.put(Grass.class, ImageIO.read(new File("src/GamePackage/Sprites/Grass.png")));
            sprites.put(Rock.class, ImageIO.read(new File("src/GamePackage/Sprites/Rock.png")));
            sprites.put(Tree.class, ImageIO.read(new File("src/GamePackage/Sprites/Tree.png")));
            sprites.put(Herbivore.class, ImageIO.read(new File("src/GamePackage/Sprites/Herbivore.png")));
            sprites.put(Predator.class, ImageIO.read(new File("src/GamePackage/Sprites/Predator.png")));
        } catch (IOException e) {
            System.out.println("Ошибочка");
        }
    }
}
