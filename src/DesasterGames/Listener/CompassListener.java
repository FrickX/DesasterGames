package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class CompassListener implements Listener {
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if(p.getItemInHand().getType() == Material.COMPASS) {
				if(Data.players.contains(p.getName())) {
					getNearestPlayer(p);
				} else {
					Inventory i = Bukkit.createInventory(null, 27, "§eSpieler");
	                Integer slots = 0;
	                for (Player pw : Data.playersingame) {
	                    
	                        ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
	                        ItemMeta ism = is.getItemMeta();
	                        ism.setDisplayName(pw.getName());
	                        

	                        is.setItemMeta(ism);
	                        i.setItem(slots, is);
	                        slots++;
	                        
	                        p.openInventory(i);
	                }
				}
			}
		}
	}
	
	public static void getNearestPlayer(Player p) {
		double dist = 0.0D;
		Player target = null;
		for(Entity e : p.getNearbyEntities(ConfigManager.cfg.getDouble("inits.trackerradius"), ConfigManager.cfg.getDouble("inits.trackerradius"), ConfigManager.cfg.getDouble("inits.trackerradius"))) {
			if(e instanceof Player) {
				if(Data.playersingame.contains(((Player)e))) {
				target = (Player)e;
				dist = p.getLocation().distance(target.getLocation());
			 
					
				}
			}
		}
		if(target == null) {
			String message = ConfigManager.cfg.getString("messages.notsee");
			message = ChatColor.translateAlternateColorCodes('&', message);
			p.sendMessage(message);
			
		} else {
			
			String message = ConfigManager.cfg.getString("messages.track");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(name)", target.getName());
			message = message.replace("(weite)", String.valueOf((int)dist));
			
			p.sendMessage(message);
			p.setCompassTarget(target.getLocation());
		}
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("§eSpieler")){
			if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                String name;
                name = e.getCurrentItem().getItemMeta().getDisplayName();
                if (Bukkit.getPlayerExact(name) != null) {
                    Player clicked = Bukkit.getPlayerExact(name);
                    p.teleport(clicked.getLocation());
                    
        			String message = ConfigManager.cfg.getString("messages.teleportplayer");
        			message = ChatColor.translateAlternateColorCodes('&', message);
        			message = message.replace("(name)", clicked.getName());
                    
                    p.sendMessage(message);
                    p.closeInventory();

                }else{
        			String message = ConfigManager.cfg.getString("messages.notonline");
        			message = ChatColor.translateAlternateColorCodes('&', message);
                    p.sendMessage(message);
                    p.closeInventory();
                }
            }
		
        }
		}

}
