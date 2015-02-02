package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
import de.xQuixi.DesasterGames.Data.Kit;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class KitListener implements Listener {
	
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().getType() == Material.CHEST && (Data.status == GameStatus.LOBBY)) {
				
		
				int size = Data.allKits.size() % 18 + 1;
			    if (Data.allKits.size() < 18) {
			      size = 1;
			    }

			    Inventory inv = Bukkit.createInventory(null, size * 18, "§6Kits");
			    ItemStack[] icons = new ItemStack[Data.allKits.size()];

			    for (int i = 0; i < Data.allKits.size(); i++) {
			      icons[i] = ((Kit)Data.allKits.get(i)).getIcon();
			    }

			    for (int i = 0; i < icons.length; i++) {
			      ItemMeta im = icons[i].getItemMeta();
			      String sub = im.getDisplayName().substring(0, 1);
			      sub = sub.toUpperCase();
			      im.setDisplayName(sub + im.getDisplayName().substring(1));
			      icons[i].setItemMeta(im);
			      inv.setItem(i, icons[i]);
			    }

			    e.getPlayer().openInventory(inv);

				
			}
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		
		
		if(e.getInventory().getName().equals("§6Kits")) {
			    Player p = (Player)e.getWhoClicked();
			    	e.setCancelled(true);
			    	
			      String kitname = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName().toLowerCase());
			      if ((p.hasPermission("desastergames.kit." + kitname)))
			      {
			        for (int i = 0; i < Data.allKits.size(); i++) {
			          Kit k = (Kit)Data.allKits.get(i);
			          if (k.getName().equalsIgnoreCase(kitname)) {
			           Data.kit.put(p.getName(), k);
			            break;
			          }
			        }

			        e.setCancelled(true);
			        
			        String setKit = ConfigManager.cfg.getString("messages.selectkit");
			        setKit = ChatColor.translateAlternateColorCodes('&', setKit);
			        setKit = setKit.replace("(kit)", kitname);
			        
			        p.sendMessage(setKit);
			        p.closeInventory();
			      }
			      else {
			        p.sendMessage(ConfigManager.cfg.getString("messages.hasnotkit"));
			        p.closeInventory();
			      }
			    
		}
	  }
	  

}