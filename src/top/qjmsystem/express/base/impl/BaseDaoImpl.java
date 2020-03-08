package top.qjmsystem.express.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import top.qjmsystem.express.base.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;

	// ���似����ȡT��Ӧ��ʵ������
	public BaseDaoImpl() {
		// ����T
		Type type = this.getClass().getGenericSuperclass();
		// ��ȡType�Ĳ�������
		ParameterizedType pt = (ParameterizedType) type;
		// ��ȡT��ʵ�ʴ��������
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		// System.out.println("����T�����ʵ�����ͣ�"+clazz);
		// System.out.println(clazz.getSimpleName());
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<T> findObjects(String hql) {
		// ��ȡsession
		Session session = getSession();
		// ��ȡ��ѯ����
		Query query = session.createQuery(hql);
		// ִ�в�ѯ
		List list = query.list();
		return list;
	}

	@Override
	public T findObjectById(Serializable id) {
		return getSession().get(clazz, id);
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		Query query = getSession().createQuery("delete " + clazz.getSimpleName() + " where id in :ids");
		// ������:idsռλ����ֵ
		query.setParameterList("ids", ids);
		// ����ָ��ִ��
		query.executeUpdate();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<T> findObjects(String hql, Integer pageNo, Integer pageSize) {
		// ��ȡsession
		Session session = getSession();
		// ��ȡ��ѯ����
		Query query = session.createQuery(hql);

		// ���÷�ҳ����
		// select * from info limit ��ʼ�к� ��Ҫ��ѯ�ļ�¼��

		query.setFirstResult((pageNo - 1) * pageSize); // ��ʼ�к�
		query.setMaxResults(pageSize); // Ҫ��ѯ�ļ�¼��

		// ִ�в�ѯ
		List list = query.list();
		return list;
	}

	@Override
	public Long findTotalCount() {

		// ���ɲ�ѯ��������
		Query query = getSession().createQuery("select count(1) from " + clazz.getSimpleName());
		// ���ص��е��еĽ��
		Long count = (Long) query.uniqueResult();
		return count;
	}

	@Override
	public List<T> findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {

		// ��ȡsession
		Session session = getSession();
		// ��ȡ��ѯ����
		Query query = session.createQuery(hql);

		// ���ò�ѯ������ֵ
		if (conditions != null && conditions.size() > 0) {
			for (int i = 0; i < conditions.size(); i++) {
				query.setParameter(i, conditions.get(i));
			}
		}

		// ���÷�ҳ����
		// select * from info limit ��ʼ�к� ��Ҫ��ѯ�ļ�¼��

		query.setFirstResult((pageNo - 1) * pageSize); // ��ʼ�к�
		query.setMaxResults(pageSize); // Ҫ��ѯ�ļ�¼��

		// ִ�в�ѯ
		List list = query.list();
		return list;
	}

	@Override
	public Long findTotalCount(String hql, List<Object> conditions) {

		Query query = getSession().createQuery("select count(1) " + hql);

		// ���ò�ѯ������ֵ
		if (conditions != null && conditions.size() > 0) {
			for (int i = 0; i < conditions.size(); i++) {
				query.setParameter(i, conditions.get(i));
			}
		}

		return (Long) query.uniqueResult();
	}

}
