package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.dao.ConsumerDao;

//由于基本的增删查改代码被抽取出来,这里不添加其他功能的话只需继承实现类即可，不需写任何代码

//用于将数据访问层的类表示为Spring 中的Bean
@Repository//相当于new的动作
public class ConsumerDaoImpl extends BaseDaoImpl<Consumer> implements ConsumerDao {

	@Override
	public Consumer findByWetChatAccounts(String wetChatAccounts) {
		Query query = getSession().createQuery("from Consumer where wetChatAccounts = ?");
		// 设置参数
		query.setParameter(0, wetChatAccounts);

		List list = query.list();
		if (list != null && list.size() > 0) {
			return (Consumer) list.get(0);
		}
		return null;
	}

	@Override
	public Consumer findByNum(String num) {
		
		Query query = getSession().createQuery("from Consumer where num = ?");
		// 设置参数
		query.setParameter(0, num);

		List list = query.list();
		if (list != null && list.size() > 0) {
			return (Consumer) list.get(0);
		}
		return null;
	}

	@Override
	public Consumer findByOpenid(String openid) {
		Query query = getSession().createQuery("from Consumer where openid = ?");
		// 设置参数
		query.setParameter(0, openid);

		List list = query.list();
		if (list != null && list.size() > 0) {
			return (Consumer) list.get(0);
		}
		return null;
	}

}
