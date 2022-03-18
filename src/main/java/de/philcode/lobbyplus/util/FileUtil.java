package de.philcode.lobbyplus.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    private File folder = new File("plugins/lobby+/");
    private File messageFile = new File("plugins/lobby+/messages.yml");
    private File configFile = new File("plugins/lobby+/config.yml");

    public YamlConfiguration messages = YamlConfiguration.loadConfiguration(messageFile);
    public YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

    public void setUpFiles() {
        try {
            if (!folder.exists()) {
                folder.mkdir();
            }

            if(!messageFile.exists()) {
                messageFile.createNewFile();
            }

            if(!configFile.exists()) {
                configFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        messages.addDefault("messages.prefix", "&6Lobby+");
        messages.addDefault("messages.noPerms", "&cI'm sorry, but you do not have permission to perform this command. &cPlease contact the server administrators if you believe that this is in error");
        messages.options().copyDefaults(true);
        save();
    }

    public void save() {
        try {
            messages.save(messageFile);
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
