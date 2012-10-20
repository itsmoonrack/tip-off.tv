package tv.tipoff.api.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tv.tipoff.application.model.Program;
import tv.tipoff.infrastructure.DAOProgram;
import tv.tipoff.services.pgep.RESTService;
import tv.tipoff.services.pgep.dto.Broadcast;

import com.google.gson.Gson;

public class ProgramServlet extends HttpServlet {
	private static final String PHOTO_SIZE = "175x99";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_ID = "id";
	public static final String PARAM_TITLE = "title";
	public static final String PARAM_IMG_URL = "img_url";
	public static final String PARAM_SHOW_TITLE = "show_title";
	public static final String PARAM_SHOW_START = "show_start";
	public static final String PARAM_SHOW_END = "show_end";
	public static final String PARAM_SHOW_AFFINTY = "show_affinity";
	
	public static final String ACTION_ALL = "/all";
	public static final String ACTION_NOW = "/now";
	
	private static RESTService pluzzService ;
	
	@Override
	public void init() throws ServletException {
		pluzzService = new RESTService();
	}
	
	Gson gson = new Gson();

	private static DAOProgram daoProgram = new DAOProgram();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getPathInfo();
		switch (path) {
		case ACTION_ALL:
			getAllPrograms(req, resp);
			break;
		case ACTION_NOW:
			getNow(req, resp);
			break;
		default:
			break;
		}
	}

	private void getNow(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("utf-8");
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("{\"diffusion\":[");
			List<tv.tipoff.services.pgep.dto.Program> programs = pluzzService.getPrograms();
			if ( programs !=null){
				int size = programs.size(),
						i = 1;
				for (tv.tipoff.services.pgep.dto.Program program : programs){
					Program prog = serviceToModel(program);
					if (size != i++){
						builder.append(prog.toJSON() +",");
					} else {
						builder.append(prog.toJSON());
					}
				}
				builder.append("]}");
				resp.getWriter().print(builder);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Program serviceToModel(tv.tipoff.services.pgep.dto.Program program) {
		Broadcast broadcast = pluzzService.getBroadcast(program.getId());
		Program programModel = new Program();
		int id = 0;
		Date start = null;
		Date end = null;
		try{
			if (broadcast != null){
				start = DATE_FORMAT.parse( broadcast.getStartsAt());
				end = DATE_FORMAT.parse( broadcast.getEndsAt());
			}
		} catch(Exception e){}
		programModel.setId( program.getId());
		programModel.setTitle(program.getName());
		programModel.setImageURL(program.getPhoto().get(PHOTO_SIZE));
		programModel.setShowTitle(program.getName());
		programModel.setShowStart(start);
		programModel.setShowEnd(end);
		programModel.setShowAffinity(0);
		
		return programModel;
	}

	private void getAllPrograms(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("utf-8");
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("{\"diffusion\":[");
			int size = daoProgram.getAllPrograms().size(),
				i = 1;
			for (Program program : daoProgram.getAllPrograms()){
				if (size != i++){
					builder.append(program.toJSON() +",");
				} else {
					builder.append(program.toJSON());
				}
			}
			builder.append("]}");
			resp.getWriter().print(builder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Program program = getProgramFromParams(req);
		final boolean programCreationOK = true;
		daoProgram.createProgram(program);

		if (programCreationOK) {
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().println("Enregistrement reussi !");
			resp.getWriter().print("program " + program.getTitle() + " enregistre avec succes");
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "An Error occured");
		}
	}

	private Program getProgramFromParams(HttpServletRequest req) {
		String id = req.getParameter(PARAM_ID);
		String title = req.getParameter(PARAM_TITLE);
		String imageUrl = req.getParameter(PARAM_IMG_URL);
		String showTitle = req.getParameter(PARAM_SHOW_TITLE);
		Date showStart = null;
		Date showEnd = null;
		try {
			showStart = DATE_FORMAT.parse(req.getParameter(PARAM_SHOW_START));
			showEnd = DATE_FORMAT.parse(req.getParameter(PARAM_SHOW_END));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int showAffinity = 0;
		try{
			String rawaffinity = req.getParameter(PARAM_SHOW_AFFINTY);
			showAffinity = Integer.parseInt(rawaffinity);
		} catch( Exception e){ }
		return new Program(id,title,imageUrl, showTitle,showStart,showEnd, showAffinity);
	}
	

}
