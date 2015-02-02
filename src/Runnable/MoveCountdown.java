package de.xQuixi.DesasterGames.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Data.Kit;

public class MoveCountdown extends BukkitRunnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		if(Data.movecountdown == 30 || (Data.movecountdown == 20 || (Data.movecountdown == 20 || (Data.movecountdown == 10 || (Data.movecountdown == 5 || (Data.movecountdown == 4 || (Data.movecountdown == 3 || (Data.movecountdown == 2 || (Data.movecountdown == 1))))))))) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
			
			String countdown = ConfigManager.cfg.getString("messages.movecountdown");
			countdown = ChatColor.translateAlternateColorCodes('&', countdown);
			countdown = countdown.replace("(countdown)", String.valueOf(Data.movecountdown));
			Bukkit.broadcastMessage(countdown);
		}
		
		
		if(Data.movecountdown != 0) {
			Data.movecountdown--;
		} else {
			
			String countdown = ConfigManager.cfg.getString("messages.startgame");
			countdown = ChatColor.translateAlternateColorCodes('&', countdown);
			
			Bukkit.broadcastMessage(countdown);
			for(Player all : Data.playersingame) {
				all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				ItemStack item = new ItemStack(Material.COMPASS);
				ItemMeta im = item.getItemMeta();
				im.setDisplayName("§6Tracker");
				item.setItemMeta(im);
				all.getInventory().setItem(8, item);
				all.updateInventory();
				all.setLevel(0);
				all.setExp(0);
			      if (Data.kit.containsKey(all.getName())) {
			          Kit kit = (Kit)Data.kit.get(all.getName());
			          kit.giveItems(all);
			        }
			        all.updateInventory();
			}
			Data.move = true;
			new DamageCountdown().runTaskTimer(Main.plugin, 0L, 20L);
			this.cancel();
			
			
		}
		
	}

}
