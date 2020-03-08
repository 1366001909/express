package top.qjmsystem.express.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.action.BaseAction;
import top.qjmsystem.express.bean.User;
import top.qjmsystem.express.service.UserService;
import top.qjmsystem.express.util.ExcelUtil;

public class UserAction extends BaseAction {

	UserAction() {
		permissionList = new ArrayList<String>();
		permissionList.add("��ɫ����");
		permissionList.add("�û�����");
		permissionList.add("��ݹ���");
		permissionList.add("��λ����");
	}

	// ����ҳ�渴ѡ��Ȩ��
	private String[] permissions;

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	private List<String> permissionList;

	public List<String> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}

	// ���ڷ�װҳ���<input>���ݹ�����ֵ
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Autowired
	private UserService userService;

	public String listUI() {
		String hql = " from User ";
		// ���ò�ѯ������ֵ�ļ���
		List<Object> conditions = null;

		if (user != null) {
			conditions = new ArrayList<>();
			// ----------�ж��Ƿ���Ҫ���ݹؼ��ֲ�ѯ--------------
			if (StringUtils.isNotBlank(user.getAccounts().trim())) {
				// ˵����Ҫ���ݱ����ѯ
				hql = hql + " where accounts like ?";
				conditions.add("%" + user.getAccounts().trim() + "%"); // trim()��ȥ���ַ�����ǰ��ո�
			}

		}
		pageResult = userService.findObjects(hql, conditions, getPageNo(), getPageSize());

		return "listUI";
	}

	// ��תaddUI.jsp
	public String addUI() {
		return "addUI";
	}

	// ���ڱ���user
	public String add() {

		String permission = "";
		if (permissions != null) {
			for (int i = 0; i < permissions.length; i++) {
				permission += permissions[i] + " ";
			}
		}
		user.setPermissions(permission);
		userService.save(user);

		return "list";
	}

	// ��תedit.jsp
	public String editUI() {
		user = userService.findObjectById(user.getId());
		return "editUI";
	}

	// �����޸�

	public String edit() {
		String permission = "";
		if (permissions != null) {
			for (int i = 0; i < permissions.length; i++) {
				permission += permissions[i] + " ";
			}
		}
		user.setPermissions(permission);
		userService.update(user);
		return "list";
	}

	// ɾ��һ��
	public String delete() {
		userService.delete(user);
		return "list";
	}

	// ����ɾ��
	public String deleteSelected() {
		userService.deleteAll(getSelectedRows());
		return "list";
	}

	// ����excel�ļ��������
	public void exportExcel() throws Exception {

		// ��ȡ��Ӧ����
		HttpServletResponse response = ServletActionContext.getResponse();
		// ��ȡ���������
		ServletOutputStream os = response.getOutputStream();

		// �����������ͣ���ʽΪexcel�ļ���ʽ
		response.setContentType("application/x-excel");
		// ���������ļ������ԣ�������������չʾ�ļ�����
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("����Ա�б�.xls".getBytes(), "ISO-8859-1"));

		// ��ѯ�б�����
		List<User> dataList = userService.findObjects("from User");
		// ����excel�ļ�

		// �����ļ�
		ExcelUtil.exportExcel(dataList, os);
	}

}
