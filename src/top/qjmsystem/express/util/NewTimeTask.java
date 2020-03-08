package top.qjmsystem.express.util;

import java.util.Random;
import java.util.TimerTask;

public class NewTimeTask extends TimerTask {

    /*public synchronized void refreshNextTime() {
        next_send_time = System.currentTimeMillis() + 120 * 1000;
    }
    private volatile long next_send_time;//下一次发起请求的日期
*/    
    /*@Override  
    public void run() {  
    	try {
            while (true) {
            	  
                long current = System.currentTimeMillis();
                long k = next_send_time - current;
                if (k > 0) {
                	createRandomNumber();
                    Thread.sleep(k);
                } else {
                    //handshake()
                	createRandomNumber();
                    Thread.sleep(6 * 1000);
                }
            }
        } catch (InterruptedException ex) {
        }
        
       // createRandomNumberFromMathRandom();  
    }  */
    
    @Override
    public void run() { 
    	createRandomNumber();
    }
    //用纯Math中的方法来随机生成1-10之间的随机数  
/*    private void createRandomNumberFromMathRandom() {  
        int j=(int)(Math.round(Math.random()*10+1));  
        System.out.println("随机生成的数字为:"+j);  
          
    }  */
    

   



    //用Random类的方式来随机生成1-10之间的随机数  
   public void createRandomNumber(){  
         Random random=new Random(System.currentTimeMillis());  
         int value=random.nextInt();  
         value=Math.abs(value);  
         value=value%100+1;  
         System.out.println("新生成的数字为:"+value);  
         String s = String.valueOf(value);
         timeTaskUtil.setRandomStr(s);
         System.out.println("str:"+s);  
    }  
}
