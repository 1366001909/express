package top.qjmsystem.express.bean;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	// 总记录数
	private long totalCount;
	// 当前页数
	private int pageNo;
	// 总页数
	private int totalPageCount;
	// 每页大小
	private int pageSize;
	// 每页数据
	private List items;

	// 构造函数
	public PageResult(long totalCount, int pageNo, int pageSize, List items) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.items = items == null ? new ArrayList<>() : items;
		// 如果存在记录
		if (totalCount > 0) {
			this.pageNo = pageNo;
			int page = (int) (totalCount / pageSize);
			this.totalPageCount = totalCount % pageSize == 0 ? page : page + 1;
		} else {
			this.pageNo = 0;
			this.totalPageCount = 0;
		}
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

}
