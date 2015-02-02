package de.xQuixi.DesasterGames.Listener;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class InteractListener implements Listener {
	
	HashMap<String, Integer> hashmap = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(final PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			
			if(!Data.playersingame.contains(e.getPlayer())) {
				if(e.getPlayer().getItemInHand().getTypeId() == ConfigManager.cfg.getInt("inits.hubitem") && (ConfigManager.cfg.getBoolean("booleans.hubitemenable") == true)) {
					Data.connecttoServer(ConfigManager.cfg.getString("messages.fallbackserver"), e.getPlayer());
					
				}
			}
		}
	}

}
