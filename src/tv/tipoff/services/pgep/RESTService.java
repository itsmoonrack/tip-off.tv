package tv.tipoff.services.pgep;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;

public class RESTService implements PGEPService {
	
	final String host;
	final String scheme;
	final HttpClient client;
	
	public RESTService() {
		this.host = "pgep.francetv.fr";
		this.scheme = "http";
		this.client = new DefaultHttpClient();
	}

	@Override
	public Program getProgram(String id) {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme)
			.setHost(host)
			.setPath("/programs/" + id)
			.setParameter("format", "json");
		URI uri;
		
		try {
			uri = builder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		HttpGet request = new HttpGet(uri);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Program> getPrograms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Channel getChannel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> getChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Broadcast> getBroadcasts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Broadcast getBroadcast(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
