package de.philcode.lobbyplus.listener;

import de.philcode.lobbyplus.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Listener_Build implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(Lobby.getInstance().inBuild.contains(player)) {
            event.setCancelled(false);
            return;
        }
        event.setCancelled(true);
    }



    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(Lobby.getInstance().inBuild.contains(player)) {
            event.setCancelled(false);
            return;
        }
        event.setCancelled(true);
    }

}
