package de.xQuixi.DesasterGames.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import de.xQuixi.DesasterGames.Data.ConfigManager;
import de.xQuixi.DesasterGames.Data.Data;

public class SwitchListener
  implements Listener
{

  @SuppressWarnings("deprecation")
@EventHandler
  public void onUsingSwitcher(ProjectileHitEvent e)
  {
    Projectile pro = e.getEntity();
    if (((pro.getShooter() instanceof Player)) && 
      ((pro instanceof Snowball))) {
      Snowball ball = (Snowball)pro;
      Player change = null;
      for (Entity en : ball.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
        if (((en instanceof Player)) && 
          (Data.players.contains(((Player)en).getName()))) {
          change = (Player)en;
          break;
        }
      }

      if (change != null)
      {
        Player p = (Player)pro.getShooter();
        Location loc1 = p.getLocation();
        Location loc2 = change.getLocation();
        p.teleport(loc2);
        change.teleport(loc1);
        String message = ConfigManager.cfg.getString("messages.switchplayer");
        message = ChatColor.translateAlternateColorCodes('&', message);
        message = message.replace("(name)", p.getName());
        change.sendMessage(message);
        message = message.replace("(name)", change.getName());
        p.sendMessage(message);
      }
    }
  }
}