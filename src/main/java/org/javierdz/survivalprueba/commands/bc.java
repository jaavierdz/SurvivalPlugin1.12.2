package org.javierdz.survivalprueba.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.javierdz.survivalprueba.handlers.chatHandler;

public class bc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player player = (Player) commandSender;
        if (Player.hasPermission("survival.bc){
            player.getServer().broadcastMessage(chatHandler.getColor("&a" + player.getName() + "'s coordinates are " + player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ()));
            return true;
        } else {
            commandSender.sendMessage("No tienes permiso para usar este comando");
            return false;
    }
}
