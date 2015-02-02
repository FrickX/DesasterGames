package de.xQuixi.DesasterGames.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.xQuixi.DesasterGames.Main;

public class KitManager
{
  @SuppressWarnings("deprecation")
public static void loadKits()
  {
    if(!Main.kits.exists()) {
      List<String> items1 = new ArrayList<>();
      items1.add("268,1,0,0,0");
      items1.add("298,1,0,0,0");
      items1.add("299,1,0,0,0");
      items1.add("300,1,0,0,0");
      items1.add("301,1,0,0,0");
      items1.add("364,3,0,0,0");

      Main.kcfg.set("Kits.ritter.items", items1);
      Main.kcfg.set("Kits.ritter.icon", Integer.valueOf(276));

      List<String> items2 = new ArrayList<>();
      items2.add("298,1,0,0,0");
      items2.add("261,1,0,0,0");
      items2.add("262,16,0,0,0");
      items2.add("364,1,0,0,0");

      Main.kcfg.set("Kits.scout.items", items2);
      Main.kcfg.set("Kits.scout.icon", Integer.valueOf(261));

      try {
    	  Main.kcfg.save(Main.kits);
	} catch (IOException e) {
		e.printStackTrace();
	}
      try {
    	  Main.kcfg.save(Main.kits);
      }
      catch (IOException localIOException)
      {
      }

    }

    for (String kitname :  Main.kcfg.getConfigurationSection("Kits").getKeys(false)) {
      List<String> items = Main.kcfg.getStringList("Kits." + kitname + ".items");
      int icon = Main.kcfg.getInt("Kits." + kitname + ".icon");

      ItemStack[] itemlist = new ItemStack[items.size()];

      for (int i = 0; i < items.size(); i++)
      {
        String s = (String)items.get(i);
        String[] data = s.split(",");

        ItemStack is = new ItemStack(Material.getMaterial(Integer.parseInt(data[0])), Integer.parseInt(data[1]));

        MaterialData md = is.getData();
        md.setData(Byte.parseByte(data[2]));
        is.setData(md);

        if (Integer.parseInt(data[3]) != 0) {
          is.addUnsafeEnchantment(Enchantment.getById(Integer.parseInt(data[3])), Integer.parseInt(data[4]));
        }

        itemlist[i] = is;
      }

      Kit kit = new Kit(kitname, new ItemStack(Material.getMaterial(icon)), itemlist);
      Data.allKits.add(kit);
    }
  }
}