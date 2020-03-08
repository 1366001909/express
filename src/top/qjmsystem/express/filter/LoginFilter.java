package top.qjmsystem.express.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.qjmsystem.express.bean.User;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	
	//执行过滤的操作
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//http的请求
		HttpServletRequest req = (HttpServletRequest) request;
		//http的响应
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//---------------用户直接访问登录页面，或者执行登录操作，应该直接放行-------------------
		//获取用户的请求地址
		String url = req.getRequestURI();
		//如果请求地址包含了登录相关的操作，应该放行
		if(url.contains("/login/loginAction_")){
			chain.doFilter(request, response);
		}else if(url.contains("WetChat/WetChatAction_")) {
			chain.doFilter(request, response);
		}else if(url.contains("App/AppAction_")) {
			chain.doFilter(request, response);
		}
		
		else{
			
			//---------------用户访问受保护的资源的时候才判断用户有没登录-------------
			//获取httpSession对象
			HttpSession session = req.getSession();
			//获取用户对象
			User user = (User) session.getAttribute("SYS_USER");
			
			if(user!=null){
				//说明用户之前已经登录，直接放行请求资源
				chain.doFilter(request, response);
			}else{
				//说明用户没有登录，跳转登录页面给用户
				String path = req.getContextPath();//获取项目名称
				resp.sendRedirect(path + "/login/loginAction_loginUI.action");
			}
		}	
	}
	@Override
	public void destroy() {

	}

}
