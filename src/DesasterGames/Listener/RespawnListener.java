package de.xQuixi.DesasterGames.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class RespawnListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerRespawnEvent e) {
		e.setRespawnLocation(Data.getLocation("spec"));
		Player p = e.getPlayer();
		p.setMaxHealth(20.0);
		p.setHealth(20.0);
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§eTeleporter");
        item.setItemMeta(im);
        p.getInventory().addItem(item);
        p.updateInventory();
        p.setAllowFlight(true);
        p.setFlying(true);
        
		if(ConfigManager.cfg.getBoolean("booleans.hubitemenable") == true) {
			
			ItemStack hub = new ItemStack(ConfigManager.cfg.getInt("inits.hubitem"));
			ItemMeta hm = hub.getItemMeta();
			hm.setDisplayName(ChatColor.translateAlternateColorCodes('&', ConfigManager.cfg.getString("messages.hubitemmeta")));
			hub.setItemMeta(hm);
			
			p.getInventory().setItem(8, hub);
		}
	}
 
}
