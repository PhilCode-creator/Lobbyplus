package de.philcode.lobbyplus.command;

import de.philcode.lobbyplus.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Lobby.getInstance().prefix + "§cOnly players can use this");
            return false;
        }

        Player player = ((Player) sender).getPlayer();
        if(!player.hasPermission("lobby.build")) {
            player.sendMessage(Lobby.getInstance().noPerms);
            return false;
        }

        if(Lobby.getInstance().inBuild.contains(player)) {
            Lobby.getInstance().inBuild.remove(player);
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            //TODO give Items
            player.playSound(player, Sound.ENTITY_CHICKEN_EGG, 50, 50);
            player.sendMessage(Lobby.getInstance().prefix + "§cYou left the Buildmode");
            return true;
        } else {
            Lobby.getInstance().inBuild.add(player);
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();
            player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 50, 50);
            player.sendMessage(Lobby.getInstance().prefix + "§aYou entered the Buildmode");
            return true;
        }
    }
}
