package com.programgames.antiexitportal;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.PortalType;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {
  @Override
  public void onDisable() {
    super.onDisable();
  }

  @Override
  public void onEnable() {
    super.onEnable();
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Logger log = Bukkit.getLogger();
    log.info("Anti exit portal loaded");

  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void onEntityCreatePortal(EntityCreatePortalEvent event) {
    Logger log = Bukkit.getLogger();
    event.setCancelled(true);
    log.info("Dragon killed");
    event.getEntity().getLocation().getBlock().setType(Material.DRAGON_EGG);

  }
}

