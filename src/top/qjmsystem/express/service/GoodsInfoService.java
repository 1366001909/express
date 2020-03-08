package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.bean.PageResult;

public interface GoodsInfoService {
	// 查询所有
	public List<GoodsInfo> findObjects(String hql);

	// 根据id查询一行数据
	public GoodsInfo findObjectById(Serializable id);

	// 保存
	public void save(GoodsInfo entity);

	// 更新
	public void update(GoodsInfo entity);

	// 删除一行
	public void delete(GoodsInfo entity);

	// 根据id删除多行
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	// 根据序列号返回物流信息
	public List<GoodsInfo> findByNum(String num);

	// 根据运输码返回物流信息
	public GoodsInfo findBytCode(String tCode);

	public boolean is_MatchByCode(String tCode, String gCode);
	public String findgCodeByMailNo(String mailNo);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);
}
