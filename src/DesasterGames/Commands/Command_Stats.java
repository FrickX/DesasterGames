package de.xQuixi.DesasterGames.Commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Lib.UUIDFetcher;

public class Command_Stats implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		
		            Player p = (Player) arg0;
		            
		            if(ConfigManager.cfg.getBoolean("booleans.mysql") == true) {

		                        if(arg3.length == 0) {
		                        	
		                        	
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
		                        	quote = quote.replace("(quote)", String.valueOf(getWinQuote(p.getUniqueId())));
		                        	
		                        	
		                        p.sendMessage(name);
		                        p.sendMessage(kills);
								p.sendMessage(tode);
								p.sendMessage(gspiele);
								p.sendMessage(wins);
								p.sendMessage(quote);
		                        }
		                        
		                        Bukkit.getPlayer(p.getUniqueId()).getName();
		                        
		                        if(arg3.length == 1) {
		                        	Player p2 = Bukkit.getPlayer(arg3[0]);
		                        	
		                        	if(p2 != null) {
			                        	String name = ConfigManager.cfg.getString("messages.statsheader");
			                        	name = ChatColor.translateAlternateColorCodes('&', name);
			                        	name = name.replace("(name)", p2.getName());
			                        	
			                        	String kills = ConfigManager.cfg.getString("messages.statskills");
			                        	kills = ChatColor.translateAlternateColorCodes('&', kills);
			                        	kills = kills.replace("(kills)", String.valueOf(Main.plugin.getSqlUtils().getPKills(p2.getUniqueId())));
			                        	
			                        	String tode = ConfigManager.cfg.getString("messages.statstode");
			                        	tode = ChatColor.translateAlternateColorCodes('&', tode);
			                        	tode = tode.replace("(tode)", String.valueOf(Main.plugin.getSqlUtils().getPTode(p2.getUniqueId())));
			                        	
			                        	String gspiele = ConfigManager.cfg.getString("messages.statsgespielt");
			                        	gspiele = ChatColor.translateAlternateColorCodes('&', gspiele);
			                        	gspiele = gspiele.replace("(spiele)", String.valueOf(Main.plugin.getSqlUtils().getPSpiele(p2.getUniqueId())));
			                        	
			                        	String wins = ConfigManager.cfg.getString("messages.statswins");
			                        	wins = ChatColor.translateAlternateColorCodes('&', wins);
			                        	wins = wins.replace("(wins)", String.valueOf(Main.plugin.getSqlUtils().getPWins(p2.getUniqueId())));
			                        	
			                        	String quote = ConfigManager.cfg.getString("messages.statsquote");
			                        	quote = ChatColor.translateAlternateColorCodes('&', quote);
			                        	quote = quote.replace("(quote)", String.valueOf(getWinQuote(p2.getUniqueId())));
			                        	
			                        	
			                        p.sendMessage(name);
			                        p.sendMessage(kills);
									p.sendMessage(tode);
									p.sendMessage(gspiele);
									p.sendMessage(wins);
									p.sendMessage(quote);
		                        	} else {
		                        		
			                        	String name = ConfigManager.cfg.getString("messages.statsheader");
			                        	name = ChatColor.translateAlternateColorCodes('&', name);
			                        	try {
											name = name.replace("(name)", String.valueOf(UUIDFetcher.getUUIDOf(arg3[0])));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	String kills = ConfigManager.cfg.getString("messages.statskills");
			                        	kills = ChatColor.translateAlternateColorCodes('&', kills);
			                        	try {
											kills = kills.replace("(kills)", String.valueOf(Main.plugin.getSqlUtils().getPKills(UUIDFetcher.getUUIDOf(arg3[0]))));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	String tode = ConfigManager.cfg.getString("messages.statstode");
			                        	tode = ChatColor.translateAlternateColorCodes('&', tode);
			                        	try {
											tode = tode.replace("(tode)", String.valueOf(Main.plugin.getSqlUtils().getPTode(UUIDFetcher.getUUIDOf(arg3[0]))));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	String gspiele = ConfigManager.cfg.getString("messages.statsgespielt");
			                        	gspiele = ChatColor.translateAlternateColorCodes('&', gspiele);
			                        	try {
											gspiele = gspiele.replace("(spiele)", String.valueOf(Main.plugin.getSqlUtils().getPSpiele(UUIDFetcher.getUUIDOf(arg3[0]))));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	String wins = ConfigManager.cfg.getString("messages.statswins");
			                        	wins = ChatColor.translateAlternateColorCodes('&', wins);
			                        	try {
											wins = wins.replace("(wins)", String.valueOf(Main.plugin.getSqlUtils().getPWins(UUIDFetcher.getUUIDOf(arg3[0]))));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	String quote = ConfigManager.cfg.getString("messages.statsquote");
			                        	quote = ChatColor.translateAlternateColorCodes('&', quote);
			                        	try {
											quote = quote.replace("(quote)", String.valueOf(getWinQuote(UUIDFetcher.getUUIDOf(arg3[0]))));
										} catch (Exception e) {
											e.printStackTrace();
										}
			                        	
			                        	
			                        p.sendMessage(name);
			                        p.sendMessage(kills);
									p.sendMessage(tode);
									p.sendMessage(gspiele);
									p.sendMessage(wins);
									p.sendMessage(quote);
		                        	}
		                        }
		
		            } else {
						p.sendMessage("§cFehler: MySQL wurde in der Config deaktiviert! Die Stats können nicht aufgeruft werden!");
					}
		return false;
	}
	

	  public static float getWinQuote(UUID p) {
		    if (Main.plugin.getSqlUtils().getPKills(p) < 1) {
		      return 0.0F;
		    }
		    if (Main.plugin.getSqlUtils().getPWins(p) < 1) {
		      return 0.0F;
		    }
		    float quote = 100.0F / Main.plugin.getSqlUtils().getPSpiele(p);
		    quote *= Main.plugin.getSqlUtils().getPWins(p);
		    quote *= 100.0F;
		    quote = Math.round(quote);
		    quote /= 100.0F;
		    return quote;
		  }
}
