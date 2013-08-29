package yossi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VisitorCounter
 */
@WebServlet("/VisitorCounter")
public class VisitorCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int count;
	private FileDao dao;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dao = new FileDao();
	    try {
	      count = dao.getCount();
	    } catch (Exception e) {
	      getServletContext().log("An exception occurred in FileCounter", e);
	      throw new ServletException("An exception occurred in FileCounter"
	          + e.getMessage());
	    }
	    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
	    try {
	      dao.save(count);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Set a cookie for the user, so that the counter does not increate
	    // every time the user press refresh
	    HttpSession session = request.getSession(true);
	    // Set the session valid for 5 secs
	    session.setMaxInactiveInterval(5);
	    response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    if (session.isNew()) {
	      count++;
	    }
	    out.println("This site has been accessed " + count + " times.");
	}

}
