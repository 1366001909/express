package top.qjmsystem.express.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:applicationContext.xml") // 加载spring主配置文件
@RunWith(SpringJUnit4ClassRunner.class) // 使用spring整合junit的测试插件运行测试代码
@Transactional
public class SSHTest {

	@Autowired // 相当于new对象，把对象注入到属性里面
	private SessionFactory sessionFactory;

	@Test
	public void testGetSession() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session=" + session);
	}

}
