package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.bean.PageResult;

public interface GoodsPositionService {
	// 查询所有
	public List<GoodsPosition> findObjects(String hql);

	// 根据id查询一行数据
	public GoodsPosition findObjectById(Serializable id);

	// 保存
	public void save(GoodsPosition entity);

	// 更新
	public void update(GoodsPosition entity);

	// 删除一行
	public void delete(GoodsPosition entity);

	// 根据id删除多行
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public List<GoodsPosition> findByMailNo(String mailNo);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

}
