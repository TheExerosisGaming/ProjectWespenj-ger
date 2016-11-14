package me.exerosis.wespe.engine.components.spectate.event;

import org.bukkit.entity.Player;

public class PlayerEnterSpectateEvent extends SpectateEvent {
    public PlayerEnterSpectateEvent(Player player) {
        super(player);
    }
}
