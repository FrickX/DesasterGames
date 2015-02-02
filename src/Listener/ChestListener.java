package de.xQuixi.DesasterGames.Listener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.xQuixi.DesasterGames.Main;
import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class ChestListener
implements Listener
{
private List<ItemStack> chestItems;
private Random rnd;
private HashMap<Location, Inventory> invs;

public ChestListener(Main plugin)
{
  this.chestItems = new LinkedList<>();
  this.rnd = new Random();
  this.invs = new HashMap<>();
  initItems();
}
@SuppressWarnings("deprecation")
@EventHandler
public void onChestOpen(PlayerInteractEvent e) {
  Player p = e.getPlayer();
  if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
    if(Data.status == GameStatus.INGAME) {
      if (e.getClickedBlock().getTypeId() ==  ConfigManager.cfg.getInt("inits.chestid"))
        if(Data.playersingame.contains(p)) {
          e.setCancelled(true);

          p.playSound(p.getEyeLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
          if (this.invs.containsKey(e.getClickedBlock().getLocation())) {
            p.openInventory((Inventory)this.invs.get(e.getClickedBlock().getLocation()));
          }
          else
          {
        	  String chest = ConfigManager.cfg.getString("messages.chesttitle");
        	  chest = ChatColor.translateAlternateColorCodes('&', chest);
            Inventory inv = Bukkit.createInventory(null, 27, chest);

            for (int i = 0; i < this.rnd.nextInt(5) + 3; i++) {
              inv.setItem(this.rnd.nextInt(25), (ItemStack)this.chestItems.get(this.rnd.nextInt(this.chestItems.size() - 1)));
            }
            this.invs.put(e.getClickedBlock().getLocation(), inv);
            p.openInventory(inv);
          }
        } else {
          e.setCancelled(true);
          p.closeInventory();
        }
    }
    else
    {
      e.setCancelled(true);
      p.closeInventory();
    }
}

@SuppressWarnings("deprecation")
protected void initItems()
{
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 4));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.GOLD_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.DIAMOND, 2));
  this.chestItems.add(new ItemStack(Material.DIAMOND, 4));
  this.chestItems.add(new ItemStack(Material.DIAMOND));
  
  ItemStack item = new ItemStack(Material.SNOW_BALL, 2);
  ItemMeta im = item.getItemMeta();
  im.setDisplayName("§5Switcher");
  item.setItemMeta(im);
  
  this.chestItems.add(item);
  this.chestItems.add(new ItemStack(Material.DIAMOND));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 6));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 3));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 4));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT, 2));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT));
  this.chestItems.add(new ItemStack(Material.BLAZE_ROD, 1));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT));
  this.chestItems.add(new ItemStack(Material.IRON_INGOT));
  this.chestItems.add(new ItemStack(Material.LEATHER));
  this.chestItems.add(new ItemStack(Material.LEATHER, 2));
  this.chestItems.add(new ItemStack(Material.LEATHER, 2));
  this.chestItems.add(new ItemStack(Material.LEATHER, 2));

  this.chestItems.add(new ItemStack(Material.ENDER_PEARL));
  this.chestItems.add(new ItemStack(Material.ENDER_PEARL, 3));
  this.chestItems.add(new ItemStack(Material.ENDER_PEARL, 4));
  this.chestItems.add(new ItemStack(Material.ENDER_PEARL));
  this.chestItems.add(new ItemStack(Material.ENDER_PEARL, 3));
  this.chestItems.add(new ItemStack(Material.ENDER_PEARL, 4));

  this.chestItems.add(new ItemStack(Material.PORK, 2));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(391, 2));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.BREAD));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.PORK, 2));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(391, 2));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.BREAD));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.PORK, 2));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(Material.PORK));
  this.chestItems.add(new ItemStack(391, 2));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(391));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.WHEAT));
  this.chestItems.add(new ItemStack(Material.BREAD));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));
  this.chestItems.add(new ItemStack(Material.BAKED_POTATO, 2));

  this.chestItems.add(new ItemStack(Material.BOW));
  this.chestItems.add(new ItemStack(Material.BOW));
  this.chestItems.add(new ItemStack(Material.BOW));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 6));
  this.chestItems.add(new ItemStack(Material.ARROW, 12));
  this.chestItems.add(new ItemStack(Material.ARROW, 12));

  this.chestItems.add(new ItemStack(Material.WOOD, 6));
  this.chestItems.add(new ItemStack(Material.WOOD, 4));
  this.chestItems.add(new ItemStack(Material.STICK, 4));
  this.chestItems.add(new ItemStack(Material.STICK, 2));
  this.chestItems.add(new ItemStack(384));
  this.chestItems.add(new ItemStack(384, 2));
  this.chestItems.add(new ItemStack(384, 4));
}

 
}