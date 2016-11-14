package me.exerosis.wespe.engine.components.disablers;

import me.exerosis.wespe.core.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.function.Predicate;

public class HungerDisabledComponent extends Component {
    private final Predicate<Player> players;
    private final Predicate<FoodLevelChangeEvent> events;

    public HungerDisabledComponent(Predicate<Player> players) {
        this(players, event -> true);
    }

    public HungerDisabledComponent(Predicate<Player> players, Predicate<FoodLevelChangeEvent> events) {
        this.players = players;
        this.events = events;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && players.test((Player) event.getEntity()) && events.test(event));
    }
}
