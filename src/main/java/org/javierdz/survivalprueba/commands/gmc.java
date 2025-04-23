package org.javierdz.survivalprueba.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.javierdz.survivalprueba.handlers.chatHandler;

public class gmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }
        if (commandSender.hasPermission("survivalprueba.gamemode") || commandSender.isOp()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode creative " + strings[0]);
            commandSender.sendMessage(chatHandler.getColor("&aYou have set the player " + strings[0] + " to creative mode."));
            return true;
        } else {
            commandSender.sendMessage(chatHandler.getColor("&cYou do not have permission to use this command."));
        }
        return false;
    }
}
