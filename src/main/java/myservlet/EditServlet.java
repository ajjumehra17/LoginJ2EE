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

import beans.RegisterBean;
import beans.SetIdBean;
import dao.StudentDAO;

 
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		out.print("<html><body>");
		HttpSession session  = request.getSession(false);
		RegisterBean rb = (RegisterBean)session.getAttribute("rbean");
		out.print("<form action='update' method='post'>");
	    out.print("<label>User-ID</label>");
	    out.print("<input type='text' name='userid' value='"+rb.getId()+"'><br>");
	    out.print("<label>Name</label>");
	    out.print("<input type='text' name='name' value='"+rb.getName()+"' ><br>");
	    out.print("<label>Email</label>");
	    out.print("<input type='text' name='email' value='"+rb.getEmail()+"'><br>");
	    out.print(" <label>Address</label>");
	    out.print("<input type='text' name='address' value='"+rb.getAddress()+"'><br>");
	    out.print("<label>DOB</label>");
	    out.print("<input type='text' name='dob'value='"+rb.getDob()+"'><br>");
	    out.print("<label>MobNo.</label>");
	    out.print("<input type='text' name='mobno'value='"+rb.getMobno()+"' ><br>");
	    out.print(" <label>Marks</label>");
	    out.print("<input type='text' name='marks' value='"+rb.getMarks()+"'><br>");
	    out.print("<label>Gender</label>");
	    out.print("<input type='radio' value='Male' name='gender' checked='checked'  >");
	    	 
	    out.print("<input type='radio' value='Female' name='gender' ><br>");
	       
	    out.print("<input type='submit' value='Update' >");
		
	    out.print("</form>");	 
		 out.print("</body></html>");
		 
	  

	}

}   
