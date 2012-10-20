package tv.tipoff.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import tv.tipoff.infrastructure.PersistHooks;


import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Program implements PersistHooks {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent private int id;
	@Persistent private String title;
	@Persistent private String imageURL;
	@Persistent private Show show;
	@Persistent private List<User> hasBeenSeenBy;
	
	public Program(){
		hasBeenSeenBy = new ArrayList<User>();
	}
	
	public Program(int id, String title, String imageURL, Show show) {
		super();
		this.id = id;
		this.title = title;
		this.imageURL = imageURL;
		this.show = show;
	}
	
	public int getId() {
		return id;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public List<User> getHasBeenSeenBy() {
		return hasBeenSeenBy;
	}
	public void setHasBeenSeenBy(List<User> hasBeenSeenBy) {
		this.hasBeenSeenBy = hasBeenSeenBy;
	}
	public void addHasBeenSeenBy(User user) {
		this.hasBeenSeenBy.add(user);
	}

	@Override
	public void beforeSave() { }
	
	
	

}
