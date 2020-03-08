package top.qjmsystem.express.dao;

import java.util.List;

import top.qjmsystem.express.base.dao.BaseDao;
import top.qjmsystem.express.bean.GoodsInfo;

public interface GoodsInfoDao extends BaseDao<GoodsInfo>{

	List<GoodsInfo> findByNum(String num);
    GoodsInfo findBytCode(String tCode);
    
    /**
     * 
     * @param tCode运输码
     * @param gCode取件码
     * @return  是否匹配,匹配返回true,否则返回false
     */
    boolean is_MatchByCode(String tCode, String gCode);
	String findgCodeByMailNo(String mailNo);
	

    
    
   
}
