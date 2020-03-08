package top.qjmsystem.express.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.bean.User;
import top.qjmsystem.express.service.UserService;

public class LoginAction {

	@Autowired
	private UserService userService;

	// ��ȡҳ��������˺ź�����
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ������ʾ��Ϣ
	private String errorMessage = "";

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// ��ת����¼ҳ��
	public String loginUI() {
		return "loginUI";
	}

	public String login() {
		User selectedUser = userService.findUserByAccountAndPwd(user.getAccounts(), user.getPassword());

		// �û��ǿգ�˵�������û�
		if (selectedUser != null) {
			// ���û���Ϣ������HttpSession��
			// ��ȡsession����
			HttpSession session = ServletActionContext.getRequest().getSession();
			// ����ѯ�������û���Ϣ������session��
			session.setAttribute("SYS_USER", selectedUser);
			// ���غ�̨��ҳ
			return "home";
		}

		// ��¼ʧ�ܣ��ص���¼ҳ��
		errorMessage = "�û������������";// ��ʾ�û������������
		return "fail";
	}

	// �˳���¼����
	public String logout() {

		// ����session
		ServletActionContext.getRequest().getSession().removeAttribute("SYS_USER");

		// �ص���¼ҳ��
		return "fail";
	}

}
