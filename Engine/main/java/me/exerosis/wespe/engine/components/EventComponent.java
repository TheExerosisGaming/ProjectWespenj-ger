package me.exerosis.wespe.engine.components;

import me.exerosis.wespe.core.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import java.util.function.Consumer;

public class EventComponent extends Component {
    public <T extends Event> void callEvent(T event, Consumer<T> callback) {
        callEvent(event);
        callback.accept(event);
    }

    public void callEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }
}
