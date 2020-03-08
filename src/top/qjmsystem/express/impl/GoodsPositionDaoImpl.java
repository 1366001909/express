package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.dao.GoodsPositionDao;


//用于将数据访问层的类表示为Spring 中的Bean
@Repository//相当于new的动作
public class GoodsPositionDaoImpl extends BaseDaoImpl<GoodsPosition> implements GoodsPositionDao{

	@Override
	public List<GoodsPosition> findByMailNo(String mailNo) {

		Query query = getSession().createQuery("from GoodsPosition where mailNo = ?");
		//设置参数
		query.setParameter(0, mailNo);
		
		List<GoodsPosition> list = query.list();
		if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

}
