package de.philcode.lobbyplus;

import de.philcode.lobbyplus.command.Command_Build;
import de.philcode.lobbyplus.listener.Listener_Build;
import de.philcode.lobbyplus.listener.Listener_Join;
import de.philcode.lobbyplus.listener.Listener_Quit;
import de.philcode.lobbyplus.util.FileUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Lobby extends JavaPlugin {

    private static Lobby instance;

    public static Lobby getInstance() {
        return instance;
    }

    public List<Player> inBuild;

    public FileUtil fileUtil;

    public String prefix;
    public String noPerms;

    @Override
    public void onEnable() {
        instance = this;
        startUp();

        Bukkit.getConsoleSender().sendMessage("§7===========[§6Lobby+§7]==========");
        Bukkit.getConsoleSender().sendMessage("§aLobby+ enabled");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§cCoded by PhilCode");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§dVersion: §e" + this.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§7===========[§6Lobby+§7]==========");

    }

    @Override
    public void onDisable() {
        instance = null;

        Bukkit.getConsoleSender().sendMessage("§7===========[§6Lobby+§7]==========");
        Bukkit.getConsoleSender().sendMessage("§cLobby+ disabled");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§cCoded by PhilCode");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§dVersion: §e" + this.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§7===========[§6Lobby+§7]==========");

    }

    private void startUp() {

        inBuild = new ArrayList<>();
        fileUtil = new FileUtil();
        fileUtil.setUpFiles();
        prefix = fileUtil.messages.getString("messages.prefix").replace("&", "§")+ " ";
        noPerms = fileUtil.messages.getString("messages.noPerms").replace("&", "§");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Listener_Join(), this);
        pluginManager.registerEvents(new Listener_Quit(), this);
        pluginManager.registerEvents(new Listener_Build(), this);

        getCommand("build").setExecutor(new Command_Build());
    }
}
