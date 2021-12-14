package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.Game;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.generators.SpaceshipGenerator;
import project.planettrade.types.IBlackhole;
import project.planettrade.types.ISpaceship;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements Game {
    GameContext context;
    List<Player> players;
    private SpaceshipGenerator spaceshipGenerator;
    private int MAX_SPACESHIPS = 10;
    List<ISpaceship> spaceships;
    private IBlackhole blackhole;
    int maxTurnCount;
    int turn = 0;
    int turnForEachPlayer = 0;
    private boolean over = false;

    public MyGame(SpaceshipGenerator spaceshipGenerator, IBlackhole blackhole, int turnToPlay) {
        this.turnForEachPlayer = turnToPlay;
        this.blackhole = blackhole;
        this.spaceshipGenerator = spaceshipGenerator;
        this.spaceships = new ArrayList<>(MAX_SPACESHIPS);
        this.fillHangar();
    }

    @Override
    public boolean isOver() {
        return this.over;
    }

    @Override
    public void init(List<Player> players) {
        this.players = players;
        this.maxTurnCount = this.turnForEachPlayer * players.size();
        this.context = new MyGameContext(players,this.blackhole,this.spaceships);
        this.preparePlayers();
    }


    @Override
    public GameContext getContext() {
        return context;
    }

    @Override
    public void update(Action action) {
        turn++;
        if (turn >= maxTurnCount) {
            this.over = true;
        }
        // TODO: UPDATE MARKETS' PRICES

    }

    @Override
    public int minimumPlayerCount() {
        return 2;
    }

    @Override
    public int maximumPlayerCount() {
        return 4;
    }


    private void preparePlayers() {
        for (Player player : players) {
            player.prepareForGame(this.getContext());
        }
    }

    private void fillHangar() {
        for (int i = 0; i < MAX_SPACESHIPS; i++) {
            ISpaceship spaceship = this.spaceshipGenerator.generateSpaceship();
            this.spaceships.add(spaceship);
        }
    }

    @Override
    public String toString() {
        // TODO: Implement this method
        return "MyGame{" +
                "context=" + context +
                '}';
    }
}
