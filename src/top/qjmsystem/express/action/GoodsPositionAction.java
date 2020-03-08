package top.qjmsystem.express.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.action.BaseAction;
import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.service.GoodsPositionService;
import top.qjmsystem.express.util.ExcelUtil;

public class GoodsPositionAction extends BaseAction {

	// ���ڷ�װҳ���<input>���ݹ�����ֵ
	private GoodsPosition goodsPosition;

	public GoodsPosition getGoodsPosition() {
		return goodsPosition;
	}

	public void setGoodsPosition(GoodsPosition goodsPosition) {
		this.goodsPosition = goodsPosition;
	}

	@Autowired
	private GoodsPositionService goodsPositionService;

	public String listUI() {
		String hql = " from GoodsPosition ";
		// ���ò�ѯ������ֵ�ļ���
		List<Object> conditions = null;

		if (goodsPosition != null) {
			conditions = new ArrayList<>();
			// ----------�ж��Ƿ���Ҫ���ݹؼ��ֲ�ѯ--------------
			if (StringUtils.isNotBlank(goodsPosition.getMailNo().trim())) {
				// ˵����Ҫ���ݱ����ѯ
				hql = hql + " where mailNO like ?";
				conditions.add("%" + goodsPosition.getMailNo().trim() + "%"); // trim()��ȥ���ַ�����ǰ��ո�
			}

		}
		pageResult = goodsPositionService.findObjects(hql, conditions, getPageNo(), getPageSize());

		return "listUI";
	}

	// ��תaddUI.jsp
	public String addUI() {
		return "addUI";
	}

	// ���ڱ���goodsPosition
	public String add() {

		goodsPositionService.save(goodsPosition);

		return "list";
	}

	// ��תedit.jsp
	public String editUI() {
		goodsPosition = goodsPositionService.findObjectById(goodsPosition.getId());
		return "editUI";
	}

	// �����޸�

	public String edit() {
		goodsPositionService.update(goodsPosition);
		return "list";
	}

	// ɾ��һ��
	public String delete() {
		goodsPositionService.delete(goodsPosition);
		return "list";
	}

	// ����ɾ��
	public String deleteSelected() {
		goodsPositionService.deleteAll(getSelectedRows());
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
				"attachment;filename=" + new String("����λ���б�.xls".getBytes(), "ISO-8859-1"));

		// ��ѯ�б�����
		List<GoodsPosition> dataList = goodsPositionService.findObjects("from GoodsPosition");
		// ����excel�ļ�

		// �����ļ�
		ExcelUtil.exportExcel_GoodsPosition(dataList, os);
	}
}
