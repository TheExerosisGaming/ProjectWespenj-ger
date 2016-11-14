package me.exerosis.wespe.engine.components.spectate.event;

import org.bukkit.entity.Player;

public class PlayerExitSpectateEvent extends SpectateEvent {
    public PlayerExitSpectateEvent(Player player) {
        super(player);
    }
}
