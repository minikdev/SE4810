package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.Actions.BuyItem;

public class MyPlayer implements Player {
    private String name;
    private double currentGold;
    private SpaceShip spaceShip;
    private Planet currentPlanet;
    public MyPlayer(String name) {
        this.name = name;

    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Action play(GameContext context) {
        System.out.println("Player " + name + " is playing");
        System.out.println("Choose your action:");
        System.out.println("1. Buy item");
        System.out.println("2. Sell item");
        System.out.println("3. Trade item");
        System.out.println("4. End turn");
        // TODO seçim yaptır

        Action myAction = new BuyItem();
        return myAction;
    }

    @Override
    public void prepareForGame(GameContext context) {
        this.currentGold = 250 ;
    }
}
