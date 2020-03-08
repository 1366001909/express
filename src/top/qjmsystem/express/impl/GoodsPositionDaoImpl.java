package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.dao.GoodsPositionDao;


//���ڽ����ݷ��ʲ�����ʾΪSpring �е�Bean
@Repository//�൱��new�Ķ���
public class GoodsPositionDaoImpl extends BaseDaoImpl<GoodsPosition> implements GoodsPositionDao{

	@Override
	public List<GoodsPosition> findByMailNo(String mailNo) {

		Query query = getSession().createQuery("from GoodsPosition where mailNo = ?");
		//���ò���
		query.setParameter(0, mailNo);
		
		List<GoodsPosition> list = query.list();
		if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

}
