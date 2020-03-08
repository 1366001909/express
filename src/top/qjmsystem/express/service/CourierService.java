package top.qjmsystem.express.service;
import java.io.Serializable;
import java.util.List;

import top.qjmsystem.express.bean.PageResult;
import top.qjmsystem.express.bean.Courier;

public interface CourierService {
	// ��ѯ����
		public List<Courier> findObjects(String hql);

		// ����id��ѯһ������
		public Courier findObjectById(Serializable id);

		// ����
		public void save(Courier entity);

		// ����
		public void update(Courier entity);

		// ɾ��һ��
		public void delete(Courier entity);

		// ����idɾ������
		public void deleteAll(Serializable[] ids);

		// �����˺ź������ѯ�û�
		/**
		 * 
		 * @param account
		 *            �˺�
		 * @param pwd
		 *            ����
		 * @return �û�����
		 */
		public Courier findCourierByAccountAndPwd(String account, String pwd);

		/**
		 * 
		 * @param openid ���Ա�ṩopenid���������֤
		 * @return
		 */
		public Courier findCourierByOpenid(String openid);
		// ��ѯ����
		// ���ز�ѯ���У����أ�����������ͬ�������б�ͬ�����������������ͣ��뷵��ֵ�޹أ�
		/**
		 * 
		 * @param hql
		 *            ��ѯ���
		 * @param pageNo
		 *            ��ǰҳ��
		 * @param pageSize
		 *            ҳ��С
		 * @return
		 */

		public PageResult findObjects(String hql, Integer pageNo, Integer pageSize);

		// ���ز�ѯ���У����أ�����������ͬ�������б�ͬ�����������������ͣ��뷵��ֵ�޹أ�
		/**
		 * 
		 * @param hql
		 *            ��ѯ���
		 * @param pageNo
		 *            ��ǰҳ��
		 * @param pageSize
		 *            ҳ��С
		 * @condition ��ѯ����
		 * @return
		 */
		public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize);
}
