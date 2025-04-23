package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class denseFogEvent implements Listener {

    private JavaPlugin plugin;
    private Random random = new Random();

    public denseFogEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startFogTask();
    }

    private void startFogTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (random.nextInt(1000) < 15) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 10, 1));
                        player.sendMessage("§7A dense fog has appeared!");
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 200L); // cada 10 segundos
    }
}
