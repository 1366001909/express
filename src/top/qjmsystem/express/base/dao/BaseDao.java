package top.qjmsystem.express.base.dao;

import java.io.Serializable;
import java.util.List;

//��ȡ�����ͨ�ô���
public interface BaseDao<T> {

	// ��ѯ����
	public List<T> findObjects(String hql);

	// ����id��ѯһ������
	public T findObjectById(Serializable id);

	// ����
	public void save(T entity);

	// ����
	public void update(T entity);

	// ɾ��һ��
	public void delete(T entity);

	// ����idɾ������
	public void deleteAll(Serializable[] ids);

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
	public List<T> findObjects(String hql, Integer pageNo, Integer pageSize);

	// ���ز�ѯ���У���������ѯ
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
	public List<T> findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

	// ��ѯ�ܼ�¼��
	public Long findTotalCount();

	// ��ѯ�ܼ�¼������Ҫ��������ѯ
	public Long findTotalCount(String hql, List<Object> conditions);
}
