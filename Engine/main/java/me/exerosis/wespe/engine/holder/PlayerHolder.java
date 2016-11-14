package me.exerosis.wespe.engine.holder;

import me.exerosis.wespe.core.Holder;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerHolder implements Holder<Player> {
    private final Collection<Player> players;

    public PlayerHolder() {
        this(new ArrayList<>());
    }

    public boolean add(Player player) {
        return players.add(player);
    }

    public boolean remove(Player player) {
        return players.remove(player);
    }

    public void clear() {
        players.clear();
    }

    public PlayerHolder(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public Collection<Player> getContents() {
        return players;
    }

    @Override
    public int size() {
        return players.size();
    }
}
