package project.planettrade.types;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

public abstract class ActionAbstractFactory {
    public abstract Action createAction(Player player, GameContext context);
}
