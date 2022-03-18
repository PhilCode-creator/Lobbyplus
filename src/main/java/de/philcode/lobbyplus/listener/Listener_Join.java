package de.philcode.lobbyplus.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listener_Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");
        //TODO Give Hotbar Items / teleport to Spawn if wanted
        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);

    }

}
