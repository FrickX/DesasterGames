package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Lib.ParticleEffects;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class MoveListener implements Listener {
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if(Data.move == false) {
        for (int i = 0; i < Data.players.size(); i++) {
            Player ziel = Bukkit.getPlayer((String)Data.players.get(i));
            int x = ((Location)Data.spawns.get(i)).getBlockX();
            int z = ((Location)Data.spawns.get(i)).getBlockZ();
            if ((x != ziel.getLocation().getBlockX()) || (z != ziel.getLocation().getBlockZ())) {
              Location loctp = new Location(ziel.getWorld(), x + 0.5D, ziel.getLocation().getY(), z + 0.5D, ziel.getLocation().getYaw(), ziel.getLocation().getPitch());
              ziel.teleport(loctp);
               }
             }
		}
		
		if(e.getPlayer().getWorld().getName().equals("arena")) {
		   if(e.getPlayer().getLocation().distance(Data.arena.getSpawnLocation()) >= ConfigManager.cfg.getDouble("inits.mapgroesse")) {
			   double Ax = p.getLocation().getX();
				double Ay = p.getLocation().getY();
				double Az = p.getLocation().getZ();
				
				double Bx = Data.arena.getSpawnLocation().getX();
				double By = Data.arena.getSpawnLocation().getY();
				double Bz = Data.arena.getSpawnLocation().getZ();
				
				double x = Ax - Bx;
				double y = Ay - By;
				double z = Az - Bz;
				Vector v = new Vector(x, y, z).normalize().multiply(-1D).setY(0.3D);
				p.setVelocity(v);
				p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 3.0F, 3.0F);
			    ParticleEffects.sendToLocation(ParticleEffects.MOB_SPELL, p.getLocation(), 0.0F, 0.0F, 0.0F, 2.0F, 5);
		   }
		}
		
		if(Data.spec.contains(p) && (Data.status == GameStatus.INGAME && (p.getWorld().getName().equals("arena")))){
			for(Player players : Data.playersingame){
			    if(e.getTo().distance(players.getLocation()) < 3){
			     p.setVelocity(p.getLocation().getDirection().multiply(-1.0));
			    }
			   }		
			}
		if(p.getLocation().getY() <= (p.getWorld().getHighestBlockYAt(p.getLocation()))) {
			if(Data.playersingame.contains(p)) {
				if(Data.arena.isThundering() == true || (Data.arena.hasStorm() == true)) {
					
						new BukkitRunnable() {
							
							@Override
							public void run() {
								
							
								if(p.getLocation().getY() <= (p.getWorld().getHighestBlockYAt(p.getLocation()))) {
									this.cancel();
								} else {
									double heal = ((CraftPlayer)p).getHealth();
									p.setHealth(heal - 0.5);
								}
								
							}
						}.runTaskTimer(Main.plugin, 0L, 20L);
				
			}
			
		}
		}
		}

}
