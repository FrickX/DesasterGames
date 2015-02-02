package de.xQuixi.DesasterGames.Data;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class SpawnCreater {
	
	  @SuppressWarnings("deprecation")
	public static void createSpawn(){
      int y = Data.arena.getSpawnLocation().getBlockY() + 50;
      World w = Data.arena;
    
      int x1 = Data.arena.getSpawnLocation().getBlockX() + 9;
      int z1 = Data.arena.getSpawnLocation().getBlockZ();
    
      int x2 = Data.arena.getSpawnLocation().getBlockX() + 7;
      int z2 = Data.arena.getSpawnLocation().getBlockZ() + 4;
    
      int x3 = Data.arena.getSpawnLocation().getBlockX() + 4;
      int z3 = Data.arena.getSpawnLocation().getBlockZ() + 7;
    
      int x4 = Data.arena.getSpawnLocation().getBlockX();
      int z4 = Data.arena.getSpawnLocation().getBlockZ() + 9;
    
      int x5 = Data.arena.getSpawnLocation().getBlockX() - 4;
      int z5 = Data.arena.getSpawnLocation().getBlockZ() + 7;
    
      int x6 = Data.arena.getSpawnLocation().getBlockX() - 7;
      int z6 = Data.arena.getSpawnLocation().getBlockZ() + 4;
    
      int x7 = Data.arena.getSpawnLocation().getBlockX() - 9;
      int z7 = Data.arena.getSpawnLocation().getBlockZ();
    
      int x8 = Data.arena.getSpawnLocation().getBlockX() - 7;
      int z8 = Data.arena.getSpawnLocation().getBlockZ() - 4;
    
      int x9 = Data.arena.getSpawnLocation().getBlockX() - 4;
      int z9 = Data.arena.getSpawnLocation().getBlockZ() - 7;
    
      int x10 = Data.arena.getSpawnLocation().getBlockX();
      int z10 = Data.arena.getSpawnLocation().getBlockZ() - 9;
    
      int x11 = Data.arena.getSpawnLocation().getBlockX() + 4;
      int z11 = Data.arena.getSpawnLocation().getBlockZ() - 7;
    
      int x12 = Data.arena.getSpawnLocation().getBlockX() + 7;
      int z12 = Data.arena.getSpawnLocation().getBlockZ() - 4;
    
      Location loc1b = new Location(w, x1, y - 1, z1);
      Location loc2b = new Location(w, x2, y - 1, z2);
      Location loc3b = new Location(w, x3, y - 1, z3);
      Location loc4b = new Location(w, x4, y - 1, z4);
      Location loc5b = new Location(w, x5, y - 1, z5);
      Location loc6b = new Location(w, x6, y - 1, z6);
      Location loc7b = new Location(w, x7, y - 1, z7);
      Location loc8b = new Location(w, x8, y - 1, z8);
      Location loc9b = new Location(w, x9, y - 1, z9);
      Location loc10b = new Location(w, x10, y - 1, z10);
      Location loc11b = new Location(w, x11, y - 1, z11);
      Location loc12b = new Location(w, x12, y - 1, z12);
    
      loc1b.getBlock().setType(Material.NETHER_BRICK);
      loc2b.getBlock().setType(Material.NETHER_BRICK);
      loc3b.getBlock().setType(Material.NETHER_BRICK);
      loc4b.getBlock().setType(Material.NETHER_BRICK);
      loc5b.getBlock().setType(Material.NETHER_BRICK);
      loc6b.getBlock().setType(Material.NETHER_BRICK);
      loc7b.getBlock().setType(Material.NETHER_BRICK);
      loc8b.getBlock().setType(Material.NETHER_BRICK);
      loc9b.getBlock().setType(Material.NETHER_BRICK);
      loc10b.getBlock().setType(Material.NETHER_BRICK);
      loc11b.getBlock().setType(Material.NETHER_BRICK);
      loc12b.getBlock().setType(Material.NETHER_BRICK);
    
      int y1 = Data.arena.getSpawnLocation().getBlockY() + 50;
      int y2 = Data.arena.getSpawnLocation().getBlockY() + 51;
      int y3 = Data.arena.getSpawnLocation().getBlockY() + 52;
    
      int x13 = Data.arena.getSpawnLocation().getBlockX();
      int z13 = Data.arena.getSpawnLocation().getBlockZ();
      Location loc13b = new Location(w, x13, y1 - 1, z13);
      loc13b.getBlock().setTypeId(98);
    
      int x14 = Data.arena.getSpawnLocation().getBlockX();
      int z14 = Data.arena.getSpawnLocation().getBlockZ();
      Location loc14b = new Location(w, x14, y2 - 1, z14);
      loc14b.getBlock().setTypeId(17);
    
     int x14_5 = Data.arena.getSpawnLocation().getBlockX();
     int z14_5 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc14_5b = new Location(w, x14_5, y3 - 1, z14_5);
     loc14_5b.getBlock().setTypeId(17);
    
     int x15 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z15 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc15b = new Location(w, x15, y1 - 1, z15);
     loc15b.getBlock().setTypeId(98);
    
     int x16 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z16 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc16b = new Location(w, x16, y1 - 1, z16);
     loc16b.getBlock().setTypeId(98);
    
     int x17 = Data.arena.getSpawnLocation().getBlockX();
     int z17 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc17b = new Location(w, x17, y1 - 1, z17 + 1);
     loc17b.getBlock().setTypeId(98);
    
     int x18 = Data.arena.getSpawnLocation().getBlockX();
     int z18 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc18b = new Location(w, x18 + 1, y1 - 1, z18);
     loc18b.getBlock().setTypeId(98);
    
     int x19 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z19 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc19b = new Location(w, x19, y1 - 1, z19);
     loc19b.getBlock().setTypeId(98);
    
     int x20 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z20 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc20b = new Location(w, x20, y1 - 1, z20);
     loc20b.getBlock().setTypeId(98);
    
     int x21 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z21 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc21b = new Location(w, x21, y1 - 1, z21);
     loc21b.getBlock().setTypeId(98);
    
     int x22 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z22 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc22b = new Location(w, x22, y1 - 1, z22);
     loc22b.getBlock().setTypeId(98);
    
     int x23 = Data.arena.getSpawnLocation().getBlockX() + 2;
     int z23 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc23b = new Location(w, x23, y1 - 1, z23);
     loc23b.getBlock().setTypeId(98);
    
     int x24 = Data.arena.getSpawnLocation().getBlockX() - 2;
     int z24 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc24b = new Location(w, x24, y1 - 1, z24);
     loc24b.getBlock().setTypeId(98);
    
     int x25 = Data.arena.getSpawnLocation().getBlockX();
     int z25 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     Location loc25b = new Location(w, x25, y1 - 1, z25);
     loc25b.getBlock().setTypeId(98);
    
     int x26 = Data.arena.getSpawnLocation().getBlockX();
     int z26 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     Location loc26b = new Location(w, x26, y1 - 1, z26);
     loc26b.getBlock().setTypeId(98);
    
     int x27 = Data.arena.getSpawnLocation().getBlockX() + 2;
     int z27 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc27b = new Location(w, x27, y2 - 1, z27);
     loc27b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x28 = Data.arena.getSpawnLocation().getBlockX() - 2;
     int z28 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc28b = new Location(w, x28, y2 - 1, z28);
     loc28b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x29 = Data.arena.getSpawnLocation().getBlockX();
     int z29 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     Location loc29b = new Location(w, x29, y2 - 1, z29);
     loc29b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x30 = Data.arena.getSpawnLocation().getBlockX();
     int z30 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     Location loc30b = new Location(w, x30, y2 - 1, z30);
     loc30b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x31 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z31 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc31b = new Location(w, x31, y2 - 1, z31);
     loc31b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x32 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z32 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc32b = new Location(w, x32, y2 - 1, z32);
     loc32b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x33 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z33 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc33b = new Location(w, x33, y2 - 1, z33);
     loc33b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x34 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z34 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc34b = new Location(w, x34, y2 - 1, z34);
     loc34b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x35 = Data.arena.getSpawnLocation().getBlockX() + 1;
     int z35 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc35b = new Location(w, x35, y3 - 1, z35);
     loc35b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x36 = Data.arena.getSpawnLocation().getBlockX() - 1;
     int z36 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc36b = new Location(w, x36, y3 - 1, z36);
     loc36b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x37 = Data.arena.getSpawnLocation().getBlockX();
     int z37 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc37b = new Location(w, x37, y3 - 1, z37);
     loc37b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x38 = Data.arena.getSpawnLocation().getBlockX();
     int z38 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc38b = new Location(w, x38, y3 - 1, z38);
     loc38b.getBlock().setTypeId(ConfigManager.cfg.getInt("inits.chestid"));
    
     int x39 = Data.arena.getSpawnLocation().getBlockX() + 3;
     int z39 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc39b = new Location(w, x39, y1 - 1, z39);
     loc39b.getBlock().setType(Material.STEP);
     loc39b.getBlock().setData((byte)5);
     loc39b.getBlock().getState().update(true);
    
     int x40 = Data.arena.getSpawnLocation().getBlockX();
     int z40 = Data.arena.getSpawnLocation().getBlockZ() + 3;
     Location loc40b = new Location(w, x40, y1 - 1, z40);
     loc40b.getBlock().setType(Material.STEP);
     loc40b.getBlock().setData((byte)5);
     loc40b.getBlock().getState().update(true);
    
     int x41 = Data.arena.getSpawnLocation().getBlockX() - 3;
     int z41 = Data.arena.getSpawnLocation().getBlockZ();
     Location loc41b = new Location(w, x41, y1 - 1, z41);
     loc41b.getBlock().setType(Material.STEP);
     loc41b.getBlock().setData((byte)5);
     loc41b.getBlock().getState().update(true);
    
     int x42 = Data.arena.getSpawnLocation().getBlockX();
     int z42 = Data.arena.getSpawnLocation().getBlockZ() - 3;
     Location loc42b = new Location(w, x42, y1 - 1, z42);
     loc42b.getBlock().setType(Material.STEP);
     loc42b.getBlock().setData((byte)5);
     loc42b.getBlock().getState().update(true);
    
     int x43 = Data.arena.getSpawnLocation().getBlockX() + 2;
     int z43 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     Location loc43b = new Location(w, x43, y1 - 1, z43);
     loc43b.getBlock().setType(Material.STEP);
     loc43b.getBlock().setData((byte)5);
     loc43b.getBlock().getState().update(true);
    
     int x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     int z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     Location loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);
     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);

     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);
     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);
     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);
     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y2 - 1, z44);
     loc44b.getBlock().setTypeId(17);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y2 - 1, z44);
     loc44b.getBlock().setTypeId(17);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y2 - 1, z44);
     loc44b.getBlock().setTypeId(17);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y2 - 1, z44);
     loc44b.getBlock().setTypeId(17);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 5;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 5;
     z44 = Data.arena.getSpawnLocation().getBlockZ();
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 5;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX();
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 5;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 4;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 1;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 1;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 4;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 3;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 2;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() + 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() + 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
    
     x44 = Data.arena.getSpawnLocation().getBlockX() - 2;
     z44 = Data.arena.getSpawnLocation().getBlockZ() - 3;
     loc44b = new Location(w, x44, y1 - 1, z44);
     loc44b.getBlock().setType(Material.STEP);


     loc44b.getBlock().setData((byte)5);
     loc44b.getBlock().getState().update(true);
      }

}
