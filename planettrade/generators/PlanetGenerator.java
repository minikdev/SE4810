package project.planettrade.generators;

import project.planettrade.types.IPlanet;

import java.util.List;

public interface PlanetGenerator {
    public List<IPlanet> generatePlanets(int numPlanets, int maxXCoordinate, int maxYCoordinate);
}
