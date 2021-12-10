package project.planettrade;

import project.planettrade.generators.PlanetGenerator;
import project.planettrade.types.IPlanet;

import java.util.ArrayList;
import java.util.List;

public class MyPlanetGenerator implements PlanetGenerator {
    private String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter",
            "Saturn", "Uranus", "Neptune", "Pluto", "Mercury-2", "Venus-2", "Earth-2",
            "Mars-2", "Jupiter-2", "Saturn-2", "Uranus-2", "Neptune-2", "Pluto-2"};
    private final double MAX_FUEL_PRICE = 15;
    private final double MIN_FUEL_PRICE = 3;
    private final double MAX_PARKING_PRICE = 75;
    private final double MIN_PARKING_PRICE = 25;


    @Override
    public List<IPlanet> generatePlanets(int numPlanets, int maxXCoordinate, int maxYCoordinate) {
        List<IPlanet> planets = new ArrayList<>(numPlanets);
        for (int i = 0; i < numPlanets; i++) {
            double fuelPrice = (Math.random() * (MAX_FUEL_PRICE - MIN_FUEL_PRICE)) + MIN_FUEL_PRICE;
            double parkingPrice = (Math.random() * (MAX_PARKING_PRICE - MIN_PARKING_PRICE)) + MIN_PARKING_PRICE;
            String name = planetNames[(int) (Math.random() * planetNames.length)];
            int xCoordinate = (int) (Math.random() * (maxXCoordinate - (-maxXCoordinate)) + (-maxXCoordinate));
            int yCoordinate = (int) (Math.random() * (maxYCoordinate - (-maxYCoordinate))) + -maxYCoordinate;
            IPlanet newIPlanet = new Planet(name, fuelPrice, parkingPrice, new MyMarketGenerator(), xCoordinate, yCoordinate);
            planets.add(newIPlanet);
        }
        return planets;
    }


}
