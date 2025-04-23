package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class nightInvasionEvent implements Listener {

    private JavaPlugin plugin;
    private Random random = new Random();

    public nightInvasionEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startNightCheck();
    }

    private void startNightCheck() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    long time = world.getTime();
                    if (time >= 13000 && time <= 23000) {
                        for (Player player : world.getPlayers()) {
                            if (random.nextInt(100) < 10) { // 10% chance por tick
                                for (int i = 0; i < 3; i++) {
                                    Zombie zombie = (Zombie) world.spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 20, 1));
                                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 20, 0));
                                }
                                player.sendMessage("§cNight Invasion! Protect yourself!");
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 200L); // cada 10 segundos
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // only start if a player joins
    }
}
