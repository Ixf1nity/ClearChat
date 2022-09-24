package me.infinity.clearchat.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import lombok.RequiredArgsConstructor;
import me.infinity.clearchat.ClearChatPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("clearchat|cc")
@CommandPermission("clearchat.use")
@RequiredArgsConstructor
public class ClearChatCommand extends BaseCommand {

    private final ClearChatPlugin instance;

    @Default
    @CommandCompletion("@players")
    public void clearChat(CommandSender player, @Optional OnlinePlayer target) {
        if (!(player instanceof Player)) return;
        if (target == null ) {
            instance.getManager().clearChat(((Player) player).getPlayer(), false);
        } else {
            instance.getManager().clearChat(target.player, false);
        }
    }

    @Subcommand("global")
    public void clearGlobalChat(CommandSender sender) {
        instance.getManager().clearGlobalChat();
    }
}
