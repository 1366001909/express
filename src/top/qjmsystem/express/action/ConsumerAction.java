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
	    //���ڷ�װҳ���<input>���ݹ�����ֵ
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
			//��ȡ��ҳ����
			//����ҳ��ȡֵ
			String hql = " from Consumer ";
			//���ò�ѯ������ֵ�ļ���
			List<Object> conditions = null;	
			
				
			if (consumer != null) {
				conditions = new ArrayList<>();
				// ----------�ж��Ƿ���Ҫ���ݹؼ��ֲ�ѯ--------------
				if (StringUtils.isNotBlank(consumer.getWetChatAccounts().trim())) {
					// ˵����Ҫ���ݱ����ѯ
					hql = hql + " where wetChatAccounts like ?";
					conditions.add("%" + consumer.getWetChatAccounts().trim() + "%"); // trim()��ȥ���ַ�����ǰ��ո�
				}

			}
			pageResult = consumerService.findObjects(hql, conditions, getPageNo(), getPageSize());
			
			return "listUI";
		}
		
		
		//��תaddUI.jsp
		public String addUI(){
			return "addUI";
		}
		
		
		//���ڱ���user
		public String add(){
			
			consumerService.save(consumer);
			
			return "list";
		}
		
		//��תedit.jsp
		public String editUI(){
			consumer = consumerService.findObjectById(consumer.getId());
			return "editUI";
		}
		
		
		
		//�����޸�
		
		public String edit(){
			consumerService.update(consumer);
			return "list";
		}
		
		//ɾ��һ��
		public String delete(){
			consumerService.delete(consumer);
			return "list";
		}
		
		
		//����ɾ��
		public String deleteSelected(){
			consumerService.deleteAll(getSelectedRows());
			return "list";
		}
		
		
		//����excel�ļ��������
		public void exportExcel() throws Exception{
			
			//��ȡ��Ӧ����
			HttpServletResponse response = ServletActionContext.getResponse();
			//��ȡ���������
			ServletOutputStream os = response.getOutputStream();
			
			//�����������ͣ���ʽΪexcel�ļ���ʽ
			response.setContentType("application/x-excel");
			//���������ļ������ԣ�������������չʾ�ļ�����
			response.setHeader("Content-Disposition", "attachment;filename="+new String("�û��б�.xls".getBytes(),"ISO-8859-1"));
			
			//��ѯ�б�����
			List<Consumer> dataList = consumerService.findObjects("from Consumer");
			//����excel�ļ�
			
			//�����ļ�
			ExcelUtil.exportExcel_Consumer(dataList, os);
		}
}
