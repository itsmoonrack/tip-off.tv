package tv.tipoff.services.infrastructure;

import com.google.appengine.api.users.User;

public interface IDAO {

	/**
	 * USERS
	 */
	void putUser(User user);
	User getUser(int id);
	User getUser(String nickname, String password);
	void deleteUser(String nickname);
	
	
	
}
