package top.qjmsystem.express.util;

public class RsaUtil {
private static EnAndDe Rsa = new EnAndDe();
private static boolean isInit = false;
//����
private static void init(){
	//System.out.println("RsaUtil��ʼ��--����");
	try {
		//���úù�Կ����Կ
		Rsa.init_haveKey();
		//Rsa.setInitcKey();
	} catch (Exception e) {
		System.out.println("��ʼ������");
		e.printStackTrace();
	}
	//System.out.println("��ʼ���ɹ�");
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
		//System.out.println("����ʧ��");
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
		//System.out.println("����ʧ��");
		return null;
	}	
}
}
