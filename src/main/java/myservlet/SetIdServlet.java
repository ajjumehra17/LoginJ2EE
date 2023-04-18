package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeleteBean;
import beans.RegisterBean;
import beans.SetIdBean;
import dao.StudentDAO;

 
@WebServlet("/setid")
public class SetIdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	out.print("<html><body>");
	int id = Integer.parseInt(request.getParameter("userid"));
	SetIdBean sid = new SetIdBean();
	sid.setUserid(id);
	
	
	StudentDAO dao = new StudentDAO();
	RegisterBean rb = dao.getById(sid);
	if(rb!=null) {
		HttpSession session  = request.getSession();
		session.setAttribute("rbean", rb);
		RequestDispatcher rd = request.getRequestDispatcher("/edit");
		 try {
	     	 rd.forward(request, response);
			
		} catch (Exception e) {
			 e.printStackTrace();
		} 
	 }
	 else {
		 
		 out.print("<h1>User-id Invalid  </h1>");
		 RequestDispatcher rd = request.getRequestDispatcher("/update.html");
		 try {
			 rd.include(request, response);
			
		} catch (Exception e) {
			 e.printStackTrace();
		} 
		 
	 }
		 
	 out.print("</body></html>");
    
  }

}
