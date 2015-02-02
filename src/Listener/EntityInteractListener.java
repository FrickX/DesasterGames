package de.xQuixi.DesasterGames.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import de.xQuixi.DesasterGames.Data.Data;

public class EntityInteractListener implements Listener {
	
	@EventHandler
	public void on(PlayerInteractEntityEvent e) {
		if(Data.spec.contains(e.getPlayer())) {
			if(e.getRightClicked() instanceof Player) {
				Player clicked = (Player) e.getRightClicked();
				if(Data.playersingame.contains(clicked)) {
				if(e.getRightClicked().getPassenger().getType() != EntityType.PLAYER) {
					e.getRightClicked().setPassenger(e.getPlayer());
				}
			}
		}
	}

	}
}
