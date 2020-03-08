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
		permissionList.add("角色管理");
		permissionList.add("用户管理");
		permissionList.add("快递管理");
		permissionList.add("定位管理");
	}

	// 接收页面复选框权限
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

	// 用于封装页面的<input>传递过来的值
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
		// 放置查询条件的值的集合
		List<Object> conditions = null;

		if (user != null) {
			conditions = new ArrayList<>();
			// ----------判断是否需要根据关键字查询--------------
			if (StringUtils.isNotBlank(user.getAccounts().trim())) {
				// 说明需要根据标题查询
				hql = hql + " where accounts like ?";
				conditions.add("%" + user.getAccounts().trim() + "%"); // trim()：去掉字符串的前后空格
			}

		}
		pageResult = userService.findObjects(hql, conditions, getPageNo(), getPageSize());

		return "listUI";
	}

	// 跳转addUI.jsp
	public String addUI() {
		return "addUI";
	}

	// 用于保存user
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

	// 跳转edit.jsp
	public String editUI() {
		user = userService.findObjectById(user.getId());
		return "editUI";
	}

	// 保存修改

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

	// 删除一行
	public String delete() {
		userService.delete(user);
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		userService.deleteAll(getSelectedRows());
		return "list";
	}

	// 导出excel文件到浏览器
	public void exportExcel() throws Exception {

		// 获取响应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		// 获取输出流对象
		ServletOutputStream os = response.getOutputStream();

		// 设置下载类型，格式为excel文件格式
		response.setContentType("application/x-excel");
		// 设置下载文件的属性，告诉浏览器如何展示文件内容
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("管理员列表.xls".getBytes(), "ISO-8859-1"));

		// 查询列表数据
		List<User> dataList = userService.findObjects("from User");
		// 生成excel文件

		// 导出文件
		ExcelUtil.exportExcel(dataList, os);
	}

}
