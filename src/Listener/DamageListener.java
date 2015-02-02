package de.xQuixi.DesasterGames.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class DamageListener implements Listener {
	
	@EventHandler
	public void on(EntityDamageEvent e) {
		
		if(e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
			return;
		}
		
		if(e.getEntity().getType() == EntityType.PLAYER) {			
			Player p = (Player) e.getEntity();
			
			if(Data.status == GameStatus.LOBBY) {
				e.setCancelled(true);
				return;
			}
			
			if(Data.spec.contains(p)) {
				e.setCancelled(true);
				return;
			}
			
		}
	
		
	}
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		
		if(Data.status == GameStatus.LOBBY) {
			e.setCancelled(true);
			return;
		}
		
		if(e.getDamager().getType() == EntityType.PLAYER) {
			Player dmger = (Player) e.getDamager();
			
			if(Data.spec.contains(dmger)) {
				e.setCancelled(true);
				return;
			}
			
			if(Data.damage == true && (Data.playersingame.contains(dmger) && (Data.status == GameStatus.INGAME))) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		}
	}
	
}


