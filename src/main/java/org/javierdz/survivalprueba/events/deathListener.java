package org.javierdz.survivalprueba.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class deathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        //When the player dies
        org.bukkit.entity.Player player = event.getEntity();
        //Strike a lightning effect at the player's location
        player.getLocation().getWorld().strikeLightningEffect(player.getLocation());
        //For every online player, send a title message
        Bukkit.getOnlinePlayers().forEach(p -> player.sendTitle("§c" + player.getName() + " §7has died", "§7" + player.getName() + " has died", 10, 70, 20));
        player.sendMessage("§cYou have died!");
        World world = player.getWorld();
        //Set the weather to thundering uuu tormenta
        world.setThundering(true);

    }
}
