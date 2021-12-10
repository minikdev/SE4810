package project.planettrade;

import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.types.IBlackhole;

import java.util.List;

public class MyGameContext implements GameContext {
    private List<Player> players;
    private Galaxy galaxy;
    public MyGameContext(List<Player> players) {
        this.players = players;
        this.preparePlayers();
        IBlackhole blackhole = new Blackhole();
        this.galaxy = blackhole.explode();


    }
    private void preparePlayers(){
        for(Player player: players){
            player.prepareForGame(this);
        }
    }
}
