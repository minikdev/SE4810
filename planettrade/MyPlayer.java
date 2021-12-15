package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.types.ActionAbstractFactory;
import project.planettrade.types.ICommodity;
import project.planettrade.types.IPlanet;
import project.planettrade.types.ISpaceship;

import java.util.List;
import java.util.stream.Collectors;

public class MyPlayer implements Player {
    private final ActionAbstractFactory actionFactory;
    private String name;
    private double currentGold;
    private ISpaceship spaceShip;
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
        List<Cargo> cargoList = this.spaceShip.getCargoList();
        List<ICommodity> allCommodities= cargoList.stream().map(Cargo::getCommodity).collect(Collectors.toList());
        allCommodities.forEach(commodity -> commodity.decay());

        return action;
    }

    @Override
    public void prepareForGame(GameContext context) {
        this.currentGold = 250 ;
       selectSpaceship(context);
       setPlanet(context);
    }

    private void selectSpaceship(GameContext context){
        List<ISpaceship> spaceships =((MyGameContext)context).getSpaceships();
        int index = (int)(Math.random()*spaceships.size());
        this.spaceShip = spaceships.get(index);
        this.currentGold -= this.spaceShip.getPrice();
    }
    private void setPlanet(GameContext context){
        List<IPlanet> planets = ((MyGameContext)context).getGalaxy().getPlanets();
        int index = (int)(Math.random()*planets.size());
        this.currentPlanet = planets.get(index);
    }

    public ISpaceship getSpaceship() {
        return this.spaceShip;
    }


    public IPlanet getPlanet() {
        return this.currentPlanet;
    }
    public void setPlanet(IPlanet planet){
        this.currentPlanet = planet;
    }

    public double getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(double currentGold) {
        this.currentGold = currentGold;
    }
    public String toString(){
        return "Player: " +this.name+ " Gold: " +this.currentGold + " Spaceship: " +this.spaceShip + " Planet: " +this.currentPlanet;
    }
}
