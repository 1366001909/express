package top.qjmsystem.express.util;

import java.util.Timer;

/**
 * 
 * @author sandy
 * 
 */

public class timeTaskUtil {

	//计时器开启标志
	private static boolean start = false; 
	
	
	private static String randomStr = "";
	
	//timeTak对象，用于产生随机数
	private static NewTimeTask timeTask = new NewTimeTask();
	
	
	private static Timer timer = new Timer();
	
	public synchronized static void refreshNextTime() {
        next_send_time = System.currentTimeMillis() + 180 * 1000;
    }
    private volatile static long next_send_time;//下一次发起请求的日期

    
	


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
	
	//立即刷新取件码
	public static void refresh() {
		refreshNextTime();
		timeTask.createRandomNumber();
	}
	
	//判断是否超时 ,超时返回True,否则返回false
	public static boolean isOutTime() {
	    long current = System.currentTimeMillis();
        long k = next_send_time - current;
        if (k > 0) {
        	return false;
        }
        else return true;
	}


	private static void run() {
		// 程序运行后立刻执行任务，每隔两分钟执行一次
		timer.schedule(timeTask, 0, 3000);
		
	}
	
	
	public static void startTime() {
		start=true;
		run();
	}
	
	
	

}
