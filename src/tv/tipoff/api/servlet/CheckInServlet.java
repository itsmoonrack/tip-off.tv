package tv.tipoff.api.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tv.tipoff.application.model.User;
import tv.tipoff.infrastructure.DAOUser;
import tv.tipoff.services.pgep.PGEPService;
import tv.tipoff.services.pgep.RESTService;
import tv.tipoff.services.pgep.dto.Program;

/**
 * Servlet de check-in. Le chemin est /checkin.
 */
public class CheckInServlet extends HttpServlet {
	public static final String PARAM_PSEUDO = "pseudo";
	public static final String PARAM_PROGRAM_ID = "program_id";
	
	private static final long serialVersionUID = 1L;

	private DAOUser daoUser = new DAOUser();
	private PGEPService pluzz = new RESTService();
	
	/**
	 * Enregistre son check-in !
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final String pseudo = req.getParameter(PARAM_PSEUDO);
		final String programId = req.getParameter(PARAM_PROGRAM_ID);
		
		// Vérifie l'existence des paramètres.
		if (pseudo == null || programId == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad Request");
			return;
		}
		
		// Vérifie la validité de l'utilisateur.
		User user = daoUser.getUserProfile(pseudo);
		if (user == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found");
			return;
		}
		
		// Vérifie la validité de la diffusion.
		Program program = pluzz.getProgram(programId);
		if (program == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Program Not Found");
			return;
		}
		
		if (user.addHasSeen(program.getId())) {
			daoUser.updateUser(user);
			resp.setStatus(HttpServletResponse.SC_CREATED);
		}
		else {
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		}
	}

}
