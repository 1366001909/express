package top.qjmsystem.express.dao;

import java.util.List;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.GoodsPosition;

public interface GoodsPositionDao extends BaseDao<GoodsPosition>{

	//根据mailNo查询货物定位
	/**
	 * 
	 * @author 杨伟锋
	 * @mailNo 快递必要信息
	 * @return 货物定位
	 */
	public List<GoodsPosition> findByMailNo(String mailNo);
}
