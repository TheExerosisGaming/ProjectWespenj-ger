package me.exerosis.wespe.engine.components.disablers;

import me.exerosis.wespe.core.Component;
import me.exerosis.wespe.engine.utilites.BlockUtilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class BlockPlaceDisabledComponent extends Component {
    private final Predicate<Player> players;
    private final Predicate<ItemStack> items;

    public BlockPlaceDisabledComponent(Predicate<Player> players) {
        this(players, item -> true);
    }

    public BlockPlaceDisabledComponent(Predicate<Player> players, Predicate<ItemStack> items) {
        this.players = players;
        this.items = items;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.setCancelled(players.test(event.getPlayer()) && items.test(BlockUtilities.toItemStack(event.getBlock())));
    }
}