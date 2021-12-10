package project.planettrade;

import project.planettrade.types.IBlackhole;

public class Blackhole implements IBlackhole {
    public Galaxy explode() {
        return new Galaxy(new MyPlanetGenerator());
    }
}
