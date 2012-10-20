package tv.tipoff.api.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

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

	public void beforeSave() {
		if (created == null) {
			created = new Date();
		}
		updated = new Date();
	}

	public User(String pseudo) {
		super();
		friendsList = new ArrayList<String>();
		this.pseudo = pseudo;
		this.deleted = false;
	}

	// pseudo,birthdate,email,sex,job,city,desc)
	public User(String pseudo,String email ) {
		super();
		friendsList = new ArrayList<String>();
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