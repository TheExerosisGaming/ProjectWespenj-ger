package me.exerosis.wespe.engine.game;

import me.exerosis.wespe.core.Game;
import me.exerosis.wespe.engine.holder.PlayerHolder;

public abstract class GameImplementation implements Game {
    private final PlayerHolder players = new PlayerHolder();

    public GameImplementation() {

    }

    public PlayerHolder getPlayers() {
        return players;
    }
}
