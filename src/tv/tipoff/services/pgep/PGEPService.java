package tv.tipoff.services.pgep;

import java.util.List;

import tv.tipoff.services.pgep.model.Channel;
import tv.tipoff.services.pgep.model.Program;

/**
 * Class de communication avec l'API Pluzz.
 * 
 * @author Sylvain
 *
 */
public interface PGEPService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Program getProgram(int id);
	public List<Program> getPrograms();
	
	public Channel getChannel(int id);

}
