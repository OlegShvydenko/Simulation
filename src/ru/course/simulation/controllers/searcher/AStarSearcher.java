package ru.course.simulation.controllers.searcher;

import ru.course.simulation.controllers.Coordinates;
import ru.course.simulation.entities.Entity;

import java.util.*;

public class AStarSearcher {

    Map<Coordinates, Entity> map;
    int mapSize;

    public AStarSearcher(Map<Coordinates, Entity> map, int mapSize) {
        this.map = map;
        this.mapSize = mapSize;
    }

    // method to check if our cell (row, col) is valid
    private boolean isValid(Coordinates point) {
        if (mapSize > 0)
            return (point.x() >= 0) && (point.x() < mapSize)
                    && (point.y() >= 0)
                    && (point.y() < mapSize);

        return false;
    }

    //is the cell blocked?

    private boolean isUnBlocked(Coordinates point) {
        return isValid(point)
                && !map.containsKey(point);
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

    private ArrayList<Coordinates> tracePath(Cell[][] cellDetails, Coordinates dest) {   //A* Search algorithm path
        //System.out.println("The Path:  ");

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

    public ArrayList<Coordinates> search(Coordinates src, Coordinates dest) {

//        if (!isValid(src)) {
//            System.out.println("Source is invalid...");
//            return null;
//        }


//        if (!isValid(dest)) {
//            System.out.println("Destination is invalid...");
//            return null;
//        }


//        if (!isUnBlocked(src)
//                || !isUnBlocked(dest)) {
//            System.out.println("Source or destination is blocked...");
//            return null;
//        }


        if (isDestination(src, dest)) {
            System.out.println("We're already (t)here...");
            return null;
        }


        boolean[][] closedList = new boolean[mapSize][mapSize];//our closed list

        Cell[][] cellDetails = new Cell[mapSize][mapSize];

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
                    if (isValid(neighbour)) {
                        if (cellDetails[neighbour.x()] == null) {
                            cellDetails[neighbour.x()] = new Cell[mapSize];
                        }
                        if (cellDetails[neighbour.x()][neighbour.y()] == null) {
                            cellDetails[neighbour.x()][neighbour.y()] = new Cell();
                        }

                        if (isDestination(neighbour, dest)) {
                            cellDetails[neighbour.x()][neighbour.y()].parent = new Coordinates(i, j);
                            //System.out.println("The destination cell is found");

                            return tracePath(cellDetails, dest);
                        } else if (!closedList[neighbour.x()][neighbour.y()]
                                && isUnBlocked(neighbour)) {
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
