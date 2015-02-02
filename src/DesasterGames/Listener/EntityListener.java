package de.xQuixi.DesasterGames.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.xQuixi.DesasterGames.Data.Data;
import de.xQuixi.DesasterGames.Status.GameStatus;

public class EntityListener implements Listener {
	
	@EventHandler
	public void on(CreatureSpawnEvent e) {
		
		if(Data.status == GameStatus.INGAME) {
			if(e.getEntity().getWorld().getName().equals("arena")) {
				if(e.getEntity().getType() == EntityType.SKELETON) {
					e.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999, 9999));
					e.getEntity().getWorld().spawn(e.getEntity().getLocation(), Bat.class).setPassenger(e.getEntity());
					e.getEntity().getEquipment().setHelmet(new ItemStack(Material.PUMPKIN_PIE));
					e.getEntity().getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD));
					return;
				}
			}
		}
		
		if(e.getEntity().getType() == EntityType.COW || (e.getEntity().getType() == EntityType.PIG)) {
			if(e.getEntity().getWorld().getName().equals("arena")) {
			e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		} else {
			e.setCancelled(true);
		}
	}

}
