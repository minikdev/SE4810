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
}
