package de.xQuixi.DesasterGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Fix implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		
	
		((Player)arg0).teleport((((Player)arg0).getLocation()));
		((Player)arg0).sendMessage("§6Deine Location wurde neu geladen.");
		
		return false;
	}

}
