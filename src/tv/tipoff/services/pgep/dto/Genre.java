package tv.tipoff.services.pgep.dto;

public class Genre {

	private String _id;
	private String name;
	private String parent;
	private Providers _providers;
	private String updated_at;

	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Providers getProviders() {
		return _providers;
	}

	public void setProviders(Providers _providers) {
		this._providers = _providers;
	}

	public String getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}

}
