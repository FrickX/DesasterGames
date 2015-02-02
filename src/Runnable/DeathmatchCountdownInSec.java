package de.xQuixi.DesasterGames.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class DeathmatchCountdownInSec extends BukkitRunnable {

	@Override
	public void run() {
		
	
		if(Data.deathmatchcountdowninsekunden != 0) {
			Data.deathmatchcountdowninsekunden--;
		} else {
			int id = 1;
			for(Player all : Data.playersingame) {
				all.teleport(Data.getLocation("match."+id));
				all.playSound(all.getLocation(), Sound.LEVEL_UP, 3.0F, 3.0F);
				id++;
			}
			this.cancel();
		
	}
		
		if(Data.deathmatchcountdowninsekunden == 40 || (Data.deathmatchcountdowninsekunden == 20 || (Data.deathmatchcountdowninsekunden == 10 || (Data.deathmatchcountdowninsekunden == 5 || (Data.deathmatchcountdowninsekunden == 4 || (Data.deathmatchcountdowninsekunden == 3 || (Data.deathmatchcountdowninsekunden == 2 || (Data.deathmatchcountdowninsekunden == 1)))))))) {
			String message = ConfigManager.cfg.getString("messages.deathmatchcountdowninsekunden");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(countdown)", String.valueOf(Data.deathmatchcountdowninsekunden));
			Bukkit.broadcastMessage(message);
			
			for(Player all : Data.playersingame) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
		}
	}

}
