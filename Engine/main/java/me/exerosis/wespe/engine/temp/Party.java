package me.exerosis.wespe.engine.temp;

import me.exerosis.wespe.engine.PlayerHolder;

public class Party extends PlayerHolder {
    private final String name;
    private final String socketAddressMaybe;
    private final String etc;

    public Party(String name, String socketAddressMaybe, String etc) {
        this.name = name;
        this.socketAddressMaybe = socketAddressMaybe;
        this.etc = etc;
    }

    public String getSocketAddressMaybe() {
        return socketAddressMaybe;
    }

    public String getName() {
        return name;
    }

    public String getEtc() {
        return etc;
    }
}
