package de.xQuixi.DesasterGames.Listener;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.Data;

public class Bacterium {
	
	public static int radius;
	
	public int randomInt(int min, int max){
		return new Random().nextInt(max - min) + min;
	}
	
	public Bacterium (final Location loc, final Material mat, int radius){
		loc.getBlock().setType(mat);
		
		Bacterium.radius = radius;
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				if(Bacterium.radius != 0){
				
				Location o = null;
				
				if(Data.seeblocks.size() != 0){
					o = Data.seeblocks.get(new Random().nextInt(Data.seeblocks.size()));
				} else {
					o = loc;
				}
				
				int size = 2; 
				
				while(size != 0){
					
				Block b = o.getBlock().getRelative(BlockFace.values()[new Random().nextInt(BlockFace.values().length)]);
					
				if(b.getType() == Material.AIR || b.getType() == mat){
					if(size > 15){
						break;
					}
					size++;
				} else {
					Data.seeblocks.add(b.getLocation());
					b.setType(mat);
				}
				
					size--;
				}
				
				Bacterium.radius--;
				
				} else {
					this.cancel();
				}
				
			}
			
		}.runTaskTimer(Main.plugin, 0L, 15L);
	}
	
}