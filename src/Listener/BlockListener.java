package de.xQuixi.DesasterGames.Listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.xQuixi.DesasterGames.Commands.Command_DesasterGames;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class BlockListener implements Listener {
	
    @EventHandler
    public void on(BlockBreakEvent e) {
    	
    	if(Command_DesasterGames.canBuild.contains(e.getPlayer())) {
    		e.setCancelled(false);
    		return;
    	}
    	
    	if(Data.status == GameStatus.INGAME && (Data.playersingame.contains(e.getPlayer()) && (Data.move == true))) {
    		e.setCancelled(false);
    	} else {
			e.setCancelled(true);
		}
    }
    
    @EventHandler
    public void on(BlockPlaceEvent e) {
    	
    	if(Command_DesasterGames.canBuild.contains(e.getPlayer())) {
    		e.setCancelled(false);
    		return;
    	}
    	
    	if(Data.status == GameStatus.INGAME && (Data.playersingame.contains(e.getPlayer()) && (Data.move == true))) {
        	if(e.getBlock().getType() == Material.CHEST) {
        		e.setCancelled(true);
        	} else {
    		e.setCancelled(false);
        	}
    	} else {
			e.setCancelled(true);
		}
    }
    
    @EventHandler
    public void on(InventoryClickEvent e) {
    	e.setCancelled(false);
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void on(PlayerLoginEvent e) {
   	 if(Data.status != GameStatus.INGAME) {
   		 if(Bukkit.getOnlinePlayers().length == Bukkit.getMaxPlayers()) {
   			 if(e.getPlayer().hasPermission("premium.premium")){
   					e.setResult(Result.ALLOWED);
   					e.allow();
   					Player[] playerList = Bukkit.getOnlinePlayers();
   					int random = new Random().nextInt(playerList.length);
   					Player pr = playerList[random];
   					int versuche = 0;
   					while(pr.hasPermission("premium.premium")){
   						if(versuche == 50){
   							break;
   						}else{
   							pr = playerList[random];
   							versuche++;
   						}
   						
   					}
   			 } else {
   				
   			
   				 String message = ConfigManager.cfg.getString("messages.serverisfull");
   				 message = ChatColor.translateAlternateColorCodes('&', message);
   				 
   			 e.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_BANNED, message);
   			 }
   		 } else {
   			e.allow();
   		}
   	 
   	}
    }

  
}
