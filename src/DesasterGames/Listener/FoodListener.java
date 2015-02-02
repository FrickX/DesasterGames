package de.xQuixi.DesasterGames.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class FoodListener implements Listener {
	
	@EventHandler
	public void on(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();
		if(Data.status == GameStatus.INGAME && (Data.playersingame.contains(p) && (Data.damage == true))) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}

}
