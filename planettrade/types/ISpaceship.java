package project.planettrade.types;

import project.planettrade.Cargo;

import java.util.List;

public interface ISpaceship {
    double getPrice();
    double getCapacity();

    void addCargo(ICommodity commodity, double amount);

    List<Cargo> getCargoList();

    double getCurrentFuel();

    double getFuelConsumption();
    double getFuelCapacity();

    void setCurrentFuel(double v);
}
