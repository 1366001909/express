package top.qjmsystem.express.dao;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.User;

public interface UserDao extends BaseDao<User>{
	//ʵ�ֵ�¼����
	//�����˺ź������ѯ
	public User findUserByAccountAndPwd(String account,String pwd);
}
