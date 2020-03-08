package top.qjmsystem.express.impl;

import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.dao.CourierDao;
//用于将数据访问层的类表示为Spring 中的Bean
@Repository//相当于new的动作
public class CourierDaoImpl  extends BaseDaoImpl<Courier> implements CourierDao{
	@Override
	//增加登录功能
	public Courier findCourierByAccountAndPwd(String account, String pwd) {
		Query query = getSession().createQuery("from Courier where accounts = ? and password = ?");
		//设置参数
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
		//设置参数
		query.setParameter(0, openid);
		List list = query.list();
		 if(list!=null && list.size()>0){
			 return (Courier) list.get(0);
		 }
		 return null;
	}
}
