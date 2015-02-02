package de.xQuixi.DesasterGames.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class PingListener implements Listener {
	
	@EventHandler
	public void on(ServerListPingEvent e) {
		e.setMaxPlayers(12);
		
		if(Data.status == GameStatus.LOBBY) {
			String motd = ConfigManager.cfg.getString("messages.lobbymotd");
			motd = ChatColor.translateAlternateColorCodes('&', motd);
			e.setMotd(motd);
		} else {
			String motd = ConfigManager.cfg.getString("messages.ingamemotd");
			motd = ChatColor.translateAlternateColorCodes('&', motd);
			e.setMotd(motd);
		}
	}

}
