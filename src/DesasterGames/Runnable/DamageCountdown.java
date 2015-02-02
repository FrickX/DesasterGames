package de.xQuixi.DesasterGames.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Lib.Tornado;
import de.xQuixi.DesasterGames.Listener.Bacterium;
import de.xQuixi.DesasterGames.Listener.MeteorListener;

public class DamageCountdown extends BukkitRunnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		if(Data.damagecountdown == 60 || (Data.damagecountdown == 40 || (Data.damagecountdown == 20 || (Data.damagecountdown == 10 || (Data.damagecountdown == 5 || (Data.damagecountdown == 4 || (Data.damagecountdown == 3 || (Data.damagecountdown == 2 || (Data.damagecountdown == 1))))))))) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(all.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
			}
			
			String countdown = ConfigManager.cfg.getString("messages.gracetime");
			countdown = ChatColor.translateAlternateColorCodes('&', countdown);
			countdown = countdown.replace("(countdown)", String.valueOf(Data.damagecountdown));
			Bukkit.broadcastMessage(countdown);
		}
		
		if(Data.damagecountdown != 0) {
			Data.damagecountdown--;
		} else {
			String countdown = ConfigManager.cfg.getString("messages.endgracetime");
			countdown = ChatColor.translateAlternateColorCodes('&', countdown);
			Bukkit.broadcastMessage(countdown);
			Data.damage = true;
			
			
		     World w = Bukkit.getWorld("arena");
		     int x30 = Data.arena.getSpawnLocation().getBlockX();
		     int z30 = Data.arena.getSpawnLocation().getBlockZ() - 2;
		     int y2 = Data.arena.getSpawnLocation().getBlockY() + 51;
		     Location loc = new Location(w, x30, y2 - 1, z30);
		     Data.arena.createExplosion(loc, 15);
			
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
			}
			
			new SwitchCountdown().runTaskTimer(Main.plugin, ConfigManager.cfg.getInt("inits.switchtimeinseconds")*20L, ConfigManager.cfg.getInt("inits.switchtimeinseconds")*20L);
			
			Tornado.spawnTornado(Main.plugin, Data.arena.getSpawnLocation(), Material.WEB, (byte) 0, new Vector(2, 0, 2), 0.1, 100, (long) 30*20, true);

			Data.vulkan();
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Tornado.spawnTornado(Main.plugin, Data.getRandomLocation(Data.arena), Material.WEB, (byte) 0, new Vector(2, 0, 2), 0.1, 100, (long) 30*20, true);
					
		            /*for(Player all : Bukkit.getOnlinePlayers()) {
		            	Data.playSound("dg5", all);
		            }*/
					
					String tornado = ConfigManager.cfg.getString("messages.tornadospawn");
					tornado = ChatColor.translateAlternateColorCodes('&', tornado);
					Bukkit.broadcastMessage(tornado);

					
				}
			}.runTaskTimer(Main.plugin, 0L, 3600);
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					MeteorListener.spawnMeteor();
					
				}
			}.runTaskTimer(Main.plugin, 0L, ConfigManager.cfg.getInt("inits.spawnmeteortime")*20);
			
			new Bacterium(Data.arena.getSpawnLocation(), Material.LAVA, 75);
			
			this.cancel();
			
			
		
		
	}
	}

}
