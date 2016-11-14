package me.exerosis.wespe.engine;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerHolder implements Holder<Player> {
    private Collection<Player> players;

    public PlayerHolder() {
        this(new ArrayList<>());
    }

    public PlayerHolder(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public Collection<Player> getContents() {
        return players;
    }
}
