package de.xQuixi.DesasterGames.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;

public class CraftItemListener implements Listener {

    @SuppressWarnings("deprecation")
	@EventHandler
    public void on(CraftItemEvent e) {
    	if(e.getCurrentItem().getTypeId() == ConfigManager.cfg.getInt("inits.chestid")) {
    	e.getWhoClicked().closeInventory();
    }
    }
}
