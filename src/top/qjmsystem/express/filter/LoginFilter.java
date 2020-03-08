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
	
	
	//ִ�й��˵Ĳ���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//http������
		HttpServletRequest req = (HttpServletRequest) request;
		//http����Ӧ
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//---------------�û�ֱ�ӷ��ʵ�¼ҳ�棬����ִ�е�¼������Ӧ��ֱ�ӷ���-------------------
		//��ȡ�û��������ַ
		String url = req.getRequestURI();
		//��������ַ�����˵�¼��صĲ�����Ӧ�÷���
		if(url.contains("/login/loginAction_")){
			chain.doFilter(request, response);
		}else if(url.contains("WetChat/WetChatAction_")) {
			chain.doFilter(request, response);
		}else if(url.contains("App/AppAction_")) {
			chain.doFilter(request, response);
		}
		
		else{
			
			//---------------�û������ܱ�������Դ��ʱ����ж��û���û��¼-------------
			//��ȡhttpSession����
			HttpSession session = req.getSession();
			//��ȡ�û�����
			User user = (User) session.getAttribute("SYS_USER");
			
			if(user!=null){
				//˵���û�֮ǰ�Ѿ���¼��ֱ�ӷ���������Դ
				chain.doFilter(request, response);
			}else{
				//˵���û�û�е�¼����ת��¼ҳ����û�
				String path = req.getContextPath();//��ȡ��Ŀ����
				resp.sendRedirect(path + "/login/loginAction_loginUI.action");
			}
		}	
	}
	@Override
	public void destroy() {

	}

}
