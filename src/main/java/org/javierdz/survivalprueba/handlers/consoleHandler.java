package org.javierdz.survivalprueba.handlers;

import org.bukkit.Bukkit;
// NOT USED
public class consoleHandler {
    public static String sendConsoleMessage(String Message){
        return Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(Message));
    }
}
