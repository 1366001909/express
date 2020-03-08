package top.qjmsystem.express.dao;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.Courier;

public interface CourierDao extends BaseDao<Courier>{
	//ʵ�ֵ�¼����
		//�����˺ź������ѯ
		public Courier findCourierByAccountAndPwd(String account,String pwd);
		
		
		//�Կ��Ա������֤
		/**
		 * 
		 * @param openid ���Ա�ṩopenid
		 * @return 
		 */
		public Courier findCourierByOpenid(String openid);
}
