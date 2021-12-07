package project.planettrade;

import project.gameengine.TurnBasedGameEngine;
import project.gameengine.base.Game;
import project.gameengine.base.GameEngine;
import project.gameengine.base.GameRenderer;
import project.gameengine.base.Player;

public class Main {
    public static void main(String[] args) {
        Game myGame = new MyGame() ;
        GameRenderer myRenderer = new MyGameRenderer();
        GameEngine myEngine = new TurnBasedGameEngine(myGame,myRenderer);
        Player myPlayer = new MyPlayer("Minik");
        Player myPlayer2 = new MyPlayer("Begüş");
        Player myPlayer3 = new MyPlayer("Eylülov");
        myEngine.addPlayer(myPlayer);
        myEngine.addPlayer(myPlayer2);
        myEngine.addPlayer(myPlayer3);

        myEngine.playARound();
    }
}
