package me.exerosis.wespe.core;

public class Component implements Enableable {
    private boolean enabled;

    public void onEnable() {

    }

    public void onDisable() {

    }

    @Override
    public void enable() {
        if (!enabled)
            onEnable();
        enabled = true;
    }

    @Override
    public void disable() {
        if (enabled)
            onDisable();
        enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
