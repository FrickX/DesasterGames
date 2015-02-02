package de.xQuixi.DesasterGames.Runnable;

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class SwitchCountdown extends BukkitRunnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		 if (Data.players.size() <= 2) {
	         this.cancel();
	          return;
	        }

	        int n = (int)Math.floor(Data.players.size() / 6) + 1;
	        for (int i = 0; i < n; i++) {
	          Player[] players = this.getTwoRandomPlayers();
	          Player p1 = players[0];
	          Player p2 = players[1];

	          Location l1 = p1.getLocation();
	          Location l2 = p2.getLocation();

	          p1.teleport(l2);
	          p2.teleport(l1);
	          String message = ConfigManager.cfg.getString("messages.switchplayer");
	          message = ChatColor.translateAlternateColorCodes('&', message);
	          message = message.replace("(name)", p1.getName());
	          p2.sendMessage(message);
	          message = message.replace("(name)", p2.getName());
	          p1.sendMessage(message);
	          Collections.shuffle(Data.players);
	          p1.playEffect(l1, Effect.ENDER_SIGNAL, 2);
	          p2.playEffect(l2, Effect.ENDER_SIGNAL, 2);
	          p1.playSound(p1.getLocation(), Sound.ENDERMAN_TELEPORT, 3.0F, 3.0F);
	        }
	}

	  public Player[] getTwoRandomPlayers()
	  {
	    Player[] players = new Player[2];

	    int n = 0;

	    for (int i = 0; i < Data.players.size(); i++) {
	      if (n < 2) {
	        Player p = Bukkit.getPlayer((String)Data.players.get(i));
	        players[n] = p;
	      }
	      n++;
	    }
	    return players;
	  }
}
