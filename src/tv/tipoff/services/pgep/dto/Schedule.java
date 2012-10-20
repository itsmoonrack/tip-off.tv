package tv.tipoff.services.pgep.dto;

import java.util.List;

public class Schedule {
	private String _id;
	private Links _links;
	private Providers _providers;
	private Audio audio;
	private Channel channel;
	private String date;
	private boolean delayed;
	private String description;
	private Number duration;
	private String ends_at;
	private boolean first_of_cycle;
	private boolean highlight;
	private boolean last_of_cycle;
	private boolean live;
	private boolean novel_on_free_access_channels;
	private boolean novel_on_restricted_access_channels;
	private boolean novelty;
	private boolean previously_broadcast;
	private List prime_time;
	private Program program;
	private Rating rating;
	private String starts_at;
	private String strapline;
	private String subtitle;
	private boolean summary;
	private String title;
	private String updated_at;
	private String url_guide_tv;
	private Video video;

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

	public Audio getAudio() {
		return this.audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean getDelayed() {
		return this.delayed;
	}

	public void setDelayed(boolean delayed) {
		this.delayed = delayed;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Number getDuration() {
		return this.duration;
	}

	public void setDuration(Number duration) {
		this.duration = duration;
	}

	public String getEndsAt() {
		return this.ends_at;
	}

	public void setEndsAt(String ends_at) {
		this.ends_at = ends_at;
	}

	public boolean getFirstOfCycle() {
		return this.first_of_cycle;
	}

	public void setFirstOfCycle(boolean first_of_cycle) {
		this.first_of_cycle = first_of_cycle;
	}

	public boolean getHighlight() {
		return this.highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public boolean getLastOfCycle() {
		return this.last_of_cycle;
	}

	public void setLastOfCycle(boolean last_of_cycle) {
		this.last_of_cycle = last_of_cycle;
	}

	public boolean getLive() {
		return this.live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean getNovel_on_free_access_channels() {
		return this.novel_on_free_access_channels;
	}

	public void setNovel_on_free_access_channels(
			boolean novel_on_free_access_channels) {
		this.novel_on_free_access_channels = novel_on_free_access_channels;
	}

	public boolean getNovel_on_restricted_access_channels() {
		return this.novel_on_restricted_access_channels;
	}

	public void setNovel_on_restricted_access_channels(
			boolean novel_on_restricted_access_channels) {
		this.novel_on_restricted_access_channels = novel_on_restricted_access_channels;
	}

	public boolean getNovelty() {
		return this.novelty;
	}

	public void setNovelty(boolean novelty) {
		this.novelty = novelty;
	}

	public boolean getPreviouslyBroadcast() {
		return this.previously_broadcast;
	}

	public void setPreviouslyBroadcast(boolean previously_broadcast) {
		this.previously_broadcast = previously_broadcast;
	}

	public List getPrimeTime() {
		return this.prime_time;
	}

	public void setPrimeTime(List prime_time) {
		this.prime_time = prime_time;
	}

	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getStartsAt() {
		return this.starts_at;
	}

	public void setStartsAt(String starts_at) {
		this.starts_at = starts_at;
	}

	public String getStrapline() {
		return this.strapline;
	}

	public void setStrapline(String strapline) {
		this.strapline = strapline;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public boolean getSummary() {
		return this.summary;
	}

	public void setSummary(boolean summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdatedAt() {
		return this.updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUrl_guide_tv() {
		return this.url_guide_tv;
	}

	public void setUrl_guide_tv(String url_guide_tv) {
		this.url_guide_tv = url_guide_tv;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
