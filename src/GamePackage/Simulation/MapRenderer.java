package GamePackage.Simulation;

import GamePackage.Entyties.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

class MapRenderer extends JComponent {
    Map<Coordinates, Entity> map;
    Map<Class, BufferedImage> sprites;

    public MapRenderer(Map<Coordinates, Entity> map, Map<Class, BufferedImage> sprites) {
        this.map = map;
        this.sprites = sprites;
    }


    @Override
    public void paint(Graphics g) {
        paintGrid(g);
        paintSprites(g);
    }


    private void paintSprites(Graphics g) {
        for (Coordinates coordinates : map.keySet()) {
            int cellSize = 16;
            g.drawImage(sprites.get(map.get(coordinates).getClass()), coordinates.x() * cellSize, coordinates.y() * cellSize, null);
        }

    }

    private void paintGrid(Graphics g) {
        int cellSize = 16;
        for (int i = 0; i < map.size() + 1; i++)
            g.drawLine(0, i * cellSize, map.size() * cellSize, i * cellSize);

        for (int i = 0; i < map.size() + 1; i++)
            g.drawLine(i * cellSize, 0, i * cellSize, map.size() * cellSize);
    }
}
