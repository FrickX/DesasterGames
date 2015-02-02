package de.xQuixi.DesasterGames.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class ChatListener implements Listener {
	
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		if(Data.spec.contains(e.getPlayer())) {
			for(Player spec : Data.spec) {
			
				String chat = ConfigManager.cfg.getString("messages.deathchat");
				chat = ChatColor.translateAlternateColorCodes('&', chat);
				chat = chat.replace("(name)", e.getPlayer().getName());
				chat = chat.replace("(message)", e.getMessage());
				spec.sendMessage(chat);
				
			}
			e.setCancelled(true);
			
		}
	}

}
