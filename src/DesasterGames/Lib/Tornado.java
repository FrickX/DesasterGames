package de.xQuixi.DesasterGames.Lib;

import java.util.ArrayDeque;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Tornado extends JavaPlugin implements Listener {

   public static void spawnTornado(
           final JavaPlugin plugin,
           final Location  location,
           final Material  material,
           final byte      data,
           final Vector    direction,
           final double    speed,
           final int        amount_of_blocks,
           final long      time,
           final boolean    spew
   ) {
       // Modify the direction vector using the speed argument.
       if (direction != null) {
           direction.normalize().multiply(speed);
       }
       
       
  
       class VortexBlock {
  
           Entity entity;
        
           private boolean removable = true;
  
           private float ticker_vertical = 0.0f;
           private float ticker_horisontal = (float) (Math.random() * 2 * Math.PI);
  
           @SuppressWarnings("deprecation")
           public VortexBlock(Location l, Material m, byte d) {
  
               if (l.getBlock().getType() != Material.AIR) {
  
            	   
            	   
                   Block b = l.getBlock();
                   entity = l.getWorld().spawnFallingBlock(l, b.getType(), b.getData());
   			       ParticleEffects.sendToLocation(ParticleEffects.FIRE, l, 0.0F, 0.0F, 0.0F, 2.0F, 5);
   			       l.getWorld().playEffect(l, Effect.SMOKE, 10000);
  
                   if (b.getType() != Material.WATER)
                       b.setType(Material.AIR);
                
                   removable = false;
               }
               else
                   entity = l.getWorld().spawnFallingBlock(l, m, d);
            
               addMetadata();
               tick();
           }
        
           public VortexBlock(Entity e) {
               entity    = e;
               removable = false;
               addMetadata();
               tick();
           }
        
           private void addMetadata() {
               entity.setMetadata("vortex", new FixedMetadataValue(plugin, "protected"));
           }
        
           public void remove() {
               if(removable || (!spew && (entity instanceof FallingBlock))) {
                   entity.remove();
               }
               entity.removeMetadata("vortex", plugin);
           }
  
           @SuppressWarnings("deprecation")
           public VortexBlock tick() {
            
               double radius    = Math.sin(verticalTicker()) * 2;
               float  horisontal = horisontalTicker();
            
               Vector v = new Vector(radius * Math.cos(horisontal), 0.5D, radius * Math.sin(horisontal));
            
               setVelocity(v);
            
               // Pick up blocks
               Block b = entity.getLocation().add(v).getBlock();
               if(b.getType() != Material.AIR) {
                   return new VortexBlock(b.getLocation(), b.getType(), b.getData());
               }
            
               // Pick up other entities
               List<Entity> entities = entity.getNearbyEntities(1.0D, 1.0D, 1.0D);
               for(Entity e : entities) {
                   if(!e.hasMetadata("vortex")) {
                       return new VortexBlock(e);
                   }
               }
            
               return null;
           }
  
           private void setVelocity(Vector v) {
               entity.setVelocity(v);
           }
  
           private float verticalTicker() {
               if (ticker_vertical < 1.0f) {
                   ticker_vertical += 0.05f;
               }
               return ticker_vertical;
           }
  
           private float horisontalTicker() {
//                   ticker_horisontal = (float) ((ticker_horisontal + 0.8f) % 2*Math.PI);
               return (ticker_horisontal += 0.8f);
           }
       }
  
       final int id = new BukkitRunnable() {
  
           private ArrayDeque<VortexBlock> blocks = new ArrayDeque<VortexBlock>();
  
           public void run() {
  
               // Spawns 10 blocks at the time, with a maximum of 200 blocks at
               // the same time.
               for (int i = 0; i < 10; i++) {
                   if (direction != null) {
                       location.add(direction);
                   }
                
                   checkListSize();
                   blocks.add(new VortexBlock(location, material, data));
               }
            
            
               // Make all blocks in the list spin, and pick up any blocks that get in the way.
               ArrayDeque<VortexBlock> que = new ArrayDeque<VortexBlock>();
  
               for (VortexBlock vb : blocks) {
                   VortexBlock temp = vb.tick();
                   if(temp != null) {
                       que.add(temp);
                   }
               }
            
               for(VortexBlock vb : que) {
                   checkListSize();
                   blocks.add(vb);
               }
           }
        
           // Removes the oldest block if the list goes over the limit.
           private void checkListSize() {
               if (blocks.size() >= amount_of_blocks) {
                   VortexBlock vb = blocks.getFirst();
                   vb.remove();
                   blocks.remove(vb);
               }
           }
        
       }.runTaskTimer(plugin, 5L, 5L).getTaskId();
  
       // Stop the "tornado" after the given time.
       new BukkitRunnable() {
           public void run() {
               plugin.getServer().getScheduler().cancelTask(id);
           }
       }.runTaskLater(plugin, time);
   }
   
     
}