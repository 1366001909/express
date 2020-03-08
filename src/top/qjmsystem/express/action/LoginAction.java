package top.qjmsystem.express.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.bean.User;
import top.qjmsystem.express.service.UserService;

public class LoginAction {

	@Autowired
	private UserService userService;

	// 获取页面输入的账号和密码
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 错误提示信息
	private String errorMessage = "";

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// 跳转到登录页面
	public String loginUI() {
		return "loginUI";
	}

	public String login() {
		User selectedUser = userService.findUserByAccountAndPwd(user.getAccounts(), user.getPassword());

		// 用户非空，说明存在用户
		if (selectedUser != null) {
			// 将用户信息保存在HttpSession中
			// 获取session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
			// 将查询出来的用户信息保存在session中
			session.setAttribute("SYS_USER", selectedUser);
			// 返回后台主页
			return "home";
		}

		// 登录失败，回到登录页面
		errorMessage = "用户名或密码错误";// 提示用户名或密码错误
		return "fail";
	}

	// 退出登录操作
	public String logout() {

		// 销毁session
		ServletActionContext.getRequest().getSession().removeAttribute("SYS_USER");

		// 回到登录页面
		return "fail";
	}

}
