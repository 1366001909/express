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
	// ���ڷ�װҳ���<input>���ݹ�����ֵ
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
			// ���ò�ѯ������ֵ�ļ���
			List<Object> conditions = null;

			if (courier != null) {
				conditions = new ArrayList<>();
				// ----------�ж��Ƿ���Ҫ���ݹؼ��ֲ�ѯ--------------
				if (StringUtils.isNotBlank(courier.getAccounts().trim())) {
					// ˵����Ҫ���ݱ����ѯ
					hql = hql + " where accounts like ?";
					conditions.add("%" + courier.getAccounts().trim() + "%"); // trim()��ȥ���ַ�����ǰ��ո�
				}

			}
			pageResult = CourierService.findObjects(hql, conditions, getPageNo(), getPageSize());

			return "listUI";
		}

		// ��תaddUI.jsp
		public String addUI() {
			return "addUI";
		}

		// ���ڱ���Courier
		public String add() {
			CourierService.save(courier);
			return "list";
		}

		// ��תedit.jsp
		public String editUI() {
			courier = CourierService.findObjectById(courier.getId());
			return "editUI";
		}

		// �����޸�

		public String edit() {
			CourierService.update(courier);
			return "list";
		}

		// ɾ��һ��
		public String delete() {
			CourierService.delete(courier);
			return "list";
		}

		// ����ɾ��
		public String deleteSelected() {
			CourierService.deleteAll(getSelectedRows());
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
					"attachment;filename=" + new String("���Ա�б�.xls".getBytes(), "ISO-8859-1"));

			// ��ѯ�б�����
			List<Courier> dataList = CourierService.findObjects("from Courier");
			// ����excel�ļ�

			// �����ļ�
			ExcelUtil.exportExcel_Courier(dataList, os);
		}
}
