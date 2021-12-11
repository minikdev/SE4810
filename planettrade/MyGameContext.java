package project.planettrade;

import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.planettrade.generators.SpaceshipGenerator;
import project.planettrade.types.IBlackhole;
import project.planettrade.types.ISpaceship;

import java.util.List;

public class MyGameContext implements GameContext {
    private final List<ISpaceship> spaceships;
    private List<Player> players;
    private Galaxy galaxy;

    public MyGameContext(List<Player> players, IBlackhole blackhole, List<ISpaceship> spaceships) {
        this.spaceships = spaceships;
        this.players = players;
        this.galaxy = blackhole.explode();
    }

    public String ToString() {
        return "MyGameContextsssss";
    }

    public int getTest() {
        return 5;
    }


}
