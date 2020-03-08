package top.qjmsystem.express.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import top.qjmsystem.express.base.impl.BaseDaoImpl;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.dao.GoodsInfoDao;
//由于基本的增删查改代码被抽取出来,这里不添加其他功能的话只需继承实现类即可，不需写任何代码
//用于将数据访问层的类表示为Spring 中的Bean
@Repository//相当于new的动作
public class GoodsInfoDaoImpl extends BaseDaoImpl<GoodsInfo> implements GoodsInfoDao{

	@Override
	public List<GoodsInfo> findByNum(String num) {
		Query query = getSession().createQuery("from GoodsInfo where Num = ?");
		//设置参数
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
		//设置参数
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
		//设置参数
		query.setParameter(0, tCode);
		query.setParameter(1, gCode);
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			 return true;
		 }
		return false;
	}
	
	
	//根据mailNo返回取件码
	@Override
	public String findgCodeByMailNo(String mailNo) {
		Query query = getSession().createQuery("from GoodsInfo where mailNo = ?");
		//设置参数
		query.setParameter(0, mailNo);
		
		List<GoodsInfo> list = query.list();
		if(list!=null && list.size()>0){
			
			GoodsInfo goodsInfo = (GoodsInfo)(list.get(0));
		
			if(goodsInfo.getState().equals("已签收")) {
				return "已签收";
			}
			 return goodsInfo.getgCode();
		 }
		else return null;
	}


	
	
	
	
	

}
