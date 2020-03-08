package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.bean.PageResult;

public interface GoodsPositionService {
	// ��ѯ����
	public List<GoodsPosition> findObjects(String hql);

	// ����id��ѯһ������
	public GoodsPosition findObjectById(Serializable id);

	// ����
	public void save(GoodsPosition entity);

	// ����
	public void update(GoodsPosition entity);

	// ɾ��һ��
	public void delete(GoodsPosition entity);

	// ����idɾ������
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	public List<GoodsPosition> findByMailNo(String mailNo);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);

}
