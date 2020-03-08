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

	// 反射技术获取T对应的实际类型
	public BaseDaoImpl() {
		// 代表T
		Type type = this.getClass().getGenericSuperclass();
		// 获取Type的参数类型
		ParameterizedType pt = (ParameterizedType) type;
		// 获取T的实际代表的类型
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		// System.out.println("泛型T代表的实际类型："+clazz);
		// System.out.println(clazz.getSimpleName());
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<T> findObjects(String hql) {
		// 获取session
		Session session = getSession();
		// 获取查询对象
		Query query = session.createQuery(hql);
		// 执行查询
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
		// 设置了:ids占位符的值
		query.setParameterList("ids", ids);
		// 发送指令执行
		query.executeUpdate();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<T> findObjects(String hql, Integer pageNo, Integer pageSize) {
		// 获取session
		Session session = getSession();
		// 获取查询对象
		Query query = session.createQuery(hql);

		// 设置分页参数
		// select * from info limit 起始行号 ，要查询的记录数

		query.setFirstResult((pageNo - 1) * pageSize); // 起始行号
		query.setMaxResults(pageSize); // 要查询的记录数

		// 执行查询
		List list = query.list();
		return list;
	}

	@Override
	public Long findTotalCount() {

		// 生成查询操作对象
		Query query = getSession().createQuery("select count(1) from " + clazz.getSimpleName());
		// 返回单行单列的结果
		Long count = (Long) query.uniqueResult();
		return count;
	}

	@Override
	public List<T> findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {

		// 获取session
		Session session = getSession();
		// 获取查询对象
		Query query = session.createQuery(hql);

		// 设置查询参数的值
		if (conditions != null && conditions.size() > 0) {
			for (int i = 0; i < conditions.size(); i++) {
				query.setParameter(i, conditions.get(i));
			}
		}

		// 设置分页参数
		// select * from info limit 起始行号 ，要查询的记录数

		query.setFirstResult((pageNo - 1) * pageSize); // 起始行号
		query.setMaxResults(pageSize); // 要查询的记录数

		// 执行查询
		List list = query.list();
		return list;
	}

	@Override
	public Long findTotalCount(String hql, List<Object> conditions) {

		Query query = getSession().createQuery("select count(1) " + hql);

		// 设置查询参数的值
		if (conditions != null && conditions.size() > 0) {
			for (int i = 0; i < conditions.size(); i++) {
				query.setParameter(i, conditions.get(i));
			}
		}

		return (Long) query.uniqueResult();
	}

}
