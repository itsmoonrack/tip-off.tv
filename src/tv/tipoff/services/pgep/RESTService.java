package tv.tipoff.services.pgep;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;
import tv.tipoff.services.pgep.dto.Results;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RESTService implements PGEPService {
	
	final Gson gson;
	final String host;
	final String scheme;
	final HttpClient client;
	
	public RESTService() {
		this.gson = new Gson();
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
		
		try {
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				InputStream stream = entity.getContent();
				InputStreamReader reader = new InputStreamReader(stream);
				Type type = new TypeToken<Results<Program>>() {}.getType();
				Results<Program> results = gson.fromJson(reader, type);
				return results.getResults().get(0);
				
			}
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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