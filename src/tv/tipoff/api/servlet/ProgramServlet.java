package tv.tipoff.api.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tv.tipoff.application.model.Program;
import tv.tipoff.application.model.Show;
import tv.tipoff.services.infrastructure.DAOProgram;

public class ProgramServlet extends HttpServlet {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_ID = "id";
	public static final String PARAM_TITLE = "title";
	public static final String PARAM_SHOW_TITLE = "show_title";
	public static final String PARAM_SHOW_START = "show_start";
	public static final String PARAM_SHOW_END = "show_end";
	public static final String PARAM_SHOW_AFFINTY = "show_affinity";
	

	private static DAOProgram daoProgram = new DAOProgram();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		Program program = getProgramFromParams(req);
		final boolean programCreationOK = true;

		if (programCreationOK) {
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().println("Enregistrement reussi !");
			resp.getWriter().print("program " + program.getTitle() + " enregistre avec succes");
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "An Error occured");
		}
	}

	private Program getProgramFromParams(HttpServletRequest req) {
		int id = 0;
		String title = req.getParameter(PARAM_TITLE);
		String showTitle = req.getParameter(PARAM_SHOW_TITLE);
		Date showStart = null;
		Date showEnd = null;
		try {
			showStart = dateFormat.parse(req.getParameter(PARAM_SHOW_START));
			showEnd = dateFormat.parse(req.getParameter(PARAM_SHOW_END));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int showAffinity = 0;
		try{
			id = Integer.getInteger(req.getParameter(PARAM_ID));
			showAffinity = Integer.getInteger(req.getParameter(PARAM_SHOW_AFFINTY));
		} catch( Exception e){ }
		Show show = new Show(showTitle,showStart,showEnd, showAffinity);
		return new Program(id,title,show);
	}
	

}
