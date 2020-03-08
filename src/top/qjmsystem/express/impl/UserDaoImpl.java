package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.dao.UserDao;
import top.qjmsystem.express.bean.User;
//���ڽ����ݷ��ʲ�����ʾΪSpring �е�Bean
@Repository//�൱��new�Ķ���
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	//���ӵ�¼����
	public User findUserByAccountAndPwd(String account, String pwd) {
		Query query = getSession().createQuery("from User where accounts = ? and password = ?");
		//���ò���
		query.setParameter(0, account);
		query.setParameter(1, pwd);
		List list = query.list();
		 if(list!=null && list.size()>0){
			 return (User) list.get(0);
		 }
		 return null;
	}


}
