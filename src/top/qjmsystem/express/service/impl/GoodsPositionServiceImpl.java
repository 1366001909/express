package top.qjmsystem.express.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.bean.PageResult;

import top.qjmsystem.express.dao.GoodsPositionDao;
import top.qjmsystem.express.service.GoodsPositionService;


//���ڽ�ҵ�������ʶΪSpring �е�bean
@Service//��@Repositoryһ�� ������springȥ�������󣬲���ӵ�IOC������
@Transactional  //ע�����������
public class GoodsPositionServiceImpl implements GoodsPositionService{
	@Autowired
	private GoodsPositionDao goodsPositionDao;

	@Override
	public List<GoodsPosition> findObjects(String hql) {
		return goodsPositionDao.findObjects(hql);
	}

	@Override
	public GoodsPosition findObjectById(Serializable id) {
		return goodsPositionDao.findObjectById(id);
	}

	@Override
	public void save(GoodsPosition entity) {
		goodsPositionDao.save(entity);
	}

	@Override
	public void update(GoodsPosition entity) {
		goodsPositionDao.update(entity);
	}

	@Override
	public void delete(GoodsPosition entity) {
		goodsPositionDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		goodsPositionDao.deleteAll(ids);
	}
	
	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		
		//��ҳ��ѯ���ݽ��
		List<GoodsPosition> items = goodsPositionDao.findObjects(hql, pageNo, pageSize);
		
		//��ѯ�ܼ�¼��
		Long totalCount = goodsPositionDao.findTotalCount();
		
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public List<GoodsPosition> findByMailNo(String mailNo) {
		
		return goodsPositionDao.findByMailNo(mailNo);
	}
	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// ��ҳ��ѯ���ݽ��
		List<GoodsPosition> items = goodsPositionDao.findObjects(hql, conditions, pageNo, pageSize);

		// ��ѯ�ܼ�¼��
		Long totalCount = goodsPositionDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
}
