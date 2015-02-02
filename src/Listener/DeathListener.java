package de.xQuixi.DesasterGames.Listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Runnable.DeathmatchCountdown;

public class DeathListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();	
		Data.playersingame.remove(p);
		Data.spec.add(p);
		Data.players.remove(p.getName());
		
		
		if(Data.kit.containsKey(p.getName())) {
			Data.kit.remove(p.getName());
		}
		
		Random r = new Random();
		int i = r.nextInt(2);
		
		if(i == 1) {
		new BukkitRunnable() {
			
			
			@Override
			public void run() {
				
				Data.arena.setStorm(true);
				Data.arena.setThundering(true);
				
				String message = ConfigManager.cfg.getString("messages.regen");
				message = ChatColor.translateAlternateColorCodes('&', message);
				Bukkit.broadcastMessage(message);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						
						String message = ConfigManager.cfg.getString("messages.regenoff");
						message = ChatColor.translateAlternateColorCodes('&', message);
						Bukkit.broadcastMessage(message);
						
						Data.arena.setThundering(false);
						Data.arena.setStorm(false);
						
					}
				}.runTaskLater(Main.plugin, 600L);
				
			}
		}.runTaskLater(Main.plugin, 600L);
		} 
		if(i == 2) {
			new BukkitRunnable() {
				
				
				@Override
				public void run() {
					
				      Data.arena.setTime(14000);
					
					String message = ConfigManager.cfg.getString("messages.eiszeit");
					message = ChatColor.translateAlternateColorCodes('&', message);
					Bukkit.broadcastMessage(message);
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							
							String message = ConfigManager.cfg.getString("messages.eiszeitoff");
							message = ChatColor.translateAlternateColorCodes('&', message);
							Bukkit.broadcastMessage(message);
							
							Data.arena.setTime(1500);
							
						}
					}.runTaskLater(Main.plugin, 600L);
					
				}
			}.runTaskLater(Main.plugin, 600L);
		}
		
		e.setDeathMessage(null);
		if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
			Main.plugin.getSqlUtils().addTod(p.getUniqueId(), 1);
		}
		
		if(Data.kit.containsKey(p.getName())) {
			Data.kit.remove(p.getName());
		}
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.hidePlayer(p);
			all.playSound(all.getLocation(), Sound.WITHER_SPAWN, 3.0F, 3);
		}

		if(e.getEntity().getKiller() != null) {
			
			String message = ConfigManager.cfg.getString("messages.deathfromplayer");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(killer)", k.getName());
			message = message.replace("(opfer)", p.getName());
			
			Bukkit.broadcastMessage(message);
			if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
				Main.plugin.getSqlUtils().addKill(k.getUniqueId(), 1);
			}
			
		} else {
			
			String message = ConfigManager.cfg.getString("messages.deathnatural");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(opfer)", p.getName());
			
			Bukkit.broadcastMessage(message);
		}
		
	    if(Data.playersingame.size() == ConfigManager.cfg.getInt("inits.mindplayerfordeathmatch")) {
	    	new DeathmatchCountdown().runTaskTimer(Main.plugin, 0L, 1200L);
	    }
		
		if(Data.playersingame.size() == 1) {
			Data.damage = false;
			for(Player pw : Data.playersingame) {
				if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
					Main.plugin.getSqlUtils().addWin(pw.getUniqueId(), 1);
				}
				
				String name = pw.getDisplayName();
				String message = ConfigManager.cfg.getString("winplayer");
				message = ChatColor.translateAlternateColorCodes('&', message);
				message = message.replace("(name)", name);
			Bukkit.broadcastMessage(message);
			
			}
			Data.kit.clear();
			new BukkitRunnable() {
				
				@Override
				public void run() {
					for(Player all : Bukkit.getOnlinePlayers()) {
					Data.connecttoServer(ConfigManager.cfg.getString("messages.fallbackserver"), all);
					}
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							
							Bukkit.shutdown();
							
						}
					}.runTaskLater(Main.plugin, 60L);
					
				}
			}.runTaskLater(Main.plugin, 200L);
		}
	}

}
