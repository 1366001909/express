package top.qjmsystem.express.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.action.BaseAction;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.service.GoodsInfoService;
import top.qjmsystem.express.util.ExcelUtil;

public class GoodsInfoAction extends BaseAction {

	// 用于封装页面的<input>传递过来的值
	private GoodsInfo goodsInfo;

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	//用于对Bean的属性变量，属性的Set方法及构造函数进行标注，配合对应的注解处理器完成Bean的自动配置
	//默认按照bean的类型进行装配
	@Autowired
	private GoodsInfoService goodsInfoService;

	public String listUI() {
		String hql = " from GoodsInfo ";
		// 放置查询条件的值的集合
		List<Object> conditions = null;

		if (goodsInfo != null) {
			conditions = new ArrayList<>();
			// ----------判断是否需要根据关键字查询--------------
			if (StringUtils.isNotBlank(goodsInfo.getNum().trim())) {
				// 说明需要根据标题查询
				hql = hql + " where Num like ?";
				conditions.add("%" + goodsInfo.getNum().trim() + "%"); // trim()：去掉字符串的前后空格
			}

		}
		pageResult = goodsInfoService.findObjects(hql, conditions, getPageNo(), getPageSize());

		return "listUI";
	}

	// 跳转addUI.jsp
	public String addUI() {
		return "addUI";
	}

	// 用于保存goodsInfo
	public String add() {

		goodsInfoService.save(goodsInfo);

		return "list";
	}

	// 跳转edit.jsp
	public String editUI() {
		goodsInfo = goodsInfoService.findObjectById(goodsInfo.getId());
		return "editUI";
	}

	// 保存修改

	public String edit() {
		goodsInfoService.update(goodsInfo);
		return "list";
	}

	// 删除一行
	public String delete() {
		goodsInfoService.delete(goodsInfo);
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		goodsInfoService.deleteAll(getSelectedRows());
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
				"attachment;filename=" + new String("物流信息列表.xls".getBytes(), "ISO-8859-1"));

		// 查询列表数据
		List<GoodsInfo> dataList = goodsInfoService.findObjects("from GoodsInfo");
		// 生成excel文件

		// 导出文件
		ExcelUtil.exportExcel_GoodsInfo(dataList, os);
	}

}
