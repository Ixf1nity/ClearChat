package me.infinity.clearchat;

import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import me.infinity.clearchat.command.ClearChatCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ClearChatPlugin extends JavaPlugin {

    private ConfigurationSection settings, messages;
    private ClearChatManager manager;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.settings = this.getConfig().getConfigurationSection("SETTINGS");
        this.messages = this.getConfig().getConfigurationSection("MESSAGES");
        this.manager = new ClearChatManager(this);

        BukkitCommandManager commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new ClearChatCommand(this));

    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}
