package top.qjmsystem.express.base.action;

import top.qjmsystem.express.bean.PageResult;;

public class BaseAction {
	
	
	//--------------用于接收分页参数--------------------
	private Integer pageNo=1;  //当前页号，默认是查第一页
	private Integer pageSize=10;  //页大小 ，默认每页显示5条
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
	//--------------用于接收分页参数--------------------
	
	
	//用于页面回显的分页对象
	public PageResult pageResult;
	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	
	//公用代码进行抽取
	//接收批量删除的id
	private Integer[] selectedRows;
	public Integer[] getSelectedRows() {
		return selectedRows;
	}
	public void setSelectedRows(Integer[] selectedRows) {
		this.selectedRows = selectedRows;
	}
	
	
	
}
