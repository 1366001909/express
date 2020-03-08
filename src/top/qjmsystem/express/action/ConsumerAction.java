package top.qjmsystem.express.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.action.BaseAction;
import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.util.ExcelUtil;
import top.qjmsystem.express.service.ConsumerService;

public class ConsumerAction extends BaseAction {
	    //用于封装页面的<input>传递过来的值
		private Consumer consumer;
		public Consumer getConsumer() {
			return consumer;
		}
		public void setConsumer(Consumer consumer) {
			this.consumer = consumer;
		}

	
		@Autowired
		private ConsumerService  consumerService;
		
		public String listUI(){
			//获取分页对象
			//用于页面取值
			String hql = " from Consumer ";
			//放置查询条件的值的集合
			List<Object> conditions = null;	
			
				
			if (consumer != null) {
				conditions = new ArrayList<>();
				// ----------判断是否需要根据关键字查询--------------
				if (StringUtils.isNotBlank(consumer.getWetChatAccounts().trim())) {
					// 说明需要根据标题查询
					hql = hql + " where wetChatAccounts like ?";
					conditions.add("%" + consumer.getWetChatAccounts().trim() + "%"); // trim()：去掉字符串的前后空格
				}

			}
			pageResult = consumerService.findObjects(hql, conditions, getPageNo(), getPageSize());
			
			return "listUI";
		}
		
		
		//跳转addUI.jsp
		public String addUI(){
			return "addUI";
		}
		
		
		//用于保存user
		public String add(){
			
			consumerService.save(consumer);
			
			return "list";
		}
		
		//跳转edit.jsp
		public String editUI(){
			consumer = consumerService.findObjectById(consumer.getId());
			return "editUI";
		}
		
		
		
		//保存修改
		
		public String edit(){
			consumerService.update(consumer);
			return "list";
		}
		
		//删除一行
		public String delete(){
			consumerService.delete(consumer);
			return "list";
		}
		
		
		//批量删除
		public String deleteSelected(){
			consumerService.deleteAll(getSelectedRows());
			return "list";
		}
		
		
		//导出excel文件到浏览器
		public void exportExcel() throws Exception{
			
			//获取响应对象
			HttpServletResponse response = ServletActionContext.getResponse();
			//获取输出流对象
			ServletOutputStream os = response.getOutputStream();
			
			//设置下载类型，格式为excel文件格式
			response.setContentType("application/x-excel");
			//设置下载文件的属性，告诉浏览器如何展示文件内容
			response.setHeader("Content-Disposition", "attachment;filename="+new String("用户列表.xls".getBytes(),"ISO-8859-1"));
			
			//查询列表数据
			List<Consumer> dataList = consumerService.findObjects("from Consumer");
			//生成excel文件
			
			//导出文件
			ExcelUtil.exportExcel_Consumer(dataList, os);
		}
}
