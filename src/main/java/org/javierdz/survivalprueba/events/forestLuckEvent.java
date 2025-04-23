package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class forestLuckEvent implements Listener {

    private JavaPlugin plugin;
    private Random random = new Random();

    public forestLuckEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean isBosque(Biome biome) {
        return biome == Biome.FOREST || biome == Biome.BIRCH_FOREST || biome == Biome.ROOFED_FOREST;
    }

    @org.bukkit.event.EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Biome biome = loc.getBlock().getBiome();

        if (isBosque(biome) && random.nextInt(500) == 0) { // 0.2% chance
            Skeleton spirit = (Skeleton) player.getWorld().spawnEntity(loc, EntityType.SKELETON);
            spirit.setCustomName("§5Spirit of the Forest");
            spirit.setCustomNameVisible(true);
            player.sendMessage("§5You feel a presence in the forest...");
        }
    }
}
