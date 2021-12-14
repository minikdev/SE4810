package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.Player;
import project.planettrade.MyPlayer;
import project.planettrade.types.IPlanet;
import project.planettrade.types.ISpaceship;

public class BuyFuel implements Action {
    private final Player player;
    private final IPlanet planet;
    private double boughtFuel;
    private double fuelPrice;
    public BuyFuel(Player player) {
        this.player = player;
        this.planet = ((MyPlayer) player).getPlanet();
        ISpaceship spaceship = ((MyPlayer) player).getSpaceship();
        if (spaceship.getFuelCapacity() == spaceship.getCurrentFuel())return;
        double buyableFuel = spaceship.getFuelCapacity() - spaceship.getCurrentFuel();
        this.fuelPrice = planet.getFuelPrice();
        double fuelCost = buyableFuel * fuelPrice;
        ((MyPlayer) player).setCurrentGold(((MyPlayer) player).getCurrentGold() - fuelCost);
        this.boughtFuel = spaceship.getCurrentFuel() + buyableFuel;
        spaceship.setCurrentFuel(this.boughtFuel);
    }

    @Override
    public String toString() {
        if (boughtFuel == 0)return "Player: " + player.getName() + " tried buy fuel but failed";
        return "Player: " + player.getName() + " bought " + boughtFuel + " fuel for "+ fuelPrice + " Gold";
    }
}
