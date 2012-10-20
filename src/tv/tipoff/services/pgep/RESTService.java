package tv.tipoff.services.pgep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;
import tv.tipoff.services.pgep.dto.Results;
import tv.tipoff.services.pgep.dto.Schedule;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RESTService implements PGEPService {

	final Gson gson;
	final String host;
	final String scheme;
	final HttpClient client;
	
	int limit;
	
	public RESTService() {
		this.gson = new Gson();
		this.host = "pgep.francetv.fr";
		this.limit = 200;
		this.scheme = "http";
		this.client = new DefaultHttpClient();
	}

	@Override
	public Program getProgram(String id) {
		URIBuilder builder = newURIBuilder().setPath("/programs/" + id);

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Program>>() {
			}.getType();
			Results<Program> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults().get(0);

		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public String getProgramJSON(String id) {
		URIBuilder builder = newURIBuilder().setPath("/programs/" + id);
		
		try {
			InputStream stream = request(builder.build());
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line="";
			StringWriter writer = new StringWriter();
			while ((line=buffer.readLine()) != null){
				writer.write(line); 
			}
			return writer.toString();
				
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Program> getPrograms() {
		URIBuilder builder = newURIBuilder().setPath("/programs");

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Program>>() {
			}.getType();
			Results<Program> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults();

		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Channel getChannel(String id) {
		URIBuilder builder = newURIBuilder().setPath("/channels/" + id);

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Channel>>() {
			}.getType();
			Results<Channel> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults().get(0);

		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Channel> getChannels() {
		URIBuilder builder = newURIBuilder().setPath("/channels");

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Channel>>() {
			}.getType();
			Results<Channel> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults();

		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Broadcast> getBroadcasts() {
		URIBuilder builder = newURIBuilder().setPath("/broadcasts");

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Broadcast>>() {
			}.getType();
			Results<Broadcast> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults();
				
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Broadcast> getBroadcasts(Date to) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
		URIBuilder builder = newURIBuilder().setPath("/broadcasts")
				.setParameter("to", formatter.format(to));

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Broadcast>>() {
			}.getType();
			Results<Broadcast> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults();
				
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Broadcast getBroadcast(String id) {
		URIBuilder builder = newURIBuilder().setPath("/broadcasts/" + id);

		try {
			InputStream stream = request(builder.build());
			Type type = new TypeToken<Results<Broadcast>>() {
			}.getType();
			Results<Broadcast> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults().get(0);

		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Schedule> getSchedule() {
		URIBuilder builder = newURIBuilder().setPath("/schedule");
		
		try {
			InputStream stream = request(builder.build());
			
			Type type = new TypeToken<Results<Schedule>>() {
			}.getType();
			Results<Schedule> results = gson.fromJson(new InputStreamReader(stream), type);
			return results.getResults();
			
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	protected URIBuilder newURIBuilder() {
		return new URIBuilder().setScheme(scheme).setHost(host)
				.setParameter("limit", String.valueOf(limit))
				.setParameter("format", "json");
	}
	
	protected InputStream request(URI uri) {
		HttpGet request = new HttpGet(uri);
		HttpResponse response;
		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();
			
			return entity.getContent();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
