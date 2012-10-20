package tv.tipoff.services.pgep;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
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
	public void testGetProgramId() {
		Program program = service.getProgram("4f7f112fbb94787338004d62");
		assertEquals("Found program by ID.", "4f7f112fbb94787338004d62", program.getId());
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

}
