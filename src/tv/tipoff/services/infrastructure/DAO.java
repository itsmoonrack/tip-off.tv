package tv.tipoff.services.infrastructure;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityManager;

import com.google.appengine.api.users.User;

public class DAO implements IDAO{

	static EntityManager em = EMF.get().createEntityManager();
	PersistenceManager pm = PMF.get().getPersistenceManager();


	@Override
	public void putUser(User user) {
		pm.makePersistent(user);
	}

	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public User getUser(String nickname, String password) {
		return pm.;
	}

	@Override
	public void deleteUser(String nickname) {
		
	}

}
