package project.planettrade;

import project.planettrade.types.ICommodity;
import project.planettrade.types.ISpaceship;

import java.util.ArrayList;
import java.util.List;

public enum SpaceShip implements ISpaceship {
    TOROS(400), ANADOL(300), DEVRIM(500),
    MURAT124(124), OYAK(100), KARSAN(350),ANADOLSTC(100),
    MURAT131(131), ZAFER(120), CELİK(250), OTOKAR(600), ASKAM(385),
    ETOX(200);
    private String name;
    private double buyPrice;
    private List<Cargo> cargoList;
    private double capacity;
    private double speed;
    private double currentFuel;
    private double fuelCapacity;
    private double fuelConsumption;

    public double getPrice(){
        return buyPrice;
    }
    public double getCapacity(){
        return capacity;
    }

    SpaceShip(double capacity) {
        this.capacity = capacity;
        this.cargoList = new ArrayList<>();
    }

    @Override
    public void addCargo(ICommodity commodity, double amount) {
        this.cargoList.add(new Cargo(commodity, amount));
    }

    @Override
    public List<Cargo> getCargoList() {
        return this.cargoList;
    }
    public double getCurrentFuel(){
        return this.currentFuel;
    }
    public double getFuelCapacity(){
        return this.fuelCapacity;
    }

    @Override
    public void setCurrentFuel(double v) {
        this.currentFuel = v;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

}
