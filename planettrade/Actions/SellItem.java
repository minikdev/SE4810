package project.planettrade.Actions;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

public class SellItem implements Action {
    public SellItem(Player player, GameContext context) {
        System.out.println("sellitem yaptın hacı abiiiii");
    }

    @Override
    public String toString() {
        return "Selamın aleykke";
    }
}
