package tv.tipoff.application.model;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	private String title;
	private Show show;
	private List<User> hasBeenSeenBy;
	
	public Program(){
		hasBeenSeenBy = new ArrayList<User>();
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
	
	
	

}
