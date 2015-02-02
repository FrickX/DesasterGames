package de.xQuixi.DesasterGames.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class DeathmatchCountdown extends BukkitRunnable {

	@Override
	public void run() {
		
		if(Data.deathmatchcountdowninminuten != 0) {
			Data.deathmatchcountdowninminuten--;
		} else {
			this.cancel();
			new DeathmatchCountdownInSec().runTaskTimer(Main.plugin, 0L, 20L);
		}
		
		if(Data.deathmatchcountdowninminuten == 5 || (Data.deathmatchcountdowninminuten == 4 || (Data.deathmatchcountdowninminuten == 3 || (Data.deathmatchcountdowninminuten == 2)))) {
			String message = ConfigManager.cfg.getString("messages.deathmatchcountdowninminuten");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(countdown)", String.valueOf(Data.deathmatchcountdowninminuten));
			Bukkit.broadcastMessage(message);
			
			for(Player all : Data.playersingame) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
		}
		
		if(Data.deathmatchcountdowninminuten == 1) {
			String message = ConfigManager.cfg.getString("messages.deathmatchcountdowninminuten");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(countdown)", String.valueOf(Data.deathmatchcountdowninminuten));
			Bukkit.broadcastMessage(message);
			Data.deathmatchcountdowninminuten = 0;
			
			for(Player all : Data.playersingame) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
		}
		
	}

}
