package top.qjmsystem.express.util;

import java.util.Timer;

/**
 * 
 * @author sandy
 * 
 */

public class timeTaskUtil {

	//��ʱ��������־
	private static boolean start = false; 
	
	
	private static String randomStr = "";
	
	//timeTak�������ڲ��������
	private static NewTimeTask timeTask = new NewTimeTask();
	
	
	private static Timer timer = new Timer();
	
	public synchronized static void refreshNextTime() {
        next_send_time = System.currentTimeMillis() + 180 * 1000;
    }
    private volatile static long next_send_time;//��һ�η������������

    
	


	public static long getNext_send_time() {
		return next_send_time;
	}


	public static void setNext_send_time(long next_send_time) {
		timeTaskUtil.next_send_time = next_send_time;
	}


	public static String getRandomStr() {
		return randomStr;
	}


	public static void setRandomStr(String randomStr) {
		timeTaskUtil.randomStr = randomStr;
	}

	public static boolean isStart() {
		return start;
	}


	public static void setStart(boolean start) {
		timeTaskUtil.start = start;
	}
	
	//����ˢ��ȡ����
	public static void refresh() {
		refreshNextTime();
		timeTask.createRandomNumber();
	}
	
	//�ж��Ƿ�ʱ ,��ʱ����True,���򷵻�false
	public static boolean isOutTime() {
	    long current = System.currentTimeMillis();
        long k = next_send_time - current;
        if (k > 0) {
        	return false;
        }
        else return true;
	}


	private static void run() {
		// �������к�����ִ������ÿ��������ִ��һ��
		timer.schedule(timeTask, 0, 3000);
		
	}
	
	
	public static void startTime() {
		start=true;
		run();
	}
	
	
	

}
