package top.qjmsystem.express.dao;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.User;

public interface UserDao extends BaseDao<User>{
	//实现登录功能
	//根据账号和密码查询
	public User findUserByAccountAndPwd(String account,String pwd);
}
