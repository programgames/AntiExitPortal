package com.programgames.antiexitportal;

import org.bukkit.Bukkit;
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

    Bukkit.broadcastMessage("HELLO");
    Logger log = Bukkit.getLogger();
    log.info("hi");

  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onEvent(EntityCreatePortalEvent e) {
    Bukkit.broadcastMessage("HELLO2");
    getServer( ).broadcastMessage( "Message" );
    Logger log = Bukkit.getLogger();
    log.info("hiportal");

    e.setCancelled(true);//On annule cet évènement
  }
}
