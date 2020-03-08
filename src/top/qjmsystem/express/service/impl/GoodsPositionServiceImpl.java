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


//用于将业务层的类标识为Spring 中的bean
@Service//与@Repository一样 都是让spring去创建对象，并添加到IOC容器中
@Transactional  //注解事务的配置
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
		
		//分页查询数据结果
		List<GoodsPosition> items = goodsPositionDao.findObjects(hql, pageNo, pageSize);
		
		//查询总记录数
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
		// 分页查询数据结果
		List<GoodsPosition> items = goodsPositionDao.findObjects(hql, conditions, pageNo, pageSize);

		// 查询总记录数
		Long totalCount = goodsPositionDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
}
