package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.PageResult;

public interface ConsumerService {
	// 查询所有
	public List<Consumer> findObjects(String hql);

	// 根据id查询一行数据
	public Consumer findObjectById(Serializable id);

	// 保存
	public void save(Consumer entity);

	// 更新
	public void update(Consumer entity);

	// 删除一行
	public void delete(Consumer entity);

	// 根据id删除多行
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public Consumer findByWetChatAccounts(String wetChatAccounts);
	public Consumer findByOpenid(String openid);

	public Consumer findByNum(String num);

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
