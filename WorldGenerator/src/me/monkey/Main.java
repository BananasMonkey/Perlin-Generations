package me.monkey;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
    @Override
    public void onEnable() {

    	Bukkit.broadcastMessage("Plugin on");
    	Bukkit.getPluginManager().registerEvents(this,this);
    } 
    @Override
    public void onDisable() {
    	
    }
    @EventHandler
    public static void playerMove(PlayerMoveEvent event) {
    	Structure.noise.generateSpruceChunk(event.getPlayer().getLocation());
    }
    @EventHandler
    public static void waterFlow(BlockFromToEvent event) {
    	if (event.getBlock().isLiquid()) {
    		event.setCancelled(true);
    	}
    }
}   		 
    
