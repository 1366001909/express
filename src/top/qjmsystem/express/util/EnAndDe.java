package top.qjmsystem.express.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
* @Description ˵���� 
*              1��ֻ�ܶ����ֺ���ĸ���м���, ���漰����ͽ������� �� 2����������ǩ������֤,�漰����ȡ��ϢժҪ�� 
*/  
public class EnAndDe {  
  private long p = 0;  
  private long q = 0;  
  private long n = 0;  
  private long t = 0; // ŷ������  

  private long e = 0; // ����  
  private long d = 0; // �ܳ�  

  private String mc; // ����  
  private long c = 0; // ����  
  private long word = 0; // ���ܺ�����  

  //��ʼ��������Կ����Կ
  public void init_noKey() throws Exception {
	  this.inputPQ();
	  this.getPublic_key();
	  this.getPrivate_key();
  }
  //��ʼ����Կ����Կ
  public void init_haveKey() {
	this.p=2137;
	this.q=317773;
	this.n=p*q;
	this.d=68213387;
	this.e=71843;

  }
  
  // �ж���һ���� x ��Ϊ�������������ж��� (2,��x)��Χ����û�г�1�������,���û����x������  
  public boolean isPrime(long t) {  
      long k = 0;  
      k = (long) Math.sqrt((double) t);  
      for (int i = 2; i <= k; i++) {  
          if ((t % i) == 0) {  
              return false;  
          }  
      }  
      return true;  
  }  

  // �������������(1e6��������ע�⣬̫����Ҫ������Χ)  
  public void bigprimeRandom() {  
      do {  
          p = (long) (Math.random() * 1000000);  
      } while (!this.isPrime(p));  
      do {  
          q = (long) (Math.random() * 1000000);  
      } while (p == q || !this.isPrime(q));  
  }  

  // ����PQ  
  public void inputPQ() throws Exception {  

      this.bigprimeRandom();  
      System.out.println("�Զ���������������p,q�ֱ�Ϊ:" + this.p + " " + this.q);  

      this.n = (long) p * q;  
      this.t = (long) (p - 1) * (q - 1);  

      System.out.println("�����������ĳ˻�Ϊp*q��" + this.n);  
      System.out.println("���õ�t=(p-1)(q-1)��" + this.t);  
  }  

  // �����Լ��  
  public long gcd(long a, long b) {  
      long gcd;  
      if (b == 0)  
          gcd = a;  
      else  
          gcd = gcd(b, a % b);  
      return gcd;  

  }  

	// ���ɹ���
	public void getPublic_key() throws Exception {
		if ( this.e == 0) {
			do {

				this.e = (long) (Math.random() * 100000);
				// e���� e��(1, ��(n))��e���(n)���Լ��Ϊ1,�� e��t����
			} while ((this.e >= this.t) || (this.gcd(this.t, this.e) != 1));
			System.out.println("���ɵĹ�ԿΪ��" + "(" + this.n + "," + this.e + ")");
		}
	}

  // ����˽Կ e*d=1(mod��(n))==> d = (k��(n)+1) / e  
	public void getPrivate_key() {
		if ( this.d == 0) {

			long value = 1; // value ��e��d�ĳ˻�
			outer: for (long k = 1;; k++) {
				value = k * this.t + 1;
				if ((value % this.e == 0)) {
					this.d = value / this.e;
					break outer;
				}
			}
			System.out.println("������һ��˽ԿΪ��" + "(" + this.n + "," + this.d + ")");
		}
	}

  // ��������  
  public void getText() throws Exception {  
      System.out.println("���������ģ�");  
      BufferedReader stdin = new BufferedReader(new InputStreamReader(  
              System.in));  
      mc = stdin.readLine();  

  }  
  
  //��������
  public void getText(String test) throws Exception {  
      System.out.println("���ģ�" + test);  
      mc =  test;
  }  

  // ��������  
  public String encryption(String test) throws Exception {  
      this.getText(test);  
      System.out.println("��������Ϊ: " + this.mc);  
      // ����  
      ArrayList cestr = new ArrayList();  
      for (int i = 0; i < mc.length(); i++) {  
          this.c = this.colum((long) mc.charAt(i), this.n, this.e);  
          cestr.add(c);  
      }  
      String miwen = cestr.toString().substring(1, cestr.toString().length()-1);
      System.out.println("���ܺ����õ�����Ϊ��" + miwen);  
     
      return miwen;

  }  
  
  public String decrypt(String test) throws Exception{
	// ����  
	  String s =test.toString();
      
	  ArrayList cestr =  new ArrayList(Arrays.asList(s.split(", ")));
	  System.out.println("cestr"+cestr);
	  
      StringBuffer destr = new StringBuffer();  
      for (int j = 0; j < cestr.size(); j++) {  
          this.word = this.colum(Long.parseLong(cestr.get(j).toString()),  
                  this.n, this.d);  
          destr.append((char) word);  
      }  
      System.out.println("���ܺ����õ�����Ϊ��" + destr);  
      return new String(destr);
  }

  // ���ܡ����ܼ���  
  public long colum(long mc, long n, long key) {  
      BigInteger bigy = new BigInteger(String.valueOf(mc));  
      BigInteger bign = new BigInteger(String.valueOf(n));  
      BigInteger bigkey = new BigInteger(String.valueOf(key));  
      return Long.parseLong(bigy.modPow(bigkey, bign).toString());// ��ע1  
  }  
}
