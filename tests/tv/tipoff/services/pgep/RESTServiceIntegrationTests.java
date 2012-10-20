package tv.tipoff.services.pgep;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;
import tv.tipoff.services.pgep.dto.Schedule;

public class RESTServiceIntegrationTests {
	
	protected PGEPService service;

	@Before
	public void setUp() throws Exception {
		service = new RESTService();
	}

	@Test
	public void testGetProgramId() {
		Program program = service.getProgram("4f7f112fbb94787338004d62");
		assertEquals("Found program by ID.", "4f7f112fbb94787338004d62", program.getId());
		assertEquals("Ratz", program.getName());
		assertEquals("http://pgep.francetv.fr/images/plurimedia/EMI/49/EMI_49591.jpg", program.getPhoto().get("700x394"));
	}
	
	@Test
	public void testGetPrograms() {
		List<Program> programs = service.getPrograms();
		for (Program program : programs) {
			if (program == null) {
				Assert.fail("A program was null.");
			}
		}
		Assert.assertFalse(programs.size() + " programs was found.", programs.size() == 0);
	}
	
	@Test
	public void testGetChannels() {
		List<Channel> channels = service.getChannels();
		for (Channel channel : channels) {
			if (channel == null) {
				Assert.fail("A channel was null.");
			}
		}
		Assert.assertFalse(channels.size() + " channels was found.", channels.size() == 0);
	}

	@Test
	public void testGetChannelId() {
		Channel channel = service.getChannel("4f7f115abb947873380064a1");
		assertEquals("Found program by ID.", "4f7f115abb947873380064a1", channel.getId());
		assertEquals("M6", channel.getName());
	}
	
	@Test
	public void testGetBroadcasts() {
		List<Broadcast> broadcasts = service.getBroadcasts();
		for (Broadcast broadcast : broadcasts) {
			if (broadcast == null) {
				Assert.fail("A broadcast was null.");
			}
		}
		Assert.assertFalse(broadcasts.size() + " broadcasts was found.", broadcasts.size() == 0);
	}
	
	@Test
	public void testGetBroadcastsByDate() {
		service.setLimit(40);
		List<Broadcast> broadcasts = service.getBroadcasts(new Date());
		for (Broadcast broadcast : broadcasts) {
			if (broadcast == null) {
				Assert.fail("A broadcast was null.");
			}
		}
		Assert.assertFalse(broadcasts.size() + " broadcasts was found.", broadcasts.size() == 0);
	}

	@Test
	public void testGetBroadcastId() {
		Broadcast broadcast = service.getBroadcast("506eb55cbb947870770023d8");
		assertEquals("Found broadcast by ID.", "506eb55cbb947870770023d8", broadcast.getId());
		assertEquals("Programme national", broadcast.getTitle());
	}
	
	@Test
	public void testGetSchedule() {
		List<Schedule> schedules = service.getSchedule();
		for (Schedule schedule : schedules) {
			if (schedule == null) {
				Assert.fail("A broadcast was null.");
			}
		}
		Assert.assertFalse(schedules.size() + " schedules was found.", schedules.size() == 0);
	}
}
