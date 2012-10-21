package tv.tipoff.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import tv.tipoff.infrastructure.DAOProgram;
import tv.tipoff.infrastructure.PersistHooks;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@PersistenceCapable
public class User implements PersistHooks {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	// Public
	@Persistent private String pseudo;
	@Persistent private String password;
	// private
	@Persistent private String email;
	
	@Persistent private List<String> friendsList;
	@Persistent private Date created;
	@Persistent private Date updated;
	@Persistent private boolean deleted;

	@Persistent private Set<String> hasSeen; // list of programs seen by the user 
	private DAOProgram daoProgram = new DAOProgram();
		
	public void beforeSave() {
		if (created == null) {
			created = new Date();
		}
		updated = new Date();
	}

	public User(String pseudo) {
		super();
		this.friendsList = new ArrayList<String>();
		this.hasSeen = new HashSet<String>();
		this.pseudo = pseudo;
		this.deleted = false;
	}

	// pseudo,birthdate,email,sex,job,city,desc)
	public User(String pseudo, String email) {
		super();
		this.friendsList = new ArrayList<String>();
		this.hasSeen = new HashSet<String>();
		this.pseudo = pseudo;
		this.email = email;

		this.deleted = false;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getFriendsList() {
		return friendsList;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFriendsList(List<String> friendsList) {
		this.friendsList = friendsList;
	}

	public Date getUpdated() {
		return updated;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
	}
	
	public void setHasSeen(Set<String> list) {
		this.hasSeen = list;
	}
	
	/**
	 * Ajoute une émission à la liste des "Vues" pour l'utilisateur.
	 * 
	 * @param programId
	 *   Une ID d'emission valide.
	 * @return
	 *   true si l'ID n'était pas déjà existante.
	 */
	public boolean addHasSeen(String programId) {
		return this.hasSeen.add(programId);
	}
	
	
	public List<Program> hasSeen(){
		List<Program> programs = new ArrayList<Program>();
		for (String  id : hasSeen){
			Program pro = daoProgram.getProgram(id);
			programs.add(pro);
		}
		return programs;	
	}
	
	

	/**
	 * ajout d'un contact dans la liste, si il n'y est pas déjà
	 * 
	 * @param pseudo
	 */
	public void addFriendship(String pseudo) {
		assert pseudo != null : "pseudo1 null";
		assert pseudo.equals("") : "pseudo1 vide";
		int i;
		boolean friendshipExists = false;

		for (i = 0; i < friendsList.size(); i++) {
			if (friendsList.get(i).equals(pseudo)) {
				friendshipExists = true;
				System.err.println("The friendship already exists!");
				break;
			}
		}
		if (!friendshipExists) {
			friendsList.add(pseudo);
		}
	}

	public void deleteFriendship(String pseudo) {
		int i;
		for (i = 0; i < friendsList.size(); i++) {
			if (friendsList.get(i).equals(pseudo)) {
				break;
			}
		}
		friendsList.remove(i);
	}

	public JSONObject toJSon() throws JSONException {
		JSONObject json = toJSonLight();

		json.put("pseudo", pseudo);

		return json;
	}

	public JSONObject toJSonLight() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("pseudo", pseudo);
		json.put("email", email);

		if (isDeleted()) {
			json.put("deleted", deleted);
		}

		return json;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}