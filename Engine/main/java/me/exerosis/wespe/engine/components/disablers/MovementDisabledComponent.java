package me.exerosis.wespe.engine.components.disablers;

import me.exerosis.wespe.core.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

public class MovementDisabledComponent extends Component {
    private final Predicate<Player> players;
    private final Predicate<Location> locations;

    public MovementDisabledComponent(Predicate<Player> players) {
        this(players, location -> true);
    }

    public MovementDisabledComponent(Predicate<Player> players, Predicate<Location> locations) {
        this.players = players;
        this.locations = locations;
    }
}