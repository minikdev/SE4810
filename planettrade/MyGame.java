package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.Game;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

import java.util.List;

public class MyGame implements Game {
    MyGameContext context;
    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public void init(List<Player> players) {
        context = new MyGameContext(players);
    }

    @Override
    public GameContext getContext() {
        return context;
    }

    @Override
    public void update(Action action) {
        // TODO Always check isOver or not before update
    }

    @Override
    public int minimumPlayerCount() {
        return 2;
    }

    @Override
    public int maximumPlayerCount() {
        return 4;
    }
}
