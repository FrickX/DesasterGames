package de.xQuixi.DesasterGames.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Data.MapCreater;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class LobbyCountdown extends BukkitRunnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		if(Data.countdown != 0) {
			Data.countdown--;
		} else {
			if(Bukkit.getOnlinePlayers().length > ConfigManager.cfg.getInt("inits.mindplayer") || (Bukkit.getOnlinePlayers().length == ConfigManager.cfg.getInt("inits.mindplayer"))) {
				Data.status = GameStatus.INGAME;
				for(Player all : Bukkit.getOnlinePlayers()) {
					Data.players.add(all.getName());
					all.getInventory().clear();
					all.getInventory().setArmorContents(null);
					Data.playersingame.add(all);
					if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
					Main.plugin.getSqlUtils().addSpiel(all.getUniqueId(), 1);
					}
					}
				
			    MapCreater.createMap();
				Data.move = false;
				new MoveCountdown().runTaskTimer(Main.plugin, 0L, 20L);
				this.cancel();
			} else {
				String message = ConfigManager.cfg.getString("messages.noplayers");
				message = ChatColor.translateAlternateColorCodes('&', message);
				Bukkit.broadcastMessage(message);
				Data.countdown = 120;
			}
		}
		
		float f = (float) ((double) Data.countdown / (double) 120);
		
        for(Player all : Bukkit.getOnlinePlayers()) {	
			all.setExp(f);
			all.setLevel(Data.countdown);
        }
		
		if(Data.countdown == 60 || (Data.countdown == 40 || (Data.countdown == 20 || (Data.countdown == 10 || (Data.countdown == 5 || (Data.countdown == 4 || (Data.countdown == 3 || (Data.countdown == 2 || (Data.countdown == 1))))))))) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
			String countdown = ConfigManager.cfg.getString("messages.lobbycountdown");
			countdown = ChatColor.translateAlternateColorCodes('&', countdown);
			countdown = countdown.replace("(countdown)", String.valueOf(Data.countdown));
			Bukkit.broadcastMessage(countdown);
		}
	
		
		
	
	}

}
