package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.Player;
import project.planettrade.Cargo;
import project.planettrade.MyPlayer;
import project.planettrade.types.ICommodity;
import project.planettrade.types.IMarket;
import project.planettrade.types.ISpaceship;

import java.util.List;
import java.util.stream.Stream;

public class SellItem implements Action {
    Player player;
    ICommodity soldCommodity;
    double cost;
    double amount;
    public SellItem(Player player) {

        this.player = player;
        ISpaceship spaceship = ((MyPlayer) player).getSpaceship();
        List<Cargo> cargoList = spaceship.getCargoList();
        if (cargoList.size() <= 0) return;
        int index = (int) (Math.random() * cargoList.size());
        Cargo cargo = cargoList.get(index);
        this.soldCommodity = cargo.getCommodity();
        IMarket market = ((MyPlayer) player).getPlanet().getMarket();
        List<ICommodity> commodities = market.getCommodities();
        this.amount = cargo.getAmount();
        double price = soldCommodity.getPrice();
        this.cost = price * amount;
        ((MyPlayer) player).setCurrentGold(((MyPlayer) player).getCurrentGold() + cost);
        cargoList.remove(cargo);
        boolean found = false;
        for (ICommodity commodity:commodities) {
            if (commodity.equals(soldCommodity)) {
                commodity.setAmount(commodity.getAmount() + amount);
                found = true;
            }
        }
        if (!found) {
            soldCommodity.setAmount(amount);
            commodities.add(soldCommodity);
        }

    }

    @Override
    public String toString() {
        if (soldCommodity==null) return "Player: " + player.getName() + " sold nothing";
        return "Player: " + player.getName() + ", sold " + this.amount + "x " + soldCommodity + " for " + cost + " Gold";
    }
}
