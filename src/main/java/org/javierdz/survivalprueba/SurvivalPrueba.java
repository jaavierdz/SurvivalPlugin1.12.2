package org.javierdz.survivalprueba;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.javierdz.survivalprueba.handlers.chatHandler;
import org.javierdz.survivalprueba.handlers.consoleHandler;

public final class SurvivalPrueba extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(("&aPlugin enabled!")));
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(("&bPlugin version: " + getDescription().getVersion())));
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor("&bPlugin author: &6" + getDescription().getAuthors()));
        registerCommands();

    }

    @Override
    public void onDisable() {
        consoleHandler.sendConsoleMessage("&cPlugin disabled!");
    }
    @Override
    public void onLoad() {
        consoleHandler.sendConsoleMessage("&ePlugin loaded!");
    }
    public void onReload() {
        consoleHandler.sendConsoleMessage("&dPlugin reloaded!");
    }
    public void registerCommands() {
        getCommand("help").setExecutor(new org.javierdz.survivalprueba.commands.help());
        getCommand("s").setExecutor(new org.javierdz.survivalprueba.commands.s());
        getCommand("events").setExecutor(new org.javierdz.survivalprueba.commands.events());
        getCommand("survival").setExecutor(new org.javierdz.survivalprueba.commands.survival());
    }
}
