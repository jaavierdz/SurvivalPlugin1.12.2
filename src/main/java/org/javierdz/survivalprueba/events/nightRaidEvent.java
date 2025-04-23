package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class nightRaidEvent implements Listener {

    private JavaPlugin plugin;

    public nightRaidEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startHordeTask();
    }

    private void startHordeTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    long time = world.getTime();
                    if (time > 13000 && time < 23000) {
                        for (Player player : world.getPlayers()) {
                            for (int i = 0; i < 5; i++) {
                                Zombie zombie = (Zombie) world.spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                                zombie.setCustomName("§cZombie Raider");
                                zombie.setCustomNameVisible(true);
                            }
                            player.sendMessage("§cNight Raid! Prepare to fight!");
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 1200L); // cada minuto durante la noche
    }
}
