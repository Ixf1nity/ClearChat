package me.infinity.clearchat;

import lombok.Getter;
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
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}
