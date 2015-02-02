package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Commands.Command_Stats;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Lib.Hologram;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class JoinListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(final PlayerJoinEvent e) {
		
		final Player p = e.getPlayer();
		
		
		/*new BukkitRunnable() {
			
			@Override
			public void run() {
				
				p.setResourcePack("http://devcoding.eu/RP/Pack.zip");
				
			}
		}.runTaskLater(Main.plugin, 20L);*/
		
		if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {
		if(Main.plugin.getSqlUtils().getKills(e.getPlayer().getUniqueId()) == null) {
			Main.plugin.getSqlUtils().addKill(e.getPlayer().getUniqueId(), 0);
		}
		
		if(Main.plugin.getSqlUtils().getTode(e.getPlayer().getUniqueId()) == null) {
			Main.plugin.getSqlUtils().addTod(e.getPlayer().getUniqueId(), 0);
		}
		
		if(Main.plugin.getSqlUtils().getSpiele(e.getPlayer().getUniqueId()) == null) {
			Main.plugin.getSqlUtils().addSpiel(e.getPlayer().getUniqueId(), 0);
		}
		
		if(Main.plugin.getSqlUtils().getWins(e.getPlayer().getUniqueId()) == null) {
			Main.plugin.getSqlUtils().addWin(e.getPlayer().getUniqueId(), 0);
		}
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				
		    	 String name = ConfigManager.cfg.getString("messages.statsheader");
		    	 name = ChatColor.translateAlternateColorCodes('&', name);
		    	 name = name.replace("(name)", p.getName());
		    	
		    	String kills = ConfigManager.cfg.getString("messages.statskills");
		    	kills = ChatColor.translateAlternateColorCodes('&', kills);
		    	kills = kills.replace("(kills)", String.valueOf(Main.plugin.getSqlUtils().getPKills(p.getUniqueId())));
		    	
		    	String tode = ConfigManager.cfg.getString("messages.statstode");
		    	tode = ChatColor.translateAlternateColorCodes('&', tode);
		    	tode = tode.replace("(tode)", String.valueOf(Main.plugin.getSqlUtils().getPTode(p.getUniqueId())));
		    	
		    	String gspiele = ConfigManager.cfg.getString("messages.statsgespielt");
		    	gspiele = ChatColor.translateAlternateColorCodes('&', gspiele);
		    	gspiele = gspiele.replace("(spiele)", String.valueOf(Main.plugin.getSqlUtils().getPSpiele(p.getUniqueId())));
		    	
		    	String wins = ConfigManager.cfg.getString("messages.statswins");
		    	wins = ChatColor.translateAlternateColorCodes('&', wins);
		    	wins = wins.replace("(wins)", String.valueOf(Main.plugin.getSqlUtils().getPWins(p.getUniqueId())));
		    	
		    	String quote = ConfigManager.cfg.getString("messages.statsquote");
		    	quote = ChatColor.translateAlternateColorCodes('&', quote);
		    	quote = quote.replace("(quote)", String.valueOf(Command_Stats.getWinQuote(p.getUniqueId())));
				
		    	Hologram hologram = new Hologram(name,
		    			kills,
		    			tode,
		    			gspiele,
		    			wins,
		    			quote);
		    	hologram.show(e.getPlayer(), Data.getLocation("hologram"));
				
			}
		}.runTaskLater(Main.plugin, 40L);
        
		}
		
		if(Data.status == GameStatus.LOBBY) {
			
			String message = ConfigManager.cfg.getString("messages.joinplayer");
			message = ChatColor.translateAlternateColorCodes('&', message);
			message = message.replace("(name)", e.getPlayer().getName());
			
				e.setJoinMessage(message);
			
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("§eKits");
		item.setItemMeta(im);
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().setAllowFlight(false);
		e.getPlayer().setFlying(false);
		e.getPlayer().setMaxHealth(20.0);
		e.getPlayer().setHealth(20.0);
		e.getPlayer().setFoodLevel(20);
		e.getPlayer().getInventory().addItem(item);
		try {
		e.getPlayer().teleport(Data.getLocation("lobby"));
		} catch (NullPointerException ee) {
			e.getPlayer().sendMessage("Die Location 'lobby' existiert nicht!");
		}
		e.getPlayer().setGameMode(GameMode.SURVIVAL);
		
		e.getPlayer().updateInventory();
		
		
		} else {
			e.setJoinMessage(null);
			ItemStack teleport = new ItemStack(Material.COMPASS);
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
			e.getPlayer().setAllowFlight(true);
			e.getPlayer().setFlying(true);
			ItemMeta im = teleport.getItemMeta();
			im.setDisplayName("§eTeleporter");
			teleport.setItemMeta(im);
			e.getPlayer().getInventory().clear();
			e.getPlayer().getInventory().setArmorContents(null);
			Data.spec.add(e.getPlayer());
			e.getPlayer().setMaxHealth(20.0);
			e.getPlayer().setHealth(20.0);
			e.getPlayer().setFoodLevel(20);
			e.getPlayer().getInventory().addItem(teleport);
			e.getPlayer().updateInventory();
			try {
				e.getPlayer().teleport(Data.getLocation("spec"));
				} catch (NullPointerException ee) {
					e.getPlayer().sendMessage("Die Location 'spec' existiert nicht!");
				}
			e.getPlayer().setExp(0);
			e.getPlayer().setLevel(0);
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.hidePlayer(e.getPlayer());
			}
			
		}
		
		if(ConfigManager.cfg.getBoolean("booleans.hubitemenable") == true) {
			
			ItemStack hub = new ItemStack(ConfigManager.cfg.getInt("inits.hubitem"));
			ItemMeta hm = hub.getItemMeta();
			hm.setDisplayName(ChatColor.translateAlternateColorCodes('&', ConfigManager.cfg.getString("messages.hubitemmeta")));
			hub.setItemMeta(hm);
			
			p.getInventory().setItem(8, hub);
		}
	}

}
