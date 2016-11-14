package me.exerosis.wespe.core.printer.printers;

import me.exerosis.wespe.core.printer.DestinationPrinter;

/**
 * Created by Exerosis.
 */
public class ConsolePrinter extends DestinationPrinter {

    @Override
    protected void _print(Object message) {
        System.out.println(message);
    }
}
