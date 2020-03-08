package top.qjmsystem.express.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:applicationContext.xml") // ����spring�������ļ�
@RunWith(SpringJUnit4ClassRunner.class) // ʹ��spring����junit�Ĳ��Բ�����в��Դ���
@Transactional
public class SSHTest {

	@Autowired // �൱��new���󣬰Ѷ���ע�뵽��������
	private SessionFactory sessionFactory;

	@Test
	public void testGetSession() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session=" + session);
	}

}
