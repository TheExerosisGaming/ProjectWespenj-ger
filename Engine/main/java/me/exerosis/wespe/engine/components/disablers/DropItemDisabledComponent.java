package me.exerosis.wespe.engine.components.disablers;

import me.exerosis.wespe.core.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DropItemDisabledComponent extends Component {
    private final Predicate<Player> players;
    private final Predicate<ItemStack> items;

    public DropItemDisabledComponent(Predicate<Player> players) {
        this(players, item -> true);
    }

    public DropItemDisabledComponent(Predicate<Player> players, Predicate<ItemStack> items) {
        this.players = players;
        this.items = items;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(players.test(event.getPlayer()) && items.test(event.getItemDrop().getItemStack()));
    }
}