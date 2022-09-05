package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	String encodingName;
	String requestMethod;
	
	public void init(FilterConfig fConfig)
			throws ServletException{
		System.out.println("EncodingFilter init start");
		encodingName = fConfig.getInitParameter("encoding");
		requestMethod = fConfig.getInitParameter("method");
		System.out.println("EncodingFilter init end");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("encoding doFilter start ===");
		HttpServletRequest req = (HttpServletRequest)request;
		// 전송방식 + get or post
		String method = req.getMethod();
		System.out.println("전송방식 : " + method);
		if(method.equals(requestMethod)) {
			request.setCharacterEncoding(encodingName);
			System.out.println(encodingName+" 인코딩완료");
		}
		chain.doFilter(request, response);
		System.out.println("encoding doFilter end ===");
	}
	
	public void destroy() {
		System.out.println("Destroy");
	}
}






