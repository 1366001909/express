package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.PageResult;

public interface ConsumerService {
	// ��ѯ����
	public List<Consumer> findObjects(String hql);

	// ����id��ѯһ������
	public Consumer findObjectById(Serializable id);

	// ����
	public void save(Consumer entity);

	// ����
	public void update(Consumer entity);

	// ɾ��һ��
	public void delete(Consumer entity);

	// ����idɾ������
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public Consumer findByWetChatAccounts(String wetChatAccounts);
	public Consumer findByOpenid(String openid);

	public Consumer findByNum(String num);

	// ���ز�ѯ���У����أ�����������ͬ�������б�ͬ�����������������ͣ��뷵��ֵ�޹أ�
	/**
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param pageNo
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ҳ��С
	 * @condition ��ѯ����
	 * @return
	 */
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

}
