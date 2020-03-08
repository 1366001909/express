package top.qjmsystem.express.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import top.qjmsystem.express.util.Random_gCodeUtil;
import top.qjmsystem.express.util.timeTaskUtil;

public class TimeTaskTest {
public static void main(String args[]) {
	timeTaskUtil.startTime();
	System.out.println("«Î ‰»Î");
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	timeTaskUtil.refresh();
;
}
}
