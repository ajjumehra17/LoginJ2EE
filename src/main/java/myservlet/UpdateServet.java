package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UpdateBean;


@WebServlet("/update")
public class UpdateServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		int id = Integer.parseInt(request.getParameter("userid"));
		 
		String name =(String) request.getParameter("name");
		String email =(String) request.getParameter("email");
		String address =(String) request.getParameter("address");
		String dob =(String) request.getParameter("dob");
		String gender =(String) request.getParameter("gender");

		long mobno = Long.parseLong(request.getParameter("mobno")); 
		int marks = Integer.parseInt(request.getParameter("marks"));
        UpdateBean uptbean = new UpdateBean();
        uptbean.setId(id);
        uptbean.setName(name);
        uptbean.setEmail(email);
        uptbean.setAddress(address);
        uptbean.setDob(dob);
        uptbean.setMobno(mobno);
        uptbean.setMarks(marks);
        uptbean.setGender(gender);
        if(uptbean.update()) {
        	 RequestDispatcher rd = request.getRequestDispatcher("/login.html");
    		 try {
    			 rd.forward(request, response);
    			
    		} catch (Exception e) {
    			 e.printStackTrace();
    		} 
    	}
    	else {
    		out.print("<h1>Invalid Id  Or Data Error  </h1>");
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
