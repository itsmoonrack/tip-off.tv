package tv.tipoff.infrastructure;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import tv.tipoff.application.model.Program;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DAOProgram {

	PersistenceManager pm;

	public void createProgram(Program program) {
		Key key = KeyFactory.createKey(Program.class.getSimpleName(), program.getId());
		program.setKey(key);

		pm = PMF.getPersistenceManager();
		try {
			pm.makePersistent(program);
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Program> getAllPrograms() {
		List<Program> programs  = null;

		pm = PMF.getPersistenceManager();
		try {
			Query query = pm.newQuery(Program.class);
			programs = (List<Program>) query.execute();
		} finally {
			pm.close();
		}
		return programs;
	}

	/**..
	 * Get program by id
	 * @param String id 
	 * @return program
	 */
	public Program getProgram(String id) {
		Key key = KeyFactory.createKey(Program.class.getSimpleName(), id);
		try {
			return pm.getObjectById(Program.class, key);
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}
}
