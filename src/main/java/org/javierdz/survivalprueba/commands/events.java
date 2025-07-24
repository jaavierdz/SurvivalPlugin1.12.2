package org.javierdz.survivalprueba.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.javierdz.survivalprueba.handlers.chatHandler;

public class events implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }
        if (commandSender.hasPermission("survivalplugin.events.command")){
            commandSender.sendMessage(chatHandler.getColor("&6&lCurrent (Registered) Events:&r"));
            commandSender.sendMessage(chatHandler.getColor("&cNone."));
        } else {
            commandSender.sendMessage(chatHandler.getColor("&cYou do not have permission to use this command."));
        }
        return true;
    }
}
