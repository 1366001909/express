package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.bean.User;

public interface UserService {
	// ��ѯ����
	public List<User> findObjects(String hql);

	// ����id��ѯһ������
	public User findObjectById(Serializable id);

	// ����
	public void save(User entity);

	// ����
	public void update(User entity);

	// ɾ��һ��
	public void delete(User entity);

	// ����idɾ������
	public void deleteAll(Serializable[] ids);

	// �����˺ź������ѯ�û�
	/**
	 * 
	 * @param account
	 *            �˺�
	 * @param pwd
	 *            ����
	 * @return �û�����
	 */
	public User findUserByAccountAndPwd(String account, String pwd);

	// ��ѯ����
	// ���ز�ѯ���У����أ�����������ͬ�������б�ͬ�����������������ͣ��뷵��ֵ�޹أ�
	/**
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param pageNo
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ҳ��С
	 * @return
	 */

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

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
