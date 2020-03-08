package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.dao.UserDao;
import top.qjmsystem.express.bean.User;
//用于将数据访问层的类表示为Spring 中的Bean
@Repository//相当于new的动作
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	//增加登录功能
	public User findUserByAccountAndPwd(String account, String pwd) {
		Query query = getSession().createQuery("from User where accounts = ? and password = ?");
		//设置参数
		query.setParameter(0, account);
		query.setParameter(1, pwd);
		List list = query.list();
		 if(list!=null && list.size()>0){
			 return (User) list.get(0);
		 }
		 return null;
	}


}
