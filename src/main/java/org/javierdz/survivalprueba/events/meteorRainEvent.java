package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class meteorRainEvent implements Listener {

    private JavaPlugin plugin;
    private Random random = new Random();

    public meteorRainEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startMeteorRain();
    }

    private void startMeteorRain() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    if (random.nextInt(1000) < 10) { // Evento raro
                        for (Player player : world.getPlayers()) {
                            for (int i = 0; i < 3; i++) {
                                double offsetX = random.nextInt(20) - 10;
                                double offsetZ = random.nextInt(20) - 10;
                                Location spawnLoc = player.getLocation().clone().add(offsetX, 30, offsetZ);
                                FallingBlock meteor = world.spawnFallingBlock(spawnLoc, Material.NETHERRACK, (byte) 0);
                                meteor.setDropItem(true);
                            }
                            player.sendMessage("§4A meteor rain has started!");
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 600L);
    }
}
