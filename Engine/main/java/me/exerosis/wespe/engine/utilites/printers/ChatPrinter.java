package me.exerosis.wespe.engine.utilites.printers;

import me.exerosis.wespe.core.printer.DestinationPrinter;
import org.bukkit.Bukkit;

/**
 * Created by Exerosis.
 */
public class ChatPrinter extends DestinationPrinter {

    @Override
    protected void _print(Object message) {
        Bukkit.broadcastMessage(message.toString());
    }
}
