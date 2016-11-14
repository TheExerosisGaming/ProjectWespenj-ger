package me.exerosis.wespe.engine.components.death;

import me.exerosis.wespe.engine.components.ListenerComponent;
import me.exerosis.wespe.engine.components.death.event.PlayerDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DeathComponent extends ListenerComponent {
    private Predicate<Player> players;

    public DeathComponent() {
        this(player -> true);
    }

    public DeathComponent(Predicate<Player> players) {
        this.players = players;
    }

    public void killPlayer(Player player) {
        killPlayer(player, player.getTotalExperience());
    }

    public void killPlayer(Player player, int exp) {
        killPlayer(player, exp, Arrays.asList(player.getInventory().getContents()));
    }

    public void killPlayer(Player player, ItemStack... drops) {
        killPlayer(player, Arrays.asList(drops));
    }

    public void killPlayer(Player player, List<ItemStack> drops) {
        killPlayer(player, player.getTotalExperience(), drops);
    }

    public void killPlayer(Player player, int exp, ItemStack... drops) {
        killPlayer(player, exp, Arrays.asList(drops));
    }

    public void killPlayer(Player player, int exp, List<ItemStack> drops) {
        EntityDeathEvent deathEvent = new EntityDeathEvent(player, Arrays.asList(player.getInventory().getContents()), player.getTotalExperience());
        Bukkit.getPluginManager().callEvent(new PlayerDeathEvent(deathEvent));
    }

    @EventHandler
    public void fakeDeath(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof Player))
            return;
        Player player = (Player) event.getEntity();
        if (!players.test(player))
            return;

        player.resetMaxHealth();
        player.setHealth(20);
        Bukkit.getPluginManager().callEvent(new PlayerDeathEvent(event));
    }
}
