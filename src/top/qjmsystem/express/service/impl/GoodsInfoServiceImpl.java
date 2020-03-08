package top.qjmsystem.express.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.dao.GoodsInfoDao;
import top.qjmsystem.express.service.GoodsInfoService;

//���ڽ�ҵ�������ʶΪSpring �е�bean
@Service//��@Repositoryһ�� ������springȥ�������󣬲���ӵ�IOC������
@Transactional  //ע�����������
public class GoodsInfoServiceImpl implements GoodsInfoService{
	@Autowired
	private GoodsInfoDao goodsInfoDao;

	@Override
	public List<GoodsInfo> findObjects(String hql) {
		return goodsInfoDao.findObjects(hql);
	}

	@Override
	public GoodsInfo findObjectById(Serializable id) {
		return goodsInfoDao.findObjectById(id);
	}

	@Override
	public void save(GoodsInfo entity) {
		goodsInfoDao.save(entity);
	}

	@Override
	public void update(GoodsInfo entity) {
		goodsInfoDao.update(entity);
	}

	@Override
	public void delete(GoodsInfo entity) {
		goodsInfoDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		goodsInfoDao.deleteAll(ids);
	}
	
	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		
		//��ҳ��ѯ���ݽ��
		List<GoodsInfo> items = goodsInfoDao.findObjects(hql, pageNo, pageSize);
		
		//��ѯ�ܼ�¼��
		Long totalCount = goodsInfoDao.findTotalCount();
		
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public List<GoodsInfo> findByNum(String num) {
		
		return goodsInfoDao.findByNum(num);
	}

	@Override
	public GoodsInfo findBytCode(String tCode) {
		return goodsInfoDao.findBytCode(tCode);
	}
	
	public boolean is_MatchByCode(String tCode, String gCode) {
		return goodsInfoDao.is_MatchByCode(tCode, gCode);
	}
	
	
	
	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// ��ҳ��ѯ���ݽ��
		List<GoodsInfo> items = goodsInfoDao.findObjects(hql, conditions, pageNo, pageSize);

		// ��ѯ�ܼ�¼��
		Long totalCount = goodsInfoDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
	
	
	@Override
	public String findgCodeByMailNo(String mailNo) {
		return goodsInfoDao.findgCodeByMailNo(mailNo);
	}
}
