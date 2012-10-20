package tv.tipoff.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import tv.tipoff.api.servlet.ProgramServlet;
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
	
	@Persistent private String showTitle;
	@Persistent private Date showStart;
	@Persistent private Date showEnd;
	@Persistent private int showAffinity;
	
	@Persistent private List<User> hasBeenSeenBy;
	
	public Program(){
		hasBeenSeenBy = new ArrayList<User>();
	}
	
	public Program(int id, String title, String imageURL, 
			String showTitle, Date showStart, Date showEnd, int showAffinity) {
		super();
		this.id = id;
		this.title = title;
		this.imageURL = imageURL;

		this.showTitle = showTitle;
		this.showStart = showStart;
		this.showEnd = showEnd;
		this.showAffinity = showAffinity;
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
	
	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public Date getShowStart() {
		return showStart;
	}

	public void setShowStart(Date showStart) {
		this.showStart = showStart;
	}

	public Date getShowEnd() {
		return showEnd;
	}

	public void setShowEnd(Date showEnd) {
		this.showEnd = showEnd;
	}

	public int getShowAffinity() {
		return showAffinity;
	}

	public void setShowAffinity(int showAffinity) {
		this.showAffinity = showAffinity;
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
	
	
	public String toJSON(){
		StringBuffer builder = new StringBuffer();
		builder.append("{");
		builder.append("\"channel\": \""+ this.title +"\",");
		builder.append("\"photo\": \""+ this.imageURL  +"\"");
			builder.append(",\"show\": {");
				builder.append("\"title\": \""+  this.showTitle +"\"");
				if (this.showStart != null){
					builder.append(",\"start\": \""+ ProgramServlet.DATE_FORMAT.format(this.showStart)  +"\"");
				}
				if (this.showEnd != null){
					builder.append(",\"end\": \""+ ProgramServlet.DATE_FORMAT.format(this.showEnd)  +"\"");
				}
				builder.append(",\"affinity\": \""+ this.showAffinity  +"\"");
			builder.append("}");
		builder.append("}");
		
		return builder.toString();
	}
	
	

}
