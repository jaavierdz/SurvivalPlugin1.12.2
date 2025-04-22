package org.javierdz.survivalprueba.handlers;

import org.bukkit.ChatColor;

public class chatHandler {
    public static String getColor(String Message){
        return ChatColor.translateAlternateColorCodes('&', Message);
    }
}
