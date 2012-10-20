package tv.tipoff.services.pgep;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tv.tipoff.services.pgep.dto.Program;

public class RESTServiceIntegrationTests {
	
	protected PGEPService service;

	@Before
	public void setUp() throws Exception {
		service = new RESTService();
	}

	@Test
	public void testGetProgram() {
		Program program = service.getProgram("4f7f112fbb94787338004d62");
		assertEquals("Found program by ID.", "4f7f112fbb94787338004d62", program.getId());
	}

}
