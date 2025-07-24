package org.javierdz.survivalprueba.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage("SurvivalPlugin Help:");
        player.sendMessage("/help - Show this help message");
        player.sendMessage("/survival - Main command for SurvivalPlugin");
        player.sendMessage("/s <player> - Teleport player to you");
        return true;
    }
}
