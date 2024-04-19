package GamePackage.Simulation.Actions;

import GamePackage.Entyties.Entity;
import GamePackage.Entyties.Creatures.Herbivore;
import GamePackage.Entyties.Creatures.Predator;
import GamePackage.Entyties.Grass;
import GamePackage.Simulation.Coordinates;
import GamePackage.Simulation.Simulation;

import java.util.ArrayList;
import java.util.List;

public class CreaturesMover extends Action {
    @Override
    public void perform() {

    }

    private void getCreatures() {
        List<Entity> herbivores = new ArrayList<>();
        List<Entity> predators = new ArrayList<>();
        List<Entity> grasses = new ArrayList<>();
        for (Coordinates key : Simulation.getMap().keySet()) {
            if (Simulation.getMap().get(key) instanceof Herbivore)
                herbivores.add(Simulation.getMap().get(key));
            if (Simulation.getMap().get(key) instanceof Predator)
                predators.add(Simulation.getMap().get(key));
            if (Simulation.getMap().get(key) instanceof Grass)
                grasses.add(Simulation.getMap().get(key));
        }
        for (Entity herbivore : herbivores
        ) {
            Entity nearestEntity = getNearestEntity(herbivore, grasses);
            if (nearestEntity != null) ((Herbivore) herbivore).eat(nearestEntity);
        }
        for (Entity predator : predators
        ) {
            Entity nearestEntity = getNearestEntity(predator, herbivores);
            if (nearestEntity != null) ((Predator) predator).eat(nearestEntity);
        }

    }

    private Entity getNearestEntity(Entity entity, List<Entity> list) {
        for (Entity entity1 : list
        ) {
            if (Math.abs(entity.getCoordinates().x() - entity1.getCoordinates().x()) <= 1 &&
                    Math.abs(entity.getCoordinates().y() - entity1.getCoordinates().y()) <= 1)
                return entity1;
        }
        return null;
    }
}
