package top.qjmsystem.express.dao;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.Consumer;

public interface ConsumerDao extends BaseDao<Consumer>{
	
	
	public Consumer findByWetChatAccounts(String wetChatAccounts);
	
	public Consumer findByOpenid(String openid);
	
	
	public Consumer findByNum(String num);
}
