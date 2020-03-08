package top.qjmsystem.express.bean;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	// �ܼ�¼��
	private long totalCount;
	// ��ǰҳ��
	private int pageNo;
	// ��ҳ��
	private int totalPageCount;
	// ÿҳ��С
	private int pageSize;
	// ÿҳ����
	private List items;

	// ���캯��
	public PageResult(long totalCount, int pageNo, int pageSize, List items) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.items = items == null ? new ArrayList<>() : items;
		// ������ڼ�¼
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
