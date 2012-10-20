package tv.tipoff.services.pgep.dto;

import java.util.List;


public class Channel{
   	private String _id;
   	private Links _links;
   	private Providers _providers;
   	private String base_line;
   	private List categories;
   	private Country country;
   	private Language language;
   	private String name;
   	private List packages;
   	private String updated_at;

 	public String getId(){
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
 	public String getBase_line(){
		return this.base_line;
	}
	public void setBase_line(String base_line){
		this.base_line = base_line;
	}
 	public List getCategories(){
		return this.categories;
	}
	public void setCategories(List categories){
		this.categories = categories;
	}
 	public Country getCountry(){
		return this.country;
	}
	public void setCountry(Country country){
		this.country = country;
	}
 	public Language getLanguage(){
		return this.language;
	}
	public void setLanguage(Language language){
		this.language = language;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public List getPackages(){
		return this.packages;
	}
	public void setPackages(List packages){
		this.packages = packages;
	}
 	public String getUpdated_at(){
		return this.updated_at;
	}
	public void setUpdated_at(String updated_at){
		this.updated_at = updated_at;
	}
}
