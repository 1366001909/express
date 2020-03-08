package top.qjmsystem.express.impl;

import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.dao.CourierDao;
//���ڽ����ݷ��ʲ�����ʾΪSpring �е�Bean
@Repository//�൱��new�Ķ���
public class CourierDaoImpl  extends BaseDaoImpl<Courier> implements CourierDao{
	@Override
	//���ӵ�¼����
	public Courier findCourierByAccountAndPwd(String account, String pwd) {
		Query query = getSession().createQuery("from Courier where accounts = ? and password = ?");
		//���ò���
		query.setParameter(0, account);
		query.setParameter(1, pwd);
		List list = query.list();
		 if(list!=null && list.size()>0){
			 return (Courier) list.get(0);
		 }
		 return null;
	}
	
	
	public Courier findCourierByOpenid(String openid) {
		Query query = getSession().createQuery("from Courier where openid = ?");
		//���ò���
		query.setParameter(0, openid);
		List list = query.list();
		 if(list!=null && list.size()>0){
			 return (Courier) list.get(0);
		 }
		 return null;
	}
}
