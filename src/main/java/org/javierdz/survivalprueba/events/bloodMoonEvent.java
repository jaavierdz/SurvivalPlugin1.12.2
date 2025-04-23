package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class bloodMoonEvent implements Listener {

    private JavaPlugin plugin;
    private boolean lunaActiva = false;

    public bloodMoonEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startLunaCheck();
    }

    private void startLunaCheck() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    long time = world.getFullTime() % 24000;
                    long day = (world.getFullTime() / 24000) % 8;

                    if (time > 13000 && day == 0) { // Luna llena cada 8 días
                        if (!lunaActiva) {
                            lunaActiva = true;
                            for (Player player : world.getPlayers()) {
                                player.sendMessage("§4¡Luna Sangrienta! Los mobs no se quemarán y el PvP está activado.");
                            }
                        }
                    } else {
                        lunaActiva = false;
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 200L);
    }

    @org.bukkit.event.EventHandler
    public void onCombust(EntityCombustEvent event) {
        if (lunaActiva) {
            event.setCancelled(true);
        }
    }

    @org.bukkit.event.EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (lunaActiva) {
            event.getPlayer().sendMessage("§4¡Luna Sangrienta activa!");
        }
    }
}
