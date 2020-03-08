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
 * @ContextConfiguration :����spring�������ļ� @RunWith(SpringJUnit4ClassRunner.class):
 *                       ʹ��spring����junit�Ĳ��Բ�����в��Դ���
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumerTest {
	@Autowired
	private ConsumerService consumerService;

	@Test
	public void findObjectsTest() {
		// ��ѯ������Ϣ
		List<Consumer> consumer = consumerService.findObjects("from Comsumer");
		// System.out.println(consumer);
	}
}
