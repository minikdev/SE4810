package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

public class BuyItem implements Action {
    public BuyItem(Player player, GameContext context) {
        System.out.println("buyitem yaptın hacı abiiiii");
    }

    @Override
    public String toString() {
        return "Selamın aleykke";
    }
}
