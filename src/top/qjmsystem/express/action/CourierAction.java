package top.qjmsystem.express.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.action.BaseAction;
import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.service.CourierService;
import top.qjmsystem.express.util.ExcelUtil;

public class CourierAction extends BaseAction{
	// 用于封装页面的<input>传递过来的值
		private Courier courier;

		public Courier getCourier() {
			return courier;
		}

		public void setCourier(Courier courier) {
			this.courier = courier;
		}

		@Autowired
		private CourierService CourierService;

		public String listUI() {
			String hql = " from Courier ";
			// 放置查询条件的值的集合
			List<Object> conditions = null;

			if (courier != null) {
				conditions = new ArrayList<>();
				// ----------判断是否需要根据关键字查询--------------
				if (StringUtils.isNotBlank(courier.getAccounts().trim())) {
					// 说明需要根据标题查询
					hql = hql + " where accounts like ?";
					conditions.add("%" + courier.getAccounts().trim() + "%"); // trim()：去掉字符串的前后空格
				}

			}
			pageResult = CourierService.findObjects(hql, conditions, getPageNo(), getPageSize());

			return "listUI";
		}

		// 跳转addUI.jsp
		public String addUI() {
			return "addUI";
		}

		// 用于保存Courier
		public String add() {
			CourierService.save(courier);
			return "list";
		}

		// 跳转edit.jsp
		public String editUI() {
			courier = CourierService.findObjectById(courier.getId());
			return "editUI";
		}

		// 保存修改

		public String edit() {
			CourierService.update(courier);
			return "list";
		}

		// 删除一行
		public String delete() {
			CourierService.delete(courier);
			return "list";
		}

		// 批量删除
		public String deleteSelected() {
			CourierService.deleteAll(getSelectedRows());
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
					"attachment;filename=" + new String("快递员列表.xls".getBytes(), "ISO-8859-1"));

			// 查询列表数据
			List<Courier> dataList = CourierService.findObjects("from Courier");
			// 生成excel文件

			// 导出文件
			ExcelUtil.exportExcel_Courier(dataList, os);
		}
}
