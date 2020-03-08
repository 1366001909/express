package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.dao.GoodsInfoDao;
//���ڻ�������ɾ��Ĵ��뱻��ȡ����,���ﲻ����������ܵĻ�ֻ��̳�ʵ���༴�ɣ�����д�κδ���
//���ڽ����ݷ��ʲ�����ʾΪSpring �е�Bean
@Repository//�൱��new�Ķ���
public class GoodsInfoDaoImpl extends BaseDaoImpl<GoodsInfo> implements GoodsInfoDao{

	@Override
	public List<GoodsInfo> findByNum(String num) {
		Query query = getSession().createQuery("from GoodsInfo where Num = ?");
		//���ò���
		query.setParameter(0, num);
		
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

	@Override
	public GoodsInfo findBytCode(String tCode) {
		Query query = getSession().createQuery("from GoodsInfo where tCode = ?");
		//���ò���
		query.setParameter(0, tCode);
		
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			 return (GoodsInfo)list.get(0);
		 }
		 return null;
	}

	@Override
	public boolean is_MatchByCode(String tCode, String gCode) {
		Query query = getSession().createQuery("from GoodsInfo where tCode = ? And gCode = ?");
		//���ò���
		query.setParameter(0, tCode);
		query.setParameter(1, gCode);
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			 return true;
		 }
		return false;
	}
	
	
	//����mailNo����ȡ����
	@Override
	public String findgCodeByMailNo(String mailNo) {
		Query query = getSession().createQuery("from GoodsInfo where mailNo = ?");
		//���ò���
		query.setParameter(0, mailNo);
		
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			
			GoodsInfo goodsInfo = (GoodsInfo)(list.get(0));
		
			if(goodsInfo.getState().equals("��ǩ��")) {
				return "��ǩ��";
			}
			 return goodsInfo.getgCode();
		 }
		else return null;
	}


	
	
	
	
	

}
