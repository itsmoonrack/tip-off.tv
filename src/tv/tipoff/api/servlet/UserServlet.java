package tv.tipoff.api.servlet;


import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tv.tipoff.application.model.User;
import tv.tipoff.infrastructure.DAOUser;

import com.google.appengine.labs.repackaged.org.json.JSONException;

/**
 * User resource servlet. Support basic CRUD operations. Path is /user.
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	public static final String PARAM_PSEUDO = "pseudo";
	public static final String PARAM_EMAIL = "email";

	private static final Logger log = Logger.getLogger(UserServlet.class.getName());
	private DAOUser daoUser = new DAOUser();

	/**
	 * Create User
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		User user;
		try {
			user = getUserFromParams(req);
			log.info("POST user " + user.toJSon());
			daoUser.createUser(user);
			// TODO test if user created successully (ie no duplicate or stuff)
			final boolean userCreationOK = true;

			if (userCreationOK) {
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.getWriter().println("Enregistrement réussi !");
				resp.getWriter().print("Un email à été envoyé à " + user.getEmail());
			} else {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "An Error occured");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read User
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.getWriter().print("GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		final String email = req.getParameter(PARAM_EMAIL);
//		final String pseudo = req.getParameter(PARAM_PSEUDO);
//		try {
//
//			if (email != null || pseudo != null) {
//				resp.setStatus(HttpServletResponse.SC_OK);
//				resp.setContentType("application/json");
//
//				User user;
//
//				if (email == null) {
//					user = daoUser.getUserProfile(pseudo);
//				} else {
//					user = daoUser.getUserProfileByEmail(email);
//				}
//
//				resp.setStatus(HttpServletResponse.SC_OK);
//				resp.getWriter().print(user.toJSon());
//			} else {
//				resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
//						"An Error occured");
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.info("GET user [email:" + email + ", pseudo:" + pseudo + "]");
	}

	/**
	 * Update User
	 */
	public void doPut(HttpServletRequest req, HttpServletResponse resp) {
		User user;
		try {
			user = getUserFromParams(req);
			log.info("PUT user " + user.toJSon());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Delete User
	 */
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
		User user;
		try {
			user = getUserFromParams(req);
			log.info("DELETE user " + user.toJSon());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private User getUserFromParams(HttpServletRequest req)
			throws ParseException {
		final String pseudo = req.getParameter(PARAM_PSEUDO);
		final String email = req.getParameter(PARAM_EMAIL);
		return new User(pseudo, email);
	}

}
