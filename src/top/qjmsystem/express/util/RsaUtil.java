package top.qjmsystem.express.util;

public class RsaUtil {
private static EnAndDe Rsa = new EnAndDe();
private static boolean isInit = false;
//加密
private static void init(){
	//System.out.println("RsaUtil初始化--构造");
	try {
		//设置好公钥和密钥
		Rsa.init_haveKey();
		//Rsa.setInitcKey();
	} catch (Exception e) {
		System.out.println("初始化错误");
		e.printStackTrace();
	}
	//System.out.println("初始化成功");
}
public  static String encryption(String test) {
	try {
		if(isInit == false) {
			init();
			isInit = true;
		}
		return Rsa.encryption(test);
	} catch (Exception e) {
		e.printStackTrace();
		//System.out.println("加密失败");
		return null;
	}	
}


public  static String decrypt(String test) {
	try {
		if(isInit == false) {
			init();
			isInit = true;
		}
		return Rsa.decrypt(test);
	} catch (Exception e) {
		e.printStackTrace();
		//System.out.println("解密失败");
		return null;
	}	
}
}
