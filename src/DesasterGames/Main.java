package de.xQuixi.DesasterGames;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.FallingBlock;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.xQuixi.DesasterGames.Commands.Command_DesasterGames;
import de.xQuixi.DesasterGames.Commands.Command_Fix;
import de.xQuixi.DesasterGames.Commands.Command_Start;
import de.xQuixi.DesasterGames.Commands.Command_Stats;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Data.KitManager;
import de.xQuixi.DesasterGames.Listener.BlockListener;
import de.xQuixi.DesasterGames.Listener.ChatListener;
import de.xQuixi.DesasterGames.Listener.ChestListener;
import de.xQuixi.DesasterGames.Listener.CompassListener;
import de.xQuixi.DesasterGames.Listener.CraftItemListener;
import de.xQuixi.DesasterGames.Listener.DamageListener;
import de.xQuixi.DesasterGames.Listener.DeathListener;
import de.xQuixi.DesasterGames.Listener.EntityInteractListener;
import de.xQuixi.DesasterGames.Listener.EntityListener;
import de.xQuixi.DesasterGames.Listener.FoodListener;
import de.xQuixi.DesasterGames.Listener.InteractListener;
import de.xQuixi.DesasterGames.Listener.JoinListener;
import de.xQuixi.DesasterGames.Listener.KitListener;
import de.xQuixi.DesasterGames.Listener.MeteorListener;
import de.xQuixi.DesasterGames.Listener.MoveListener;
import de.xQuixi.DesasterGames.Listener.PickDropListener;
import de.xQuixi.DesasterGames.Listener.PingListener;
import de.xQuixi.DesasterGames.Listener.QuitListener;
import de.xQuixi.DesasterGames.Listener.RespawnListener;
import de.xQuixi.DesasterGames.Listener.SwitchListener;
import de.xQuixi.DesasterGames.MySQL.MySQL;
import de.xQuixi.DesasterGames.MySQL.SQL;
import de.xQuixi.DesasterGames.Runnable.LobbyCountdown;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	private MySQL sql;
	private SQL sqlutils;
	
	public ChestListener chest;
	
	public static File kits = new File("plugins/DesasterGames", "kits.yml");
	public static FileConfiguration kcfg = YamlConfiguration.loadConfiguration(kits);
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		
		plugin = this;
		
		Data.arena = Bukkit.createWorld(new WorldCreator("arena"));
	    
	    Data.status = GameStatus.LOBBY;
	    
	    ConfigManager.createOptions();
	    
	    Data.mat.put(Material.GLOWSTONE, (byte)0);
	    Data.mat.put(Material.BEDROCK, (byte)0);
	    Data.mat.put(Material.COBBLESTONE, (byte)0);
	    Data.mat.put(Material.OBSIDIAN, (byte)0);
	    Data.mat.put(Material.NETHERRACK, (byte)0);
	    
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MeteorListener(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new CompassListener(), this);
		pm.registerEvents(new DamageListener(), this);
		pm.registerEvents(new EntityListener(), this);
		pm.registerEvents(new FoodListener(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new DeathListener(), this);
		pm.registerEvents(new PickDropListener(), this);
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new RespawnListener(), this);
		pm.registerEvents(new KitListener(), this);
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new CraftItemListener(), this);
		pm.registerEvents(new PingListener(), this);
		pm.registerEvents(new ChestListener(this), this);
		pm.registerEvents(new InteractListener(), this);
		pm.registerEvents(new EntityInteractListener(), this);
		pm.registerEvents(new SwitchListener(), this);
			
		getCommand("desastergames").setExecutor(new Command_DesasterGames());
		getCommand("stats").setExecutor(new Command_Stats());
		getCommand("fix").setExecutor(new Command_Fix());
		getCommand("start").setExecutor(new Command_Start());
		
		KitManager.loadKits();
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
		
		
		for (int i = 1; i <= 150; i++) {
	          double x = Data.random(-300, 300);
	          double y = 100.0D;
	          double z = Data.random(-200, 200);
	          Location loc = new Location(Data.arena, Data.arena.getSpawnLocation().getBlockX() + x, y, Data.arena.getSpawnLocation().getBlockZ() + z);
	          FallingBlock fb = Data.arena.spawnFallingBlock(loc, ConfigManager.cfg.getInt("inits.chestid"), (byte)0);
	          fb.setDropItem(false);
	     }
	        for (int i = 1; i <= 20; i++) {
	          double x = Data.random(-200, 200);
	          double y = 100.0D;
	          double z = Data.random(-200, 200);
	          Location loc = new Location(Data.arena, Data.arena.getSpawnLocation().getBlockX() + x, y, Data.arena.getSpawnLocation().getBlockZ() + z);
	          FallingBlock fb = Data.arena.spawnFallingBlock(loc, Material.ENCHANTMENT_TABLE, (byte)0);
	          fb.setDropItem(false);
   
	    this.chest = new ChestListener(this);

	        
		try {
			this.sql = new MySQL();
			this.sqlutils = new SQL(this);
		} catch (Exception e) {
			System.out.println("Konnte keine Verbindung zu SQL aufbauen! Reason: "+e.getMessage());
		}
		new LobbyCountdown().runTaskTimer(Main.plugin, 0L, 20L);
	        }
	}
	
	@Override
	public void onDisable() {
		for(World w : Bukkit.getWorlds()) {
			Bukkit.unloadWorld(w, false);
		}
		deleteDir(new File("arena"));
	}
	
	public MySQL getSql() {
		return sql;
	}
	
	public SQL getSqlUtils() {
		return sqlutils;
	}
	
	 public void deleteDir(File file) {
	        if (file.isDirectory()) {
	          if (file.list().length == 0) {
	            file.delete();
	        } else {
	            String[] files = file.list();
	            for (String tmp : files) {
	              File fileDelete = new File(file, tmp);
	              deleteDir(fileDelete);
	          }
	            if (file.list().length == 0)
	              file.delete();
	        }
	      } else
	          file.delete();
	 }

}
