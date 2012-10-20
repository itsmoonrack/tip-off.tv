package tv.tipoff.services.pgep.dto;

import java.util.List;

public class Program{
   	private String _id;
   	private Links _links;
   	private Providers _providers;
   	private List awards;
   	private List cast;
   	private String censorship;
   	private List collections;
   	private String color;
   	private Country country;
   	private String date_description;
   	private Descriptions descriptions;
   	private Number duration;
   	private String event;
   	private Format format;
   	private Genre genre;
   	private String location;
   	private String name;
   	private String orchestra;
   	private String original_subtitle;
   	private String original_title;
   	private Part_of part_of;
   	private Photo photo;
   	private boolean pilot;
   	private String quality_rating;
   	private boolean silent;
   	private Sub_parts sub_parts;
   	private String subtitle;
   	private String tournament;
   	private String updated_at;
   	private String url_guide_tv;
   	private String year;

 	public String get_id(){
		return this._id;
	}
	public void set_id(String _id){
		this._id = _id;
	}
 	public Links get_links(){
		return this._links;
	}
	public void set_links(Links _links){
		this._links = _links;
	}
 	public Providers get_providers(){
		return this._providers;
	}
	public void set_providers(Providers _providers){
		this._providers = _providers;
	}
 	public List getAwards(){
		return this.awards;
	}
	public void setAwards(List awards){
		this.awards = awards;
	}
 	public List getCast(){
		return this.cast;
	}
	public void setCast(List cast){
		this.cast = cast;
	}
 	public String getCensorship(){
		return this.censorship;
	}
	public void setCensorship(String censorship){
		this.censorship = censorship;
	}
 	public List getCollections(){
		return this.collections;
	}
	public void setCollections(List collections){
		this.collections = collections;
	}
 	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color = color;
	}
 	public Country getCountry(){
		return this.country;
	}
	public void setCountry(Country country){
		this.country = country;
	}
 	public String getDate_description(){
		return this.date_description;
	}
	public void setDate_description(String date_description){
		this.date_description = date_description;
	}
 	public Descriptions getDescriptions(){
		return this.descriptions;
	}
	public void setDescriptions(Descriptions descriptions){
		this.descriptions = descriptions;
	}
 	public Number getDuration(){
		return this.duration;
	}
	public void setDuration(Number duration){
		this.duration = duration;
	}
 	public String getEvent(){
		return this.event;
	}
	public void setEvent(String event){
		this.event = event;
	}
 	public Format getFormat(){
		return this.format;
	}
	public void setFormat(Format format){
		this.format = format;
	}
 	public Genre getGenre(){
		return this.genre;
	}
	public void setGenre(Genre genre){
		this.genre = genre;
	}
 	public String getLocation(){
		return this.location;
	}
	public void setLocation(String location){
		this.location = location;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getOrchestra(){
		return this.orchestra;
	}
	public void setOrchestra(String orchestra){
		this.orchestra = orchestra;
	}
 	public String getOriginal_subtitle(){
		return this.original_subtitle;
	}
	public void setOriginal_subtitle(String original_subtitle){
		this.original_subtitle = original_subtitle;
	}
 	public String getOriginal_title(){
		return this.original_title;
	}
	public void setOriginal_title(String original_title){
		this.original_title = original_title;
	}
 	public Part_of getPart_of(){
		return this.part_of;
	}
	public void setPart_of(Part_of part_of){
		this.part_of = part_of;
	}
 	public Photo getPhoto(){
		return this.photo;
	}
	public void setPhoto(Photo photo){
		this.photo = photo;
	}
 	public boolean getPilot(){
		return this.pilot;
	}
	public void setPilot(boolean pilot){
		this.pilot = pilot;
	}
 	public String getQuality_rating(){
		return this.quality_rating;
	}
	public void setQuality_rating(String quality_rating){
		this.quality_rating = quality_rating;
	}
 	public boolean getSilent(){
		return this.silent;
	}
	public void setSilent(boolean silent){
		this.silent = silent;
	}
 	public Sub_parts getSub_parts(){
		return this.sub_parts;
	}
	public void setSub_parts(Sub_parts sub_parts){
		this.sub_parts = sub_parts;
	}
 	public String getSubtitle(){
		return this.subtitle;
	}
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}
 	public String getTournament(){
		return this.tournament;
	}
	public void setTournament(String tournament){
		this.tournament = tournament;
	}
 	public String getUpdated_at(){
		return this.updated_at;
	}
	public void setUpdated_at(String updated_at){
		this.updated_at = updated_at;
	}
 	public String getUrl_guide_tv(){
		return this.url_guide_tv;
	}
	public void setUrl_guide_tv(String url_guide_tv){
		this.url_guide_tv = url_guide_tv;
	}
 	public String getYear(){
		return this.year;
	}
	public void setYear(String year){
		this.year = year;
	}
}
