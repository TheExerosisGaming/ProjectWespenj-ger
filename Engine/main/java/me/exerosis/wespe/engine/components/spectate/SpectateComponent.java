package me.exerosis.wespe.engine.components.spectate;

import me.exerosis.wespe.engine.components.EventComponent;
import me.exerosis.wespe.engine.components.spectate.event.PlayerEnterSpectateEvent;
import me.exerosis.wespe.engine.holder.PlayerHolder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import java.util.function.Predicate;

//TODO make this all better
public class SpectateComponent extends EventComponent implements Predicate<Player> {
    private final Predicate<Player> players;
    private final PlayerHolder spectators = new PlayerHolder();

    public SpectateComponent(Predicate<Player> players) {
        this.players = players;
    }

    public void enterSpectating(Player player) {
        if (!isEnabled() || !test(player))
            return;

        callEvent(new PlayerEnterSpectateEvent(player), event -> {
            if (event.isCancelled())
                return;
            if (!spectators.add(player))
                return;
            player.setGameMode(GameMode.ADVENTURE);
            player.setVelocity(new Vector());
            player.setFlying(true);
            player.teleport(player.getWorld().getSpawnLocation());
        });
    }

    public void exitSpectating(Player player) {
        spectators.remove(player);
    }

    public void removeAll() {
        spectators.clear();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        exitSpectating(event.getPlayer());
    }

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event) {
        if (test(event.getPlayer()))
            event.getPlayer().setFlying(true);
    }

    @EventHandler
    public void onScroll(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (!test(player) || !player.isSprinting())
            return;
        event.setCancelled(true);

        player.setFlySpeed(event.getNewSlot() * 0.1F);
//        player.setFlySpeed(NumberUtilities.bound(player.getFlySpeed() + (event.getNewSlot() > event.getPreviousSlot() ? 0.05F : -0.05F)));
    }

    @Override
    public boolean test(Player player) {
        return players.test(player);
    }

    @Override
    public void onDisable() {
        removeAll();
    }

    public int getNumberOfSpectators() {
        return spectators.size();
    }
}