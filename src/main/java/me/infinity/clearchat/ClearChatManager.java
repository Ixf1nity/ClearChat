package me.infinity.clearchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ClearChatManager {

    private final ClearChatPlugin instance;

    public ClearChatManager(ClearChatPlugin instance) {
        this.instance = instance;
    }

    public void clearChat(Player player, boolean silent) {
        for (int i = 0; i < 40; i++) player.sendMessage("");
        if (!silent) player.sendMessage(color(instance.getMessages().getString("PLAYER_CHAT_CLEAR")));
    }

    public void clearGlobalChat() {
        Bukkit.getOnlinePlayers().forEach(online -> {
            for (int i = 0; i < 40; i++) online.sendMessage("");
            online.sendMessage(color(instance.getMessages().getString("GLOBAL_CHAT_CLEAR")));
        });
    }

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
