package me.infinity.clearchat.listener;

import lombok.RequiredArgsConstructor;
import me.infinity.clearchat.ClearChatPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final ClearChatPlugin instance;

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        if (instance.getSettings().getBoolean("CLEAR_CHAT_ON_JOIN")) instance.getManager().clearChat(event.getPlayer(), true);
    }

}
