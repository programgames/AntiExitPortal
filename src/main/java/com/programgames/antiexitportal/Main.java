package com.programgames.antiexitportal;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

  private FileConfiguration config = getConfig();

  @Override
  public void onDisable() {
    super.onDisable();
  }

  @Override
  public void onEnable() {
    super.onEnable();
    saveDefaultConfig();

    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Logger log = Bukkit.getLogger();
    log.info("Anti exit portal loaded");

  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void onEntityCreatePortal(EntityCreatePortalEvent event) {

    boolean eggSpawned = false;
    double y = 0;
    if (event.getEntity() instanceof EnderDragon && event.getPortalType() == PortalType.ENDER) {
      if (config.getBoolean("DragonKilled")) {
        event.setCancelled(true);
        World world = event.getEntity().getWorld();
        Block above = world.getBlockAt(  (int) event.getEntity().getLocation().getX(),  (int) event.getEntity().getEyeHeight(), (int) event.getEntity().getLocation().getZ());
        while(!eggSpawned) {
          if (Material.AIR == above.getType()) {
            above.setType(Material.DRAGON_EGG);
            eggSpawned = true;
          }
          else {
            above = world.getBlockAt(  (int) event.getEntity().getLocation().getX(),  (int) (event.getEntity().getEyeHeight() + y), (int) event.getEntity().getLocation().getZ());
            y+=1;
          }
        }
      } else {
        this.getConfig().set("DragonKilled", true);
        this.saveConfig();
      }


    }
  }
}

