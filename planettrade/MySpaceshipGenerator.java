package project.planettrade;

import project.planettrade.generators.SpaceshipGenerator;
import project.planettrade.types.ICommodity;
import project.planettrade.types.ISpaceship;

public class MySpaceshipGenerator implements SpaceshipGenerator {
    @Override
    public ISpaceship generateSpaceship() {
        ISpaceship spaceShip = SpaceShip.values()[(int) (Math.random() * SpaceShip.values().length)];
        return spaceShip;
    }
}
