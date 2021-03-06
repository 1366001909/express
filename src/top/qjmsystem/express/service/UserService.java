package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.bean.User;

public interface UserService {
	// 查询所有
	public List<User> findObjects(String hql);

	// 根据id查询一行数据
	public User findObjectById(Serializable id);

	// 保存
	public void save(User entity);

	// 更新
	public void update(User entity);

	// 删除一行
	public void delete(User entity);

	// 根据id删除多行
	public void deleteAll(Serializable[] ids);

	// 根据账号和密码查询用户
	/**
	 * 
	 * @param account
	 *            账号
	 * @param pwd
	 *            密码
	 * @return 用户对象
	 */
	public User findUserByAccountAndPwd(String account, String pwd);

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

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	// 重载查询所有（重载：方法名称相同，参数列表不同：参数个数或者类型，与返回值无关）
	/**
	 * 
	 * @param hql
	 *            查询语句
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            页大小
	 * @condition 查询条件
	 * @return
	 */
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);
}
