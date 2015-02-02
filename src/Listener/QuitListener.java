package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class QuitListener implements Listener {
	
	@EventHandler
	public void on(PlayerQuitEvent e) {
		

		Data.players.remove(e.getPlayer().getName());
		Data.playersingame.remove(e.getPlayer());
		if(Data.status == GameStatus.LOBBY) {
			
			String message = ConfigManager.cfg.getString("messages.leftplayer");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(name)", e.getPlayer().getName());
			
			e.setQuitMessage(message);
		} else {
			if(Data.playersingame.size() == 1) {
				Data.damage = false;
				for(Player pw : Data.playersingame) {
					String name = pw.getDisplayName();
					String message = ConfigManager.cfg.getString("messages.winplayer");
					message = ChatColor.translateAlternateColorCodes('&', message);
					message = message.replace("(name)", name);
					if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
						Main.plugin.getSqlUtils().addWin(pw.getUniqueId(), 1);
					}
				Bukkit.broadcastMessage(message);
				
				}
				Data.kit.clear();
				new BukkitRunnable() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						for(Player all : Bukkit.getOnlinePlayers()) {
						Data.connecttoServer(ConfigManager.cfg.getString("messages.fallbackserver"), all);
						}
						Bukkit.shutdown();
						
					}
				}.runTaskLater(Main.plugin, 200L);
			}
			
			if(Data.playersingame.size() == 0) {
				Bukkit.shutdown();
			}
			
			e.setQuitMessage(null);
		}
		
		
	}

}
