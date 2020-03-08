package top.qjmsystem.express.service.impl;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.dao.ConsumerDao;
import top.qjmsystem.express.service.ConsumerService;


//���ڽ�ҵ�������ʶΪSpring �е�bean
@Service//��@Repositoryһ�� ������springȥ�������󣬲���ӵ�IOC������
@Transactional  //ע�����������
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDao consumerDao;

	@Override
	public List<Consumer> findObjects(String hql) {
		return consumerDao.findObjects(hql);
	}

	@Override
	public Consumer findObjectById(Serializable id) {
		return consumerDao.findObjectById(id);
	}

	@Override
	public void save(Consumer entity) {
		consumerDao.save(entity);
	}

	@Override
	public void update(Consumer entity) {
		consumerDao.update(entity);
	}

	@Override
	public void delete(Consumer entity) {
		consumerDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		consumerDao.deleteAll(ids);
	}
	
	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		
		//��ҳ��ѯ���ݽ��
		List<Consumer> items = consumerDao.findObjects(hql, pageNo, pageSize);
		
		//��ѯ�ܼ�¼��
		Long totalCount = consumerDao.findTotalCount();
		
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
	
	
	public Consumer findByWetChatAccounts(String wetChatAccounts) {
		return consumerDao.findByWetChatAccounts(wetChatAccounts);
	}

	public Consumer findByNum(String num) {
		return consumerDao.findByNum(num);
	}
	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// ��ҳ��ѯ���ݽ��
		List<Consumer> items = consumerDao.findObjects(hql, conditions, pageNo, pageSize);

		// ��ѯ�ܼ�¼��
		Long totalCount = consumerDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public Consumer findByOpenid(String openid) {
		return consumerDao.findByOpenid(openid);
	}
}
