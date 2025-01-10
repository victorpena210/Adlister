package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "HelloWorldServlet", urlPatterns = "/hello")
public class HiWorldServlet extends HttpServlet {
	public static int counter;
	
	public static void reset() {
		counter=1;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if(name==null) {
			out.println("<h1>Hello, World</h1>");
		} else if (name.equals("bgates")) {
			response.sendRedirect("https://microsoft.com");
			return;
		} else if(name.equals("reset")) {
            out.println("<h1>Hello, World</h1>");
            reset();
        } else {
            out.println("<h1>Hello, " + name + "</h1>");
            request.setAttribute("name",name);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            counter++;
        }
		
		out.println("this page has been seen:  " + counter);
		
	}
}