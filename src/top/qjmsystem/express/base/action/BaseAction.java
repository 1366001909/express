package top.qjmsystem.express.base.action;

import top.qjmsystem.express.bean.PageResult;;

public class BaseAction {
	
	
	//--------------���ڽ��շ�ҳ����--------------------
	private Integer pageNo=1;  //��ǰҳ�ţ�Ĭ���ǲ��һҳ
	private Integer pageSize=10;  //ҳ��С ��Ĭ��ÿҳ��ʾ5��
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	//--------------���ڽ��շ�ҳ����--------------------
	
	
	//����ҳ����Եķ�ҳ����
	public PageResult pageResult;
	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	
	//���ô�����г�ȡ
	//��������ɾ����id
	private Integer[] selectedRows;
	public Integer[] getSelectedRows() {
		return selectedRows;
	}
	public void setSelectedRows(Integer[] selectedRows) {
		this.selectedRows = selectedRows;
	}
	
	
	
}
