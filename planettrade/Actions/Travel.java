package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.MyGameContext;
import project.planettrade.MyPlayer;
import project.planettrade.types.IPlanet;
import project.planettrade.types.ISpaceship;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Travel implements Action{
    private final Player player;
    private final IPlanet planet;
    private IPlanet traveledPlanet;

    public Travel(Player player, GameContext context){
        this.player = player;
        this.planet = ((MyPlayer) player).getPlanet();
        ISpaceship spaceship = ((MyPlayer) player).getSpaceship();
        double currentFuel = spaceship.getCurrentFuel();
        double fuelConsumption= spaceship.getFuelConsumption();
        double maxDistance = currentFuel / fuelConsumption;
        List<IPlanet> planetList = ((MyGameContext)context).getGalaxy().getPlanets();
        List<IPlanet>planetsCanBeTraveledTo = planetList.stream().filter(p -> p.getDistanceTo(planet) <= maxDistance).collect(Collectors.toList());
        if (planetsCanBeTraveledTo.size() <= 0){
            ((MyPlayer)player).setCurrentGold(((MyPlayer)player).getCurrentGold()- planet.getParkingPrice() );
            return;
        }
        int randomIndex = (int) (Math.random() * planetsCanBeTraveledTo.size());
        IPlanet randomPlanet = planetsCanBeTraveledTo.get(randomIndex);
        traveledPlanet = randomPlanet;
        ((MyPlayer) player).setPlanet(randomPlanet);

    }

    @Override
    public String toString() {
        if (traveledPlanet == null) return "Player: " + player.getName() + " tried to travel but failed and paid the parking fee: " + planet.getParkingPrice();
        return "Player: " + player.getName() + " traveled to planet: " + traveledPlanet;
    }
}
