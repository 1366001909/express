package top.qjmsystem.express.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qjmsystem.express.dao.UserDao;
import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.bean.User;
import top.qjmsystem.express.service.UserService;


//用于将业务层的类标识为Spring 中的bean
@Service//与@Repository一样 都是让spring去创建对象，并添加到IOC容器中
@Transactional  //注解事务的配置
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findObjects(String hql) {
		return userDao.findObjects(hql);
	}

	@Override
	public User findObjectById(Serializable id) {
		return userDao.findObjectById(id);
	}

	@Override
	public void save(User entity) {
		userDao.save(entity);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		userDao.deleteAll(ids);
	}
	
	
	@Override
	public User findUserByAccountAndPwd(String account, String pwd) {
		return userDao.findUserByAccountAndPwd(account, pwd);
	}

	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		
		//分页查询数据结果
		List<User> items = userDao.findObjects(hql, pageNo, pageSize);
		
		//查询总记录数
		Long totalCount = userDao.findTotalCount();
		
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
	
	
	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// 分页查询数据结果
		List<User> items = userDao.findObjects(hql, conditions, pageNo, pageSize);

		// 查询总记录数
		Long totalCount = userDao.findTotalCount(hql, conditions);

		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}
}
