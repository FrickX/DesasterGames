package de.xQuixi.DesasterGames.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xQuixi.DesasterGames.Data.Data;

public class Command_DesasterGames implements CommandExecutor {
	
	public static ArrayList<Player> canBuild = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		Player p = (Player) arg0;
		
		if(p.hasPermission("dg.use")) {
			if(arg3.length == 0) {
				p.sendMessage("§cVerwendung: §b/DesasterGames <setlobby | setspec, setholostats | setdmspawn <id>>");
			}		
			if(arg3.length == 1) {
			     if(arg3[0].equalsIgnoreCase("setlobby")) {
			    	 Data.setLocation("lobby", p);
			    	 p.sendMessage("§aDie §7Lobby §awurde gesetzt.");
			     }
			     
			     if(arg3[0].equalsIgnoreCase("setspec")) {
			    	 Data.setLocation("spec", p);
			    	 p.sendMessage("§aDer §7Spectator Spawn §7wurde gesetzt!");
			     }
			     
			     if(arg3[0].equalsIgnoreCase("setholostats")) {
			    	 Data.setLocation("hologram", p);
			    	 p.sendMessage("§aDie §7Holo Stats §awurden gesetzt!");
			     }
			     
			     if(arg3[0].equalsIgnoreCase("start")) {
			    	 Data.countdown = 5;
			     }
			     
			     if(arg3[0].equalsIgnoreCase("build")) {
			    	 if(!canBuild.contains(p)) {
			    		 canBuild.add(p);
			    		 p.sendMessage("§aDu kannst nun bauen!");
			    	 } else {
			    		 canBuild.remove(p);
			    		 p.sendMessage("§aDu kannst nun nicht mehr bauen!");
			    	 }
			     }
			     
			}
			
			if(arg3.length == 2) {
				if(arg3[0].equalsIgnoreCase("setdmspawn") || (arg3[0].equalsIgnoreCase("setdeathmatchspawn"))) {
					int id = 0;
					try {
						id = Integer.parseInt(arg3[1]);
					} catch (ArrayIndexOutOfBoundsException array) {
						p.sendMessage("§cFehler: Gebe eine Zahl an!");
					} catch (NumberFormatException nfe) {
						p.sendMessage("§cFehler: Gebe eine Zahl an!");
					}
					
					Data.setLocation("match."+id, p);
					p.sendMessage("§aDer Deathmatch Spawn §7"+id+" §awurde gesetzt!");
				}
			}
			
		} else { 
			p.sendMessage("§aPlugin by §exQuixi");
		}
		boolean penis = false;
		return penis;
	}


}
