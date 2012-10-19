package tv.tipoff.api;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TipOff_TVServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/plain");
		resp.getWriter().println("tip-off.tv");
		// Test
		
		
	}
	
}
