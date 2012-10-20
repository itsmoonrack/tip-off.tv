package tv.tipoff.services.infrastructure;

import javax.jdo.PersistenceManager;

import tv.tipoff.application.model.Program;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DAOProgram {

	PersistenceManager pm;
	
	public void createProgram(Program program) {
		Key key = KeyFactory.createKey(Program.class.getSimpleName(), program.getId());
		program.setKey(key);
	}

}
