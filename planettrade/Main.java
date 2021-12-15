package project.planettrade;

import project.gameengine.BasicConsolRenderer;
import project.gameengine.TurnBasedGameEngine;
import project.gameengine.base.Game;
import project.gameengine.base.GameEngine;
import project.gameengine.base.GameRenderer;
import project.gameengine.base.Player;

public class Main {
    public static void main(String[] args) {
        Game myGame = new MyGame(new MySpaceshipGenerator(),new Blackhole(),10) ;
        GameRenderer renderer = new BasicConsolRenderer();
        GameEngine myEngine = new TurnBasedGameEngine(myGame,renderer);
        Player myPlayer = new MyPlayer("Minik",new BasicActionFactory());
        Player myPlayer2 = new MyPlayer("Begüş",new BasicActionFactory());
        Player myPlayer3 = new MyPlayer("Eylülov",new BasicActionFactory());
        myEngine.addPlayer(myPlayer);
        myEngine.addPlayer(myPlayer2);
        myEngine.addPlayer(myPlayer3);

        myEngine.playARound();
    }
}
