package de.xQuixi.DesasterGames.Data;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class Data {
	
	public static String keineRechte = "§cDu hast keine Rechte!";
	
	public static File loc = new File("plugins/DesasterGames","locations.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(loc);
	
	public static File dest = new File("arena");
	
	public static World arena = Bukkit.getWorld("arena");
    public static ArrayList<Location> spawns = new ArrayList<Location>();
    public static ArrayList<String> players = new ArrayList<>();
    public static ArrayList<Player> spec = new ArrayList<>();
    public static ArrayList<Player> playersingame = new ArrayList<>();
    public static HashMap<Material, Byte> mat = new HashMap<>();
    
    public static List<Kit> allKits = new ArrayList<>();
    
    public static boolean damage = false;
    public static boolean move = true;
    public static int lavanr = 0;
    
    public static GameStatus status;
    
    public static int taskid;
    

    public static void createVulkanloch() {
    	
      arena.createExplosion(arena.getSpawnLocation().add(0.0D, -1.0D, 0.0D), 10.0F);
      arena.createExplosion(arena.getSpawnLocation().add(0.0D, 3.0D, 0.0D), 10.0F);
      arena.createExplosion(arena.getSpawnLocation().add(0.0D, -3.0D, 0.0D), 5.0F);

      arena.getHighestBlockAt(arena.getSpawnLocation().add(0.0D, -5.0D, 0.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(1.0D, -4.0D, 0.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(-1.0D, -3.0D, 0.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(0.0D, -5.0D, 1.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(0.0D, -5.0D, -1.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(1.0D, -2.0D, 1.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(-1.0D, -4.0D, -1.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(-1.0D, -3.0D, 1.0D)).setType(Material.LAVA);
      arena.getHighestBlockAt(arena.getSpawnLocation().add(1.0D, -3.0D, -1.0D)).setType(Material.LAVA);
      
    }
    
    public static void vulkan() {
    	
      int vulkanzeit = (int)(Math.random() * 5.0D * 60.0D + 1.0D);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        @SuppressWarnings("deprecation")
		public void run()
        {
          createVulkanloch();
          spawnexplosion();
          Bukkit.broadcastMessage(ConfigManager.getStringFromFile("messages.spawnvulkan"));
          for (Player p : Bukkit.getOnlinePlayers())
            p.playSound(p.getLocation(), Sound.EXPLODE, 10.0F, 10.0F);
        }
      }
      , vulkanzeit * 20L);
    }
    
    public static void spawnexplosion()
    {
      final Location loc = new Location(arena, arena.getSpawnLocation().getBlockX(), arena.getSpawnLocation().getBlockY() + 1, arena.getSpawnLocation().getBlockZ());

  

      new BukkitRunnable() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			for (int i = 1; i <= 3; i++) {
	            int r = (int)random(1, 10);
	            FallingBlock fb = null;
	            switch (r) { case 1:
	              fb = arena.spawnFallingBlock(loc, Material.LAVA, (byte)0);
	              break;
	            case 2:
	              fb = arena.spawnFallingBlock(loc, Material.NETHERRACK, (byte)0);
	              break;
	            case 3:
	              fb = arena.spawnFallingBlock(loc, Material.STONE, (byte)0);
	              break;
	            case 4:
	              fb = arena.spawnFallingBlock(loc, Material.MOSSY_COBBLESTONE, (byte)0);
	              break;
	            case 5:
	              fb = arena.spawnFallingBlock(loc, Material.COBBLESTONE, (byte)0);
	              break;
	            case 6:
	              fb = arena.spawnFallingBlock(loc, Material.LAVA, (byte)0);
	              break;
	            case 7:
	              fb = arena.spawnFallingBlock(loc, Material.LAVA, (byte)0);
	              break;
	            case 8:
	              fb = arena.spawnFallingBlock(loc, Material.NETHERRACK, (byte)0);
	              break;
	            case 9:
	              fb = arena.spawnFallingBlock(loc, Material.STONE, (byte)0);
	              break;
	            case 10:
	              fb = arena.spawnFallingBlock(loc, Material.LAVA, (byte)0);
	            }

	            double x = random(3, -3);
	            double y = 5.0D;
	            double z = random(3, -3);
	            fb.setVelocity(new Vector(x, y, z));
	            fb.setDropItem(false);
	          }
	          arena.playSound(arena.getSpawnLocation(), Sound.WITHER_SHOOT, 10.0F, 10.0F);
	          lavanr += 1;
	          if (lavanr == 1500) {
	            this.cancel();
	        }
		}
		
	};
    }
    
    public static ItemStack setMaterialWithColor(Color c, Material m) {
    	ItemStack item = new ItemStack(m);
    	LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
    	meta.setColor(c);
    	item.setItemMeta(meta);
    	return item;
    }
    
   /* public static void playSound(String sound, Player p) {
    	PacketPlayOutNamedSoundEffect packet = new PacketPlayOutNamedSoundEffect(sound, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), 1.0F, 1.0F);
    	((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }*/
    
    
    public static ArrayList<Location> seeblocks = new ArrayList<Location>();
	 public static Location getRandomLocation(World world){
		  Random rnd = new Random();
		  Location loc = world.getSpawnLocation();
		  double x = loc.getX();
		        double z = loc.getZ();
		        x = x - 8 + rnd.nextInt(200/2);
		        z = z - 8 + rnd.nextInt(200/2);
		        loc.setX(x);
		        loc.setZ(z);
		        loc.setY(world.getHighestBlockYAt(loc.getBlockX(), loc.getBlockZ()));
		          if(loc.distance(loc.getWorld().getSpawnLocation()) >= 200.0D){
		           loc.setY(loc.getY() + 1);
	
		          
		         }
		          x = loc.getX();
		          z = loc.getZ();
		          x = x - 8 + rnd.nextInt(700/2);
		          z = z - 8 + rnd.nextInt(700/2);
		          loc.setX(x);
		          loc.setZ(z);
		                loc.setY(world.getHighestBlockYAt(loc.getBlockX(), loc.getBlockZ()));
		        
		       
		  return loc;
		 }
	
	public static void setLocation(String path, Player p) {
		cfg.set(path + ".x", p.getLocation().getX());
		cfg.set(path + ".y", p.getLocation().getY());
		cfg.set(path + ".z", p.getLocation().getZ());
		cfg.set(path + ".yaw", p.getLocation().getYaw());
		cfg.set(path + ".world", p.getWorld().getName());
		try {
			cfg.save(loc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int countdown = 120;
	public static int movecountdown = 30;
	public static int damagecountdown = 60;
	public static int deathmatchcountdowninminuten = 5;
	public static int deathmatchcountdowninsekunden = 59;
	
	public static HashMap<String, Kit> kit = new HashMap<String, Kit>();

    public static double random(int low, int high){
    return Math.random() * (high - low) + low;
    }


	public static Location getLocation(String path) {
		double x = cfg.getDouble(path + ".x");
		double y = cfg.getDouble(path + ".y");
		double z = cfg.getDouble(path + ".z");
		double yaw = cfg.getDouble(path + ".yaw");
		String w = cfg.getString(path + ".world");
		Location loc = new Location(Bukkit.getWorld(w), x, y, z);
		loc.setYaw((float) yaw);
		return loc;
	}
	
	   public static void deleteDir(File file) {
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


	 
		public static ItemStack newItem(Material m, int anzahl, int sh, String name){
			ItemStack item = new ItemStack(m, anzahl, (short)sh);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(name);
			item.setItemMeta(meta);
			
			return item;
		}

		public static void connecttoServer(String name, Player p) {
			ByteArrayOutputStream s = new ByteArrayOutputStream();
			DataOutputStream d = new DataOutputStream(s);
			
			try {
			d.writeUTF("Connect");
			d.writeUTF(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			p.sendPluginMessage(Main.plugin, "BungeeCord", s.toByteArray());
		}	
}
