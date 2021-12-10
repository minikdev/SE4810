package project.planettrade;

import project.planettrade.generators.PlanetGenerator;
import project.planettrade.types.IPlanet;

import java.util.List;


public class Galaxy {
    private List<IPlanet>planets;
    PlanetGenerator generator;
    private int MAX_PLANET_NUMBER = 12;
    private int MIN_PLANET_NUMBER = 8;

    private int MAX_X_COORDINATE = 100;
    private int MAX_Y_COORDINATE = 100;
    public Galaxy(PlanetGenerator generator) {
        this.generator = generator;
        int numPlanets = new java.util.Random().nextInt(MAX_PLANET_NUMBER - MAX_PLANET_NUMBER) + MIN_PLANET_NUMBER;
        this.planets = this.generator.generatePlanets(numPlanets, MAX_X_COORDINATE, MAX_Y_COORDINATE);
    }

    public List<IPlanet> getPlanets() {
        return planets;
    }
}