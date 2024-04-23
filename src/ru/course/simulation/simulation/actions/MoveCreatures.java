package ru.course.simulation.simulation.actions;

import ru.course.simulation.entities.Entity;
import ru.course.simulation.simulation.Coordinates;

import java.util.ArrayList;
import java.util.Map;

public class MoveCreatures extends Action {
    @Override
    public void perform(Map<Coordinates, Entity> map, int mapSize) {

    }

    private void getCreatures() {


    }

    private Entity getNearestEntity(Entity entity, ArrayList<Entity> list) {
        for (Entity entity1 : list
        ) {
            if (Math.abs(entity.getCoordinates().x() - entity1.getCoordinates().x()) <= 1 &&
                    Math.abs(entity.getCoordinates().y() - entity1.getCoordinates().y()) <= 1)
                return entity1;
        }
        return null;
    }
}
