package tv.tipoff.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import tv.tipoff.services.infrastructure.PersistHooks;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Show  implements PersistHooks {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent private String title;
	@Persistent private Date start;
	@Persistent private Date end;
	@Persistent private int affinity;
	
	private List<Program> hasSeen;
	
	public Show(String title, Date start, Date end, int affinity) {
		super();
		hasSeen = new ArrayList<Program>();
		this.title = title;
		this.start = start;
		this.end = end;
		this.affinity = affinity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getAffinity() {
		return affinity;
	}
	public void setAffinity(int affinity) {
		this.affinity = affinity;
	}
	public List<Program> getHasSeen() {
		return hasSeen;
	}
	public void addHasSeen(Program program){
		hasSeen.add(program);
	}
	@Override
	public void beforeSave() { }
	
	
	
}
