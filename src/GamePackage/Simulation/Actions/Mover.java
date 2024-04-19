package GamePackage.Simulation.Actions;

import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Mover {
    public static class Details {
        double value;
        int i;
        int j;

        public Details(double value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    public static class Cell {
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

    // method to check if our cell (row, col) is valid
    private boolean isValid(int rows, int cols,
                    Coordinates point) {
        if (rows > 0 && cols > 0)
            return (point.x() >= 0) && (point.x() < rows)
                    && (point.y() >= 0)
                    && (point.y() < cols);

        return false;
    }

    //is the cell blocked?

    private boolean isUnBlocked(int rows, int cols,
                        Coordinates point) {
        return isValid(rows, cols, point)
                && !Simulation.getMap().containsKey(point);
    }

    //Method to check if destination cell has been already reached
    private boolean isDestination(Coordinates position, Coordinates dest) {
        return position == dest || position.equals(dest);
    }

    // Method to calculate heuristic function
    private double calculateHValue(Coordinates src, Coordinates dest) {
        return Math.sqrt(Math.pow((src.x() - dest.x()), 2.0) + Math.pow((src.y() - dest.y()), 2.0));
    }

    // Method for tracking the path from source to destination

    private ArrayList<Coordinates> tracePath(
            Cell[][] cellDetails,
            Coordinates dest) {   //A* Search algorithm path
        System.out.println("The Path:  ");

        Stack<Coordinates> path = new Stack<>();

        int row = dest.x();
        int col = dest.y();

        Coordinates nextNode;
        do {
            path.push(new Coordinates(row, col));
            nextNode = cellDetails[row][col].parent;
            row = nextNode.x();
            col = nextNode.y();
        } while (cellDetails[row][col].parent != nextNode); // until src


        ArrayList<Coordinates> list = new ArrayList<>(path);
        Collections.reverse(list);
        return list;
    }

// A main method, A* Search algorithm to find the shortest path

    private ArrayList<Coordinates> aStarSearch(Coordinates src,
                                 Coordinates dest,
                                 int rows,
                                 int cols) {

        if (!isValid(rows, cols, src)) {
            System.out.println("Source is invalid...");
            return null;
        }


        if (!isValid(rows, cols, dest)) {
            System.out.println("Destination is invalid...");
            return null;
        }


        if (!isUnBlocked(rows, cols, src)
                || !isUnBlocked(rows, cols, dest)) {
            System.out.println("Source or destination is blocked...");
            return null;
        }


        if (isDestination(src, dest)) {
            System.out.println("We're already (t)here...");
            return null;
        }


        boolean[][] closedList = new boolean[rows][cols];//our closed list

        Cell[][] cellDetails = new Cell[rows][cols];

        int i, j;
        // Initialising of the starting cell
        i = src.x();
        j = src.y();
        cellDetails[i][j] = new Cell();
        cellDetails[i][j].f = 0.0;
        cellDetails[i][j].g = 0.0;
        cellDetails[i][j].h = 0.0;
        cellDetails[i][j].parent = new Coordinates(i, j);


        // Creating an open list


        PriorityQueue<Details> openList = new PriorityQueue<>((o1, o2) -> (int) Math.round(o1.value - o2.value));

        // Put the starting cell on the open list,   set f.startCell = 0

        openList.add(new Details(0.0, i, j));

        while (!openList.isEmpty()) {
            Details p = openList.peek();
            // Add to the closed list
            i = p.i; // second element of tuple
            j = p.j; // third element of tuple

            // Remove from the open list
            openList.poll();
            closedList[i][j] = true;

            // Generating all the 8 neighbors of the cell

            for (int addX = -1; addX <= 1; addX++) {
                for (int addY = -1; addY <= 1; addY++) {
                    Coordinates neighbour = new Coordinates(i + addX, j + addY);
                    if (isValid(rows, cols, neighbour)) {
                        if (cellDetails[neighbour.x()] == null) {
                            cellDetails[neighbour.x()] = new Cell[cols];
                        }
                        if (cellDetails[neighbour.x()][neighbour.y()] == null) {
                            cellDetails[neighbour.x()][neighbour.y()] = new Cell();
                        }

                        if (isDestination(neighbour, dest)) {
                            cellDetails[neighbour.x()][neighbour.y()].parent = new Coordinates(i, j);
                            System.out.println("The destination cell is found");

                            return tracePath(cellDetails, dest);
                        } else if (!closedList[neighbour.x()][neighbour.y()]
                                && isUnBlocked(rows, cols, neighbour)) {
                            double gNew, hNew, fNew;
                            gNew = cellDetails[i][j].g + 1.0;
                            hNew = calculateHValue(neighbour, dest);
                            fNew = gNew + hNew;

                            if (cellDetails[neighbour.x()][neighbour.y()].f == -1
                                    || cellDetails[neighbour.x()][neighbour.y()].f > fNew) {

                                openList.add(new Details(fNew, neighbour.x(), neighbour.y()));

                                // Update the details of this
                                // cell
                                cellDetails[neighbour.x()][neighbour.y()].g = gNew;
//heuristic function                               cellDetails[neighbour.first][neighbour.second].h = hNew;
                                cellDetails[neighbour.x()][neighbour.y()].f = fNew;
                                cellDetails[neighbour.x()][neighbour.y()].parent = new Coordinates(i, j);
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Failed to find the Destination Cell");
        return null;
    }
}
