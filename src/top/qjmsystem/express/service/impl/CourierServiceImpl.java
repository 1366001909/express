package top.qjmsystem.express.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.dao.CourierDao;
import top.qjmsystem.express.service.CourierService;


//用于将业务层的类标识为Spring 中的bean
@Service//与@Repository一样 都是让spring去创建对象，并添加到IOC容器中
@Transactional  //注解事务的配置
public class CourierServiceImpl implements CourierService{
	@Autowired
	private CourierDao CourierDao;

	@Override
	public List<Courier> findObjects(String hql) {
		return CourierDao.findObjects(hql);
	}

	@Override
	public Courier findObjectById(Serializable id) {
		return CourierDao.findObjectById(id);
	}

	@Override
	public void save(Courier entity) {
		CourierDao.save(entity);
	}

	@Override
	public void update(Courier entity) {
		CourierDao.update(entity);
	}

	@Override
	public void delete(Courier entity) {
		CourierDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		CourierDao.deleteAll(ids);
	}
	
	
	@Override
	public Courier findCourierByAccountAndPwd(String account, String pwd) {
		return CourierDao.findCourierByAccountAndPwd(account, pwd);
	}
	
	@Override
	public Courier findCourierByOpenid(String openid) {
		return CourierDao.findCourierByOpenid(openid);
	}

	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		
		//分页查询数据结果
		List<Courier> items = CourierDao.findObjects(hql, pageNo, pageSize);
		
		//查询总记录数
		Long totalCount = CourierDao.findTotalCount();
		
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
	
	
	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// 分页查询数据结果
		List<Courier> items = CourierDao.findObjects(hql, conditions, pageNo, pageSize);

		// 查询总记录数
		Long totalCount = CourierDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
}
