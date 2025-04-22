package org.javierdz.survivalprueba.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.javierdz.survivalprueba.handlers.chatHandler;

public class survival implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }
        if (commandSender.hasPermission("survivalprueba.survivalOP")) {
            Player player = (Player) commandSender;
            player.sendMessage(chatHandler.getColor("&6&lSurvivalPlugin Administration:&r"));
            player.sendMessage(chatHandler.getColor("&4/setsurvival <player> - Set the player to survival mode"));
            player.sendMessage(chatHandler.getColor("&4/setcreative <player> - Set the player to creative mode"));
            player.sendMessage(chatHandler.getColor("&a/s <player> - Teleport player to you"));
            player.sendMessage(chatHandler.getColor("&a/events - Show all events"));
            return true;
        } else {
            commandSender.sendMessage("You do not have permission to use this command.");
        }
        return false;
    }
}
