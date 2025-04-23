package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class earthquakeEvent implements Listener {

    private JavaPlugin plugin;
    private Random random = new Random();

    public earthquakeEvent(JavaPlugin plugin) {
        this.plugin = plugin;
        startTerremotoTask();
    }

    private void startTerremotoTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (random.nextInt(1000) < 5) { // 0.5% probabilidad
                        World world = player.getWorld();
                        Block block = world.getHighestBlockAt(player.getLocation());
                        if (block.getType() != Material.AIR && block.getType().isSolid()) {
                            Material material = block.getType();
                            FallingBlock falling = world.spawnFallingBlock(block.getLocation().add(0, 1, 0), material, block.getData());
                            falling.setDropItem(false);
                            block.setType(Material.AIR);
                        }
                        player.sendMessage("§6Shall Earth move down your feet");
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 100L); // cada 5 segundos
    }
}
