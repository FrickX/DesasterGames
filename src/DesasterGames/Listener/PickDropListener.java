package de.xQuixi.DesasterGames.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class PickDropListener implements Listener {
	
	@EventHandler
	public void on(PlayerPickupItemEvent e) {
		if(Data.status == GameStatus.INGAME && (Data.players.contains(e.getPlayer().getName()))) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(PlayerDropItemEvent e) {
		if(Data.status == GameStatus.INGAME && (Data.players.contains(e.getPlayer().getName()))) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}


}
