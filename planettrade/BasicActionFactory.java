package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.Actions.BuyFuel;
import project.planettrade.Actions.BuyItem;
import project.planettrade.Actions.SellItem;
import project.planettrade.types.ActionAbstractFactory;

public class BasicActionFactory extends ActionAbstractFactory {
    @Override
    public Action createAction(Player player, GameContext context) {
        int random = (int) (Math.random() * 3) + 1;
        switch (random) {
            case 1:
                return new BuyItem(player, context);
            case 2:
                return new SellItem(player, context);
            case 3:
                return new BuyFuel(player, context);
            default:
                return null;
        }
        // TODO seçim yaptır
    }
}
