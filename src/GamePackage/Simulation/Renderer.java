package GamePackage.Simulation;

import GamePackage.Entyties.Creatures.Herbivore;
import GamePackage.Entyties.Creatures.Predator;
import GamePackage.Entyties.Entity;
import GamePackage.Entyties.Grass;
import GamePackage.Entyties.Rock;
import GamePackage.Entyties.Tree;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer {
    private static BufferedImage GRASS;
    private static BufferedImage ROCK;
    private static BufferedImage TREE;
    private static BufferedImage HERBIVORE;
    private static BufferedImage PREDATOR;

    public Renderer() {
        setImages();
    }

    public void renderAll() {
        JFrame frame = new JFrame("Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createAndAddButtons(frame.getContentPane());
        frame.getContentPane().add(new MapRenderer());
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
            GRASS = ImageIO.read(new File("src/GamePackage/Sprites/Grass.png"));
            ROCK = ImageIO.read(new File("src/GamePackage/Sprites/Rock.png"));
            TREE = ImageIO.read(new File("src/GamePackage/Sprites/Tree.png"));
            HERBIVORE = ImageIO.read(new File("src/GamePackage/Sprites/Herbivore.png"));
            PREDATOR = ImageIO.read(new File("src/GamePackage/Sprites/Predator.png"));
        } catch (IOException e) {
            System.out.println("Ошибочка");
        }
    }

    static class MapRenderer extends JComponent {


        public void paint(Graphics g) {
            paintGrid(g);
            paintSprites(g);
        }


        private void paintSprites(Graphics g) {
            for (Coordinates coordinates : Simulation.getMap().keySet()) {
                int cellSize = 16;
                g.drawImage(checkTypeOfEntity(Simulation.getMap().get(coordinates)), coordinates.x() * cellSize, coordinates.y() * cellSize, null);
            }

        }
        private void paintGrid(Graphics g) {
            int cellSize = 16;
            for (int i = 0; i < Simulation.getMapSize() + 1; i++)
                g.drawLine(0, i * cellSize, Simulation.getMapSize() * cellSize, i * cellSize);

            for (int i = 0; i < Simulation.getMapSize() + 1; i++)
                g.drawLine(i * cellSize, 0, i * cellSize, Simulation.getMapSize() * cellSize);
        }

        private BufferedImage checkTypeOfEntity(Entity entity) {
            if (entity instanceof Grass) return GRASS;
            else if (entity instanceof Rock) return ROCK;
            else if (entity instanceof Tree) return TREE;
            else if (entity instanceof Herbivore) return HERBIVORE;
            else if (entity instanceof Predator) return PREDATOR;
            else return null;
        }
    }

    static class GridRenderer extends JComponent {
        public void paint(Graphics g) {
        }


    }


}
