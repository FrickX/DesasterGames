package de.xQuixi.DesasterGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class Command_Start implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		
		Player p = (Player) arg0;
		
		if(p.hasPermission("desastergames.start")) {
			if(Data.status == GameStatus.INGAME) {
				p.sendMessage("§cFehler: Das Spiel ist bereits InGame.");
				return true;
			}
			
			if(Data.countdown < 11) {
				p.sendMessage("§cFehler: Der Countdown kann jetzt nicht gesetzt werden!");
				return true;
			}
			
			Data.countdown = 11;
		} else {
			p.sendMessage("§cDu hast keine Rechte!");
		}
		
		return false;
	}

}
