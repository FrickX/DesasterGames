package de.xQuixi.DesasterGames.Data;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static File file = new File("plugins/DesasterGames", "options.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void createOptions() {
		if(!file.exists()) {
		cfg.set("messages.lobbycountdown", "&8[&4DesasterGames&8] &eDas Spiel beginnt in &e(countdown) &7Sekunden.");
		cfg.set("messages.noplayers", "&8[&4DesasterGames&8] &cZu wenig Spieler online. Starte Wartemodus neu!");
		cfg.set("messages.gracetime", "&8[&4DesasterGames&8] &7Die Schutzzeit endet in &e(countdown) &7Sekunden.");
		cfg.set("messages.movecountdown", "&8[&4DesasterGames&8] &7Alle können sich in &e(countdown) &7Sekunden bewegen.");
		cfg.set("messages.startgame", "&8[&4DesasterGames&8] &7Das Spiel beginnt!");
		cfg.set("messages.endgracetime", "&8[&4DesasterGames&8] &7Die Schutzzeit ist vorbei!");
		cfg.set("messages.tornadospawn", "&8[&4DesasterGames&8] &7Ein &eTornado &7wurde gespawnt.");
		cfg.set("messages.joinplayer", "&8[&4DesasterGames&8] &e(name) &7hat das Spiel betreten!");
		cfg.set("messages.leftplayer", "&8[&4DesasterGames&8] &e(name) &7hat das Spiel verlassen!");
		cfg.set("messages.meteorspawn", "&8[&4DesasterGames&8] &7Ein Meteorit wurde ueber &e(name) &7gespawnt!");
		cfg.set("messages.winplayer", "&8[&4DesasterGames&8] &e(name) &7hat gewonnen! Der Server startet in 10 Sekunden neu!");
		cfg.set("messages.selectkit", "&8[&4DesasterGames&8] &7Du hast das Kit &e(kit) ausgewaehlt.");
		cfg.set("messages.deathfromplayer", "&8[&4DesasterGames&8] &e(opfer) &7wurde von &e(killer) &7getoetet!");
		cfg.set("messages.deathnatural", "&8[&4DesasterGames&8] &e(opfer) &7starb!");
		cfg.set("messages.track", "&8[&4DesasterGames&8] &7Der Spieler &e(name) ist &e(weite) &7Bloecke entfernt!");
		cfg.set("messages.notsee", "&8[&4DesasterGames&8] &cEs befindet sich kein Spieler in deiner naehe!");
		cfg.set("messages.notonline", "&8[&4DesasterGames&8] &cDieser Spieler ist nicht online!");
		cfg.set("messages.teleportplayer", "&8[&4DesasterGames&8] &7Du hast dich zu &e(name) &7teleportiert!");
		cfg.set("messages.serverisfull", "&8[&4DesasterGames&8] &cDer Server ist voll!");
		cfg.set("messages.statsheader", "&7Stats von &e(name)");
		cfg.set("messages.statskills", "&7Kills: &e(kills)");
		cfg.set("messages.statstode", "&7Tode: &e(tode)");
		cfg.set("messages.statsgespielt", "&7Gespielte Spiele: &e(spiele)");
		cfg.set("messages.statswins", "&7Gewonnene Spiele: &e(wins)");
		cfg.set("messages.statsquote", "&7Gewinn Quote: &e(quote)%");
		cfg.set("messages.lobbymotd", "&aLobby");
		cfg.set("messages.ingamemotd", "&4InGame");
		cfg.set("messages.regen", "&8[&4DesasterGames&8] &7Ein Gewitter erscheint... Passt auf den Regen auf!");
		cfg.set("messages.regenoff", "&8[&4DesasterGames&8] &7Der Sturm ist vorbei!");
		cfg.set("messages.eiszeit", "&8[&4DesasterGames&8] &7Es wird sehr kalt...");
		cfg.set("messages.eiszeitoff", "&8[&4DesasterGames&8] &7Die Sonne kommt zurück!");
		cfg.set("messages.deathchat", "&8[&4&lX_X&8] &7(name): &f(message)");
		cfg.set("messages.deathmatchcountdowninminuten", "&8[&4DesasterGames&8] &7Das Deathmatch beginnt in &e(countdown) &7Minuten.");
		cfg.set("messages.deathmatchcountdowninsekunden", "&8[&4DesasterGames&8] &7Das Deathmatch beginnt in &e(countdown) &7Sekunden.");
		cfg.set("messages.chesttitle", "&4DesasterGames");
		cfg.set("messages.fallbackserver", "lobby");
		cfg.set("messages.hubitemmeta", "&6Zurück zur Lobby");
		cfg.set("messages.tornadospawntoplayer", "&8[&4DesasterGames&8] &7Ein Tornado ist bei &e(name) &7erschienen!");
		cfg.set("messages.spawnmeteorfromplayer", "&8[&4DesasterGames&8] &e(fromplayer) &7beschwört ein Meteorit zu &e(toplayer)");
		cfg.set("messages.spawntornadofromplayer", "&8[&4DesasterGames&8] &e(fromplayer) &7beschwört ein Tornado zu &e(toplayer)");
		cfg.set("messages.haskit", "&aDu besitzt dieses Kit.");
		cfg.set("messages.hasnotkit", "&cDu besitzt dieses Kit nicht.");
		cfg.set("messages.spawnvulkan", "&8[&4DesasterGames&8] &7Der Vulkan ist ausgebrochen!");
		cfg.set("messages.switchplayer", "&8[&4DesasterGames&8] &7Du wurdest mit &e(name) &7getauscht.");
		cfg.set("inits.spawnmeteortime", 120);
		cfg.set("inits.switchtimeinseconds", 600);
		cfg.set("inits.mapgroesse", 200.0);
		cfg.set("inits.hubitem", 341);
		cfg.set("inits.mindplayer", 4);
		cfg.set("inits.chestid", 54);
		cfg.set("inits.trackerradius", 50.0);
		cfg.set("inits.meteoritengroesse", 4);
		cfg.set("inits.mindplayerfordeathmatch", 4);
		cfg.set("booleans.hubitemenable", false);
		cfg.set("booleans.mysql", true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
	
	
	public static String getStringFromFile(String getstring) {
		String s = cfg.getString(getstring);
		s = ChatColor.translateAlternateColorCodes('&', s);
		return s;
	}
}
