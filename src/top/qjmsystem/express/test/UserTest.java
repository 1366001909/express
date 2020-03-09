package top.qjmsystem.express.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import top.qjmsystem.express.bean.User;
import top.qjmsystem.express.service.UserService;

/**
 * @ContextConfiguration :加载spring主配置文件 @RunWith(SpringJUnit4ClassRunner.class):
 *                       使用spring整合junit的测试插件运行测试代码
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void findObjectsTest() {
		// 查询所有信息
		List<User> users = userService.findObjects("from User");
		System.out.println(users);
<<<<<<< HEAD
		System.out.println("right...测试冲突");
=======
		System.out.println("left...测试冲突");
>>>>>>> branch 'master' of https://github.com/1366001909/express.git
	}
}