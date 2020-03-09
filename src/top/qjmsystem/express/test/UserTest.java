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
 * @ContextConfiguration :����spring�������ļ� @RunWith(SpringJUnit4ClassRunner.class):
 *                       ʹ��spring����junit�Ĳ��Բ�����в��Դ���
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void findObjectsTest() {
		// ��ѯ������Ϣ
		List<User> users = userService.findObjects("from User");
		System.out.println(users);
<<<<<<< HEAD
		System.out.println("right...���Գ�ͻ");
=======
		System.out.println("left...���Գ�ͻ");
>>>>>>> branch 'master' of https://github.com/1366001909/express.git
	}
}