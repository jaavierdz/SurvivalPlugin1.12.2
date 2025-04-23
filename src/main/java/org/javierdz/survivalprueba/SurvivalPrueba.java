package org.javierdz.survivalprueba;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.javierdz.survivalprueba.handlers.chatHandler;


public final class SurvivalPrueba extends JavaPlugin {


    FileConfiguration config = this.getConfig();
    public String prefix = chatHandler.getColor(this.getConfig().getString("prefix"));
    @Override
    public void onEnable() {

        config.addDefault("prefix", "&6&l[&bSurvivalPlugin&6&l] &r");
        config.options().copyDefaults(true);
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(prefix + "&a Plugin enabled!"));
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(prefix + "&b Plugin version: " + getDescription().getVersion()));
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor(prefix + "&b Plugin author: &6" + getDescription().getAuthors()));
        registerCommands();
        registerEvents();


    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor("&cPlugin disabled!"));
    }
    @Override

    public void onLoad() {
        if(Bukkit.getOnlinePlayers().isEmpty()) {
            Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor("&ePlugin loaded!"));
        }else{
            onReload();
        }

    }
    public void onReload() {
        Bukkit.getServer().getConsoleSender().sendMessage(chatHandler.getColor("&dPlugin reloaded!"));
    }
    public void registerCommands() {
        getCommand("help").setExecutor(new org.javierdz.survivalprueba.commands.help());
        getCommand("s").setExecutor(new org.javierdz.survivalprueba.commands.s());
        getCommand("events").setExecutor(new org.javierdz.survivalprueba.commands.events());
        getCommand("survival").setExecutor(new org.javierdz.survivalprueba.commands.survival());
        getCommand("gms").setExecutor(new org.javierdz.survivalprueba.commands.gms());
        getCommand("gmc").setExecutor(new org.javierdz.survivalprueba.commands.gmc());
        getCommand("bc").setExecutor(new org.javierdz.survivalprueba.commands.bc());
    }
    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new org.javierdz.survivalprueba.events.deathListener(), this);
    }
}
