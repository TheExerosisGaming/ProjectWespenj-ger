package me.exerosis.wespe.engine.components.disablers;

import me.exerosis.wespe.core.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

public class PvEDisabledComponent extends Component {
    private final Predicate<Player> players;
    private final Predicate<EntityDamageEvent> events;

    public PvEDisabledComponent(Predicate<Player> players) {
        this(players, event -> true);
    }

    public PvEDisabledComponent(Predicate<Player> players, Predicate<EntityDamageEvent> events) {
        this.players = players;
        this.events = events;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && players.test((Player) event.getEntity()) && events.test(event));
    }
}
