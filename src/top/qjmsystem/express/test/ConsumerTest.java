package top.qjmsystem.express.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.qjmsystem.express.bean.Consumer;

import top.qjmsystem.express.service.ConsumerService;

/**
 * @ContextConfiguration :加载spring主配置文件 @RunWith(SpringJUnit4ClassRunner.class):
 *                       使用spring整合junit的测试插件运行测试代码
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumerTest {
	@Autowired
	private ConsumerService consumerService;

	@Test
	public void findObjectsTest() {
		// 查询所有信息
		List<Consumer> consumer = consumerService.findObjects("from Comsumer");
		// System.out.println(consumer);
	}
}
