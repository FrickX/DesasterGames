package de.xQuixi.DesasterGames.Listener;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Events.MeteorSpawnEvent;
import de.xQuixi.DesasterGames.Status.GameStatus;
      
      public class MeteorListener
        implements Listener
      {
      
        public static void spawnMeteor() {
        	
        if ((Data.status == GameStatus.INGAME) && (Data.damage == true) && 
          (Data.players.size() > 1)) {
          int nr = (int)(Math.random() * Data.players.size());
          if (Bukkit.getPlayer((String)Data.players.get(nr)).getWorld().getName().equals("arena")) {
        	  
				String message = ConfigManager.cfg.getString("meteorspawn");
				message = ChatColor.translateAlternateColorCodes('&', message);
				message = message.replace("(name)", (String)Data.players.get(nr));
        	  
            Bukkit.broadcastMessage(message);
            Player p = Bukkit.getPlayer((String)Data.players.get(nr));
            Location metloc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 100, p.getLocation().getBlockZ());
            Bukkit.getPluginManager().callEvent(new MeteorSpawnEvent(p));
            
           /* for(Player all : Bukkit.getOnlinePlayers()) {
            	Data.playSound("dg2", all);
            }*/
      
           createFallingSphere(metloc, ConfigManager.cfg.getInt("inits.meteoritengroesse"), Data.mat);
            Data.arena.playSound(p.getLocation(), Sound.FIRE, 100.0F, 100.0F);
            }
          }
        }
        
        @SuppressWarnings("deprecation")
    	public static void createFallingSphere(Location loc, int radius, HashMap<Material, Byte> hash){
    		 int bX = loc.getBlockX();
    		 int bY = loc.getBlockY();
    		 int bZ = loc.getBlockZ();
    		 boolean hollow = true;
    		    
    		    for (int x = bX - radius; x <= bX + radius; x++) {
    		        for (int y = bY - radius; y <= bY + radius; y++) {
    		            for (int z = bZ - radius; z <= bZ + radius; z++) {
    		                double distance = ((bX - x) * (bX - x) + ((bZ - z) * (bZ - z)) + ((bY - y) * (bY - y)));

    		                if (distance < radius * radius && !(hollow && distance < ((radius - 1) * (radius - 1)))) {
    		                	Location l = new Location(loc.getWorld(), x, y-5,z);
    		                	
    		                	Material mat = (Material) hash.keySet().toArray()[new Random().nextInt(hash.keySet().size())];
    		                	byte data = hash.get(mat);
    		                	
    		                	l.getWorld().spawnFallingBlock(l, mat, data);
    		                }
    		    }     
    		        }
    		    		}
    	 }
      
        @EventHandler
        public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        	
       if ((event.getEntity() instanceof FallingBlock)) {
    	   
         final Block b = event.getBlock();
         Bukkit.getScheduler().scheduleSyncDelayedTask(de.xQuixi.DesasterGames.Main.plugin, new Runnable()
            {
              @SuppressWarnings("deprecation")
          public void run()
              {
             if (b.getType() == Material.BEDROCK || (b.getType() == Material.GLOWSTONE || (b.getType() == Material.COBBLESTONE || (b.getType() == Material.NETHERRACK || (b.getType() == Material.OBSIDIAN))))) {
               b.setType(Material.AIR);
               Location exloc = b.getLocation();
      
              if(Data.status == GameStatus.INGAME) {
                 b.getWorld().createExplosion(exloc, 5.0F);
                 List<Entity> near = exloc.getWorld().getEntities();
                 for (Entity e : near) {
                   if ((e.getLocation().distance(exloc) <= 5.0D) && 
                     ((e instanceof Player))) {
                     ((Player)e).damage(10);
                      }
      
                    }
      
                 for (int x = exloc.getBlockX() - 3; x <= exloc.getBlockX() + 3; x++) {
                   for (int z = exloc.getBlockZ() - 3; z <= exloc.getBlockZ() + 3; z++) {
                     Block b = Data.arena.getHighestBlockAt(x, z);
                     int r = (int)Data.random(1, 7);
                     switch (r) { case 1:
                       b.setType(Material.OBSIDIAN);
                       break;
                        case 2:
                       b.setType(Material.OBSIDIAN);
                       break;
                        case 3:
                       b.setType(Material.OBSIDIAN);
                       break;
                        case 4:
                       b.setType(Material.NETHERRACK);
                       break;
                        case 5:
                       b.setType(Material.GLOWSTONE);
                       break;
                        case 6:
                       b.setType(Material.FIRE);
                       break;
                        case 7:
                        b.setType(Material.COBBLESTONE);

                        }
                      }
      
                    }
      
                  }
      
               Data.arena.getHighestBlockAt(b.getLocation()).setTypeId(ConfigManager.cfg.getInt("messages.chestid"));
             } else if ((b.getType() == Material.LAVA) || (b.getType() == Material.NETHERRACK) || (b.getType() == Material.STONE) || (b.getType() == Material.COBBLESTONE) || (b.getType() == Material.MOSSY_COBBLESTONE)) {
               Bukkit.getScheduler().scheduleSyncDelayedTask(de.xQuixi.DesasterGames.Main.plugin	, new Runnable()
                  {
                    public void run()
                    {
                   double r = Data.random(0, 8);
                   if (r != 8.0D)
                     b.getLocation().getBlock().setType(Material.AIR);
                    }
                  }
                  , 5L);
                }
              }
            }
            , 10L);
          }
        }
      }

