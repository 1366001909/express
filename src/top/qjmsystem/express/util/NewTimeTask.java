package top.qjmsystem.express.util;

import java.util.Random;
import java.util.TimerTask;

public class NewTimeTask extends TimerTask {

    /*public synchronized void refreshNextTime() {
        next_send_time = System.currentTimeMillis() + 120 * 1000;
    }
    private volatile long next_send_time;//��һ�η������������
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
    //�ô�Math�еķ������������1-10֮��������  
/*    private void createRandomNumberFromMathRandom() {  
        int j=(int)(Math.round(Math.random()*10+1));  
        System.out.println("������ɵ�����Ϊ:"+j);  
          
    }  */
    

   



    //��Random��ķ�ʽ���������1-10֮��������  
   public void createRandomNumber(){  
         Random random=new Random(System.currentTimeMillis());  
         int value=random.nextInt();  
         value=Math.abs(value);  
         value=value%100+1;  
         System.out.println("�����ɵ�����Ϊ:"+value);  
         String s = String.valueOf(value);
         timeTaskUtil.setRandomStr(s);
         System.out.println("str:"+s);  
    }  
}
