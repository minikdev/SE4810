package project.planettrade;

import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.generators.SpaceshipGenerator;
import project.planettrade.types.IBlackhole;
import project.planettrade.types.IMarket;
import project.planettrade.types.IPlanet;
import project.planettrade.types.ISpaceship;

import java.util.List;
import java.util.stream.Collectors;

public class MyGameContext implements GameContext {
    private final List<ISpaceship> spaceships;
    private List<Player> players;
    private Galaxy galaxy;

    public MyGameContext(List<Player> players, IBlackhole blackhole, List<ISpaceship> spaceships) {
        this.spaceships = spaceships;
        this.players = players;
        this.galaxy = blackhole.explode();
    }

    public String toString() {
        String result = "Planet:";
        for (IPlanet planet : galaxy.getPlanets()) {
            result += planet + "\n";
            result += planet.getMarket() + "\n";
        }
        return result;
    }

    public List<ISpaceship> getSpaceships() {
        return this.spaceships;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }


    public void update() {
        List<IMarket> markets = galaxy.getPlanets().stream().map(IPlanet::getMarket).filter(m -> m != null).collect(Collectors.toList());
        // Lambda method reference used
        markets.forEach(IMarket::updatePrices);
    }
}
