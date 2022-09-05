package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8591970279891007344L;
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 요청");
	}
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST 요청");
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		String ip = req.getRemoteAddr();
		System.out.println(ip);
		System.out.println(req.getMethod());
		
		// response
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'/>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>아이디는 : "+uid+"</h1>");
		out.print("<h1>비밀번호는 : "+upw+"</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	
	
}












