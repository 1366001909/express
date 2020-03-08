package top.qjmsystem.express.dao;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.Courier;

public interface CourierDao extends BaseDao<Courier>{
	//实现登录功能
		//根据账号和密码查询
		public Courier findCourierByAccountAndPwd(String account,String pwd);
		
		
		//对快递员进行验证
		/**
		 * 
		 * @param openid 快递员提供openid
		 * @return 
		 */
		public Courier findCourierByOpenid(String openid);
}
