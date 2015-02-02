package de.xQuixi.DesasterGames.Data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MapCreater {
	
	 public static void createMap() {
	 int y = Bukkit.getWorld("arena").getSpawnLocation().getBlockY() + 50;
     World w = Bukkit.getWorld("arena");
   
     double x1 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 9 + 0.5D;
     double z1 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 0.5D;
   
     double x2 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 7 + 0.5D;
     double z2 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 4 + 0.5D;
   
     double x3 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 4 + 0.5D;
     double z3 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 7 + 0.5D;
   
     double x4 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 0.5D;
     double z4 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 9 + 0.5D;
   
     double x5 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() - 4 + 0.5D;
     double z5 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 7 + 0.5D;
   
     double x6 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() - 7 + 0.5D;
     double z6 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 4 + 0.5D;
   
     double x7 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() - 9 + 0.5D;
     double z7 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() + 0.5D;
   
     double x8 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() - 7 + 0.5D;
     double z8 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() - 4 + 0.5D;
   
     double x9 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() - 4 + 0.5D;
     double z9 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() - 7 + 0.5D;
   
     double x10 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 0.5D;
     double z10 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() - 9 + 0.5D;
   
    double x11 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 4 + 0.5D;
    double z11 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() - 7 + 0.5D;
   
    double x12 = Bukkit.getWorld("arena").getSpawnLocation().getBlockX() + 7 + 0.5D;
    double z12 = Bukkit.getWorld("arena").getSpawnLocation().getBlockZ() - 4 + 0.5D;
   
    Location loc1 = new Location(w, x1, y, z1);
    Location loc2 = new Location(w, x2, y, z2);
    Location loc3 = new Location(w, x3, y, z3);
    Location loc4 = new Location(w, x4, y, z4);
    Location loc5 = new Location(w, x5, y, z5);
    Location loc6 = new Location(w, x6, y, z6);
    Location loc7 = new Location(w, x7, y, z7);
    Location loc8 = new Location(w, x8, y, z8);
    Location loc9 = new Location(w, x9, y, z9);
    Location loc10 = new Location(w, x10, y, z10);
    Location loc11 = new Location(w, x11, y, z11);
    Location loc12 = new Location(w, x12, y, z12);
   
    Data.spawns.add(loc1);
    Data.spawns.add(loc2);
    Data.spawns.add(loc3);
    Data.spawns.add(loc4);
    Data.spawns.add(loc5);
    Data.spawns.add(loc6);
    Data.spawns.add(loc7);
    Data.spawns.add(loc8);
    Data.spawns.add(loc9);
    Data.spawns.add(loc10);
    Data.spawns.add(loc11);
    Data.spawns.add(loc12);
   
    SpawnCreater.createSpawn();
   
    for (int i = 0; i < Data.players.size(); i++) {
        Player ziel = Bukkit.getPlayer((String)Data.players.get(i));
        ziel.teleport((Location)Data.spawns.get(i));
        }
           }
	 

}
