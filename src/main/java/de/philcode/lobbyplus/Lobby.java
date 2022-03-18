package de.philcode.lobbyplus;

import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    private static Lobby instance;

    public static Lobby getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        startUp();

    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void startUp() {

    }
}
