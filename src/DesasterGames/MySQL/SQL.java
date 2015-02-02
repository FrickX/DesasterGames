package de.xQuixi.DesasterGames.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.event.Listener;

import de.xQuixi.DesasterGames.Main;


	public class SQL implements Listener {
	
	private Main plugin;
	
	public SQL(Main plugin){
		this.plugin=plugin;
		
		MySQL sql = this.plugin.getSql();
		sql.queryUpdate("CREATE TABLE IF NOT EXISTS kills ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , kills VARCHAR(100))");
		sql.queryUpdate("CREATE TABLE IF NOT EXISTS tode ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , tode VARCHAR(100))");
		sql.queryUpdate("CREATE TABLE IF NOT EXISTS wins ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , wins VARCHAR(100))");
		sql.queryUpdate("CREATE TABLE IF NOT EXISTS spiele ( id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(40) , spiele VARCHAR(100))");
	}
	
    public List<String> getPlayersRankingStats(){
        try{
            Connection con = plugin.getSql().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT name, kills FROM kills ORDER BY kills DESC Limit 10");
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.close();
            st.close();

            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
	
	public void setStats(UUID p) {
		if(getTode(p) == null && (getKills(p) == null && (getWins(p) == null && (getSpiele(p) == null)))) {
			addKill(p, 0);
			addTod(p, 0);
			addWin(p, 0);
			addSpiel(p, 0);
		}
	}
	
	//------------------------< TODE MYSQL >--------------------------------
	
		public int getPTode(UUID player){
			if(!(this.getTode(player) == null)){
				return Integer.valueOf(this.getTode(player));
			}
			return 0;
		}
		
		public String getTode(UUID player){
			
			MySQL sql = this.plugin.getSql();
			Connection conn = sql.getConnection();
			ResultSet rs = null;
			PreparedStatement state = null;
			String tokens = null;
			try {
				state = conn.prepareStatement("SELECT * FROM tode WHERE name = ?");
				state.setString(1, String.valueOf(player));
				rs = state.executeQuery();
				rs.last();
				if(rs.getRow() != 0){
					rs.first();
					tokens = rs.getString("tode");
				} 
			} catch (SQLException e) {
			} finally {
				sql.closeRessources(rs, state);
			}
			return tokens;
		}
		
		 
		public void addTod(UUID player, int points){
			this.setTode(player, String.valueOf(this.getPTode(player) + points));
		}
		public void setTode(UUID player, String points){
			MySQL sql = this.plugin.getSql();
			
			if(this.getTode(player) != null){
				sql.queryUpdate("UPDATE tode SET tode='" + points +"' WHERE name='" + player + "'");
			} else {
				sql.queryUpdate("INSERT INTO tode(name, tode) VALUES ('"+ player + "', '" + points + "')");
			}
		}
		
		//------------------------< KILLS MYSQL >--------------------------------
		
			public int getPKills(UUID player){
				if(!(this.getKills(player) == null)){
					return Integer.valueOf(this.getKills(player));
				}
				return 0;
			}
			
			public String getKills(UUID player){
				
				MySQL sql = this.plugin.getSql();
				Connection conn = sql.getConnection();
				ResultSet rs = null;
				PreparedStatement state = null;
				String tokens = null;
				try {
					state = conn.prepareStatement("SELECT * FROM kills WHERE name = ?");
					state.setString(1, String.valueOf(player));
					rs = state.executeQuery();
					rs.last();
					if(rs.getRow() != 0){
						rs.first();
						tokens = rs.getString("kills");
					} 
				} catch (SQLException e) {
				} finally {
					sql.closeRessources(rs, state);
				}
				return tokens;
			}
			
			 
			public void addKill(UUID player, int points){
				this.setKills(player, String.valueOf(this.getPKills(player) + points));
			}
			public void setKills(UUID player, String points){
				MySQL sql = this.plugin.getSql();
				
				if(this.getKills(player) != null){
					sql.queryUpdate("UPDATE kills SET kills='" + points +"' WHERE name='" + player + "'");
				} else {
					sql.queryUpdate("INSERT INTO kills(name, kills) VALUES ('"+ player + "', '" + points + "')");
				}
			}
			
			//------------------------< WINS MYSQL >--------------------------------
			
			public int getPWins(UUID player){
				if(!(this.getWins(player) == null)){
					return Integer.valueOf(this.getWins(player));
				}
				return 0;
			}
			
			public String getWins(UUID player){
				
				MySQL sql = this.plugin.getSql();
				Connection conn = sql.getConnection();
				ResultSet rs = null;
				PreparedStatement state = null;
				String tokens = null;
				try {
					state = conn.prepareStatement("SELECT * FROM wins WHERE name = ?");
					state.setString(1, String.valueOf(player));
					rs = state.executeQuery();
					rs.last();
					if(rs.getRow() != 0){
						rs.first();
						tokens = rs.getString("wins");
					} 
				} catch (SQLException e) {
				} finally {
					sql.closeRessources(rs, state);
				}
				return tokens;
			}
			
			 
			public void addWin(UUID player, int points){
				this.setWins(player, String.valueOf(this.getPWins(player) + points));
			}
			public void setWins(UUID player, String points){
				MySQL sql = this.plugin.getSql();
				
				if(this.getWins(player) != null){
					sql.queryUpdate("UPDATE wins SET wins='" + points +"' WHERE name='" + player + "'");
				} else {
					sql.queryUpdate("INSERT INTO wins(name, wins) VALUES ('"+ player + "', '" + points + "')");
				}
			}
			
			//------------------------< SPIELE MYSQL >--------------------------------
			
			public int getPSpiele(UUID player){
				if(!(this.getSpiele(player) == null)){
					return Integer.valueOf(this.getSpiele(player));
				}
				return 0;
			}

			
			public String getSpiele(UUID player){
				
				MySQL sql = this.plugin.getSql();
				Connection conn = sql.getConnection();
				ResultSet rs = null;
				PreparedStatement state = null;
				String tokens = null;
				try {
					state = conn.prepareStatement("SELECT * FROM spiele WHERE name = ?");
					state.setString(1, String.valueOf(player));
					rs = state.executeQuery();
					rs.last();
					if(rs.getRow() != 0){
						rs.first();
						tokens = rs.getString("spiele");
					} 
				} catch (SQLException e) {
				} finally {
					sql.closeRessources(rs, state);
				}
				return tokens;
			}
			
			 
			public void addSpiel(UUID player, int points){
				this.setSpiel(player, String.valueOf(this.getPSpiele(player) + points));
			}
			public void setSpiel(UUID player, String points){
				MySQL sql = this.plugin.getSql();
				
				if(this.getSpiele(player) != null){
					sql.queryUpdate("UPDATE spiele SET spiele='" + points +"' WHERE name='" + player + "'");
				} else {
					sql.queryUpdate("INSERT INTO spiele(name, spiele) VALUES ('"+ player + "', '" + points + "')");
				}
			}

		
}
