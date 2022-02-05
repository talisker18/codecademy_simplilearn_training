package AAI_data_and_database.database.hibernate_jdbc.hibernate;

/*
 * 
 * see also github: these projects use a hibernate.cfg.xml where you define the mapped class (with annotations) or mapped hbm.xml file
 * 
 * xml mapping (hbm.xml files)
 * 		https://github.com/talisker18/Day8MavenProjectWithHibernateXMLMapping
 * 		with relation mapping: https://github.com/talisker18/Day9HibernateXMLMappingMaven
 * annotation mapping (class and instance var are annotated): 
 * 		with relation mapping: https://github.com/talisker18/Day8NormalProjectWithHibernateAnnotationMapping
 * 
 * */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Player {
	@Id
	//use following to auto generate and increment id primary key
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	
	public Player() {
	}
	
	public Player(int playerId, String playerName) {
		this.playerId = playerId;
		this.playerName = playerName;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
}
