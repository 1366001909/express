package top.qjmsystem.express.base.dao;

import java.io.Serializable;
import java.util.List;

//抽取各层的通用代码
public interface BaseDao<T> {

	// 查询所有
	public List<T> findObjects(String hql);

	// 根据id查询一行数据
	public T findObjectById(Serializable id);

	// 保存
	public void save(T entity);

	// 更新
	public void update(T entity);

	// 删除一行
	public void delete(T entity);

	// 根据id删除多行
	public void deleteAll(Serializable[] ids);

	// 查询所有
	// 重载查询所有（重载：方法名称相同，参数列表不同：参数个数或者类型，与返回值无关）
	/**
	 * 
	 * @param hql
	 *            查询语句
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            页大小
	 * @return
	 */
	public List<T> findObjects(String hql, Integer pageNo, Integer pageSize);

	// 重载查询所有，按条件查询
	/**
	 * 
	 * @param hql
	 *            查询语句
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            页大小
	 * @return
	 */
	public List<T> findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

	// 查询总记录数
	public Long findTotalCount();

	// 查询总记录数，需要按条件查询
	public Long findTotalCount(String hql, List<Object> conditions);
}
