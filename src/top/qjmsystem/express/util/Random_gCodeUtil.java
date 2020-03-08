package top.qjmsystem.express.util;

public class Random_gCodeUtil {
	
public static long getNextSendTime() {
	return System.currentTimeMillis() + 180 * 1000;
}

public static boolean isOutTime(long time) {
	long k = time - System.currentTimeMillis();
	if(time - System.currentTimeMillis()>0) {
		return false;
	}else {
		return true;
	}
}



}
