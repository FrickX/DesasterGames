package de.xQuixi.DesasterGames.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MeteorSpawnEvent extends Event {
	
	private HandlerList handlerlist = new HandlerList();
	
	private Player p;
	
	public MeteorSpawnEvent(Player p) {
		p = this.p;
	}

	@Override
	public HandlerList getHandlers() {
		return handlerlist;
	}
	
	public Player getPlayer() {
		return p;
	}

}
