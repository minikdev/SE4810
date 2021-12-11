package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.Actions.BuyItem;
import project.planettrade.types.ActionAbstractFactory;
import project.planettrade.types.IPlanet;

public class MyPlayer implements Player {
    private final ActionAbstractFactory actionFactory;
    private String name;
    private double currentGold;
    private SpaceShip spaceShip;
    private IPlanet currentPlanet;
    public MyPlayer(String name, ActionAbstractFactory actionAbstractFactory) {
        this.name = name;
        this.actionFactory = actionAbstractFactory;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Action play(GameContext context) {
        Action action =this.actionFactory.createAction(this,context);

        return action;
    }

    @Override
    public void prepareForGame(GameContext context) {
        // TODO: Select starting ship
        this.currentGold = 250 ;
    }
}
