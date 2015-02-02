package de.xQuixi.DesasterGames.Data;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kit
{
  private ItemStack icon;
  private ItemStack[] items;
  private String name;

  public Kit(String name, ItemStack icon, ItemStack[] items)
  {
    this.name = name;
    this.icon = icon;
    this.items = items;

    ItemMeta im = this.icon.getItemMeta();
    im.setDisplayName(name);
    this.icon.setItemMeta(im);
  }

  public void giveItems(Player p)
  {
    for (int i = 0; i < this.items.length; i++) {
      p.getInventory().addItem(new ItemStack[] { this.items[i] });
    }
    p.updateInventory();
  }

  public ItemStack getIcon() {
    return this.icon;
  }

  public String getName() {
    return this.name;
  }

}