package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.dao.ConsumerDao;

//���ڻ�������ɾ��Ĵ��뱻��ȡ����,���ﲻ����������ܵĻ�ֻ��̳�ʵ���༴�ɣ�����д�κδ���

//���ڽ����ݷ��ʲ�����ʾΪSpring �е�Bean
@Repository//�൱��new�Ķ���
public class ConsumerDaoImpl extends BaseDaoImpl<Consumer> implements ConsumerDao {

	@Override
	public Consumer findByWetChatAccounts(String wetChatAccounts) {
		Query query = getSession().createQuery("from Consumer where wetChatAccounts = ?");
		// ���ò���
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
		// ���ò���
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
		// ���ò���
		query.setParameter(0, openid);

		List list = query.list();
		if (list != null && list.size() > 0) {
			return (Consumer) list.get(0);
		}
		return null;
	}

}
