package tv.tipoff.services.pgep.dto;

import java.util.List;

public class Channel {
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

	public String getId() {
		return this._id;
	}

	public void setId(String _id) {
		this._id = _id;
	}

	public Links getLinks() {
		return this._links;
	}

	public void setLinks(Links _links) {
		this._links = _links;
	}

	public Providers getProviders() {
		return this._providers;
	}

	public void setProviders(Providers _providers) {
		this._providers = _providers;
	}

	public String getBaseLine() {
		return this.base_line;
	}

	public void setBaseLine(String base_line) {
		this.base_line = base_line;
	}

	public List getCategories() {
		return this.categories;
	}

	public void setCategories(List categories) {
		this.categories = categories;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getPackages() {
		return this.packages;
	}

	public void setPackages(List packages) {
		this.packages = packages;
	}

	public String getUpdatedAt() {
		return this.updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}
}
