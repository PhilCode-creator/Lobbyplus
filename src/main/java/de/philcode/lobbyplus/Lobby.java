package de.philcode.lobbyplus;

import de.philcode.lobbyplus.listener.Listener_Join;
import de.philcode.lobbyplus.listener.Listener_Quit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
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

        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");

    }

    @Override
    public void onDisable() {
        instance = null;

        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");

    }

    private void startUp() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Listener_Join(), this);
        pluginManager.registerEvents(new Listener_Quit(), this);

    }
}
