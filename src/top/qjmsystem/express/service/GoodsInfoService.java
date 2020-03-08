package top.qjmsystem.express.service;

import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.bean.PageResult;

public interface GoodsInfoService {
	// ��ѯ����
	public List<GoodsInfo> findObjects(String hql);

	// ����id��ѯһ������
	public GoodsInfo findObjectById(Serializable id);

	// ����
	public void save(GoodsInfo entity);

	// ����
	public void update(GoodsInfo entity);

	// ɾ��һ��
	public void delete(GoodsInfo entity);

	// ����idɾ������
	public void deleteAll(Serializable[] ids);

	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

	// �������кŷ���������Ϣ
	public List<GoodsInfo> findByNum(String num);

	// ���������뷵��������Ϣ
	public GoodsInfo findBytCode(String tCode);

	public boolean is_MatchByCode(String tCode, String gCode);
	public String findgCodeByMailNo(String mailNo);

	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);
}
