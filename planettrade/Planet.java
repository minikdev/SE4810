package project.planettrade;

import project.planettrade.generators.MarketGenerator;
import project.planettrade.types.IMarket;
import project.planettrade.types.IPlanet;

public class Planet implements IPlanet {

    private String name;
    IMarket market;
    private double fuelPrice;
    private double parkingPrice;
    private int x;
    private int y;

    public Planet(String name, double fuelPrice, double parkingPrice, MarketGenerator marketGenerator, int x, int y) {
        this.name = name;
        this.fuelPrice = fuelPrice;
        this.parkingPrice = parkingPrice;
        this.market = marketGenerator.generateMarket();
        this.x = x;
        this.y = y;
    }

    @Override
    public IMarket getMarket() {
        return this.market;
    }
    public double getDistanceTo(IPlanet planet) {
        return Math.sqrt(Math.pow(this.x - planet.getX(), 2) + Math.pow(this.y - planet.getY(), 2));
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
    public double getParkingPrice(){
        return this.parkingPrice;
    }
    public double getFuelPrice(){
        return this.fuelPrice;
    }

    @Override
    public String toString() {
        return this.name +" [" + this.getX() + "," + this.getY() + "]";
    }
}
