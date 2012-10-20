package tv.tipoff.services.pgep.dto;

public class Links {
	private String next_airings;
	private String same_format;
	private String same_genre;
	private String same_people;
	private String self;

	public String getNextAirings() {
		return this.next_airings;
	}

	public void setNextAirings(String next_airings) {
		this.next_airings = next_airings;
	}

	public String getSameFormat() {
		return this.same_format;
	}

	public void setSameFormat(String same_format) {
		this.same_format = same_format;
	}

	public String getSameGenre() {
		return this.same_genre;
	}

	public void setSameGenre(String same_genre) {
		this.same_genre = same_genre;
	}

	public String getSamePeople() {
		return this.same_people;
	}

	public void setSamePeople(String same_people) {
		this.same_people = same_people;
	}

	public String getSelf() {
		return this.self;
	}

	public void setSelf(String self) {
		this.self = self;
	}
}
