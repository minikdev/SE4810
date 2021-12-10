package project.planettrade;

import project.planettrade.types.ICommodity;
import project.planettrade.types.ISpaceship;

import java.util.List;

public class SpaceShip implements ISpaceship {
    private String name;
    private double buyPrice;
    private List<ICommodity> inventory; // TODO: Change this to cargo
    private double capacity;
    private double speed;
    private double currentFuel;
    private double fuelCapacity;
    private double fuelConsumption;

}
