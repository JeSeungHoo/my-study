package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test doGet 요청");
		String name = request.getParameter("name");
		System.out.println(name);
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'/>");
		out.print("<title>Test Page</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>name :"+name+"</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test doPost 요청");
		String name = request.getParameter("name");
		System.out.println("POST param : " +name);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>");
		out.print("name : "+name);
		out.print("</h1>");
		System.out.println("test post 종료");
	}

}



