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

	// ���ڷ�װҳ���<input>���ݹ�����ֵ
	private GoodsInfo goodsInfo;

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	//���ڶ�Bean�����Ա��������Ե�Set���������캯�����б�ע����϶�Ӧ��ע�⴦�������Bean���Զ�����
	//Ĭ�ϰ���bean�����ͽ���װ��
	@Autowired
	private GoodsInfoService goodsInfoService;

	public String listUI() {
		String hql = " from GoodsInfo ";
		// ���ò�ѯ������ֵ�ļ���
		List<Object> conditions = null;

		if (goodsInfo != null) {
			conditions = new ArrayList<>();
			// ----------�ж��Ƿ���Ҫ���ݹؼ��ֲ�ѯ--------------
			if (StringUtils.isNotBlank(goodsInfo.getNum().trim())) {
				// ˵����Ҫ���ݱ����ѯ
				hql = hql + " where Num like ?";
				conditions.add("%" + goodsInfo.getNum().trim() + "%"); // trim()��ȥ���ַ�����ǰ��ո�
			}

		}
		pageResult = goodsInfoService.findObjects(hql, conditions, getPageNo(), getPageSize());

		return "listUI";
	}

	// ��תaddUI.jsp
	public String addUI() {
		return "addUI";
	}

	// ���ڱ���goodsInfo
	public String add() {

		goodsInfoService.save(goodsInfo);

		return "list";
	}

	// ��תedit.jsp
	public String editUI() {
		goodsInfo = goodsInfoService.findObjectById(goodsInfo.getId());
		return "editUI";
	}

	// �����޸�

	public String edit() {
		goodsInfoService.update(goodsInfo);
		return "list";
	}

	// ɾ��һ��
	public String delete() {
		goodsInfoService.delete(goodsInfo);
		return "list";
	}

	// ����ɾ��
	public String deleteSelected() {
		goodsInfoService.deleteAll(getSelectedRows());
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
				"attachment;filename=" + new String("������Ϣ�б�.xls".getBytes(), "ISO-8859-1"));

		// ��ѯ�б�����
		List<GoodsInfo> dataList = goodsInfoService.findObjects("from GoodsInfo");
		// ����excel�ļ�

		// �����ļ�
		ExcelUtil.exportExcel_GoodsInfo(dataList, os);
	}

}
