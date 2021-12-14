package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.MyPlayer;
import project.planettrade.types.ICommodity;
import project.planettrade.types.IMarket;
import project.planettrade.types.ISpaceship;

import java.util.List;

public class BuyItem implements Action {
    Player player;
    double amount;
    ICommodity boughtCommodity;
    double cost;
    public BuyItem(Player player) {
        this.player = player;
        ISpaceship spaceship =((MyPlayer) player).getSpaceship();

        IMarket market = ((MyPlayer) player).getPlanet().getMarket();
        List<ICommodity> commodities = market.getCommodities();
         this.boughtCommodity = commodities.get((int) (Math.random() * commodities.size()));
        double capacity = spaceship.getCapacity();
        double price = boughtCommodity.getPrice();
        this.amount = calculateAmount(capacity,boughtCommodity.getVolume());
        this.cost = price * amount;
        ((MyPlayer)player).setCurrentGold(((MyPlayer)player).getCurrentGold() - cost);
        boughtCommodity.setAmount(boughtCommodity.getAmount() - amount);
        spaceship.addCargo(boughtCommodity,amount);
    }

    @Override
    public String toString() {

        return "Player: "+player.getName()+", bought "+ this.amount+"x " +boughtCommodity +" for "+ cost +" Gold";
    }

    private double calculateAmount(double capacity, double volume){
        return capacity / volume;
    }
}
