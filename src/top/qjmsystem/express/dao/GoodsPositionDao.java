package top.qjmsystem.express.dao;

import java.util.List;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.GoodsPosition;

public interface GoodsPositionDao extends BaseDao<GoodsPosition>{

	//����mailNo��ѯ���ﶨλ
	/**
	 * 
	 * @author ��ΰ��
	 * @mailNo ��ݱ�Ҫ��Ϣ
	 * @return ���ﶨλ
	 */
	public List<GoodsPosition> findByMailNo(String mailNo);
}
