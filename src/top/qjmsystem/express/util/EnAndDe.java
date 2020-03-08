package top.qjmsystem.express.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
* @Description 说明： 
*              1、只能对数字和字母进行加密, 不涉及编码和解码问题 。 2、不做数字签名和验证,涉及到提取信息摘要。 
*/  
public class EnAndDe {  
  private long p = 0;  
  private long q = 0;  
  private long n = 0;  
  private long t = 0; // 欧拉函数  

  private long e = 0; // 公匙  
  private long d = 0; // 密匙  

  private String mc; // 明文  
  private long c = 0; // 密文  
  private long word = 0; // 解密后明文  

  //初始化产生公钥和密钥
  public void init_noKey() throws Exception {
	  this.inputPQ();
	  this.getPublic_key();
	  this.getPrivate_key();
  }
  //初始化公钥和密钥
  public void init_haveKey() {
	this.p=2137;
	this.q=317773;
	this.n=p*q;
	this.d=68213387;
	this.e=71843;

  }
  
  // 判断是一个数 x 否为素数素数就是判断在 (2,√x)范围内有没有除1外的因数,如果没有则x数素数  
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

  // 随机产生大素数(1e6数量级，注意，太大了要超出范围)  
  public void bigprimeRandom() {  
      do {  
          p = (long) (Math.random() * 1000000);  
      } while (!this.isPrime(p));  
      do {  
          q = (long) (Math.random() * 1000000);  
      } while (p == q || !this.isPrime(q));  
  }  

  // 输入PQ  
  public void inputPQ() throws Exception {  

      this.bigprimeRandom();  
      System.out.println("自动生成两个大素数p,q分别为:" + this.p + " " + this.q);  

      this.n = (long) p * q;  
      this.t = (long) (p - 1) * (q - 1);  

      System.out.println("这两个素数的乘积为p*q：" + this.n);  
      System.out.println("所得的t=(p-1)(q-1)：" + this.t);  
  }  

  // 求最大公约数  
  public long gcd(long a, long b) {  
      long gcd;  
      if (b == 0)  
          gcd = a;  
      else  
          gcd = gcd(b, a % b);  
      return gcd;  

  }  

	// 生成公匙
	public void getPublic_key() throws Exception {
		if ( this.e == 0) {
			do {

				this.e = (long) (Math.random() * 100000);
				// e满足 e∈(1, ψ(n))且e与ψ(n)最大公约数为1,即 e与t互质
			} while ((this.e >= this.t) || (this.gcd(this.t, this.e) != 1));
			System.out.println("生成的公钥为：" + "(" + this.n + "," + this.e + ")");
		}
	}

  // 生成私钥 e*d=1(modψ(n))==> d = (kψ(n)+1) / e  
	public void getPrivate_key() {
		if ( this.d == 0) {

			long value = 1; // value 是e和d的乘积
			outer: for (long k = 1;; k++) {
				value = k * this.t + 1;
				if ((value % this.e == 0)) {
					this.d = value / this.e;
					break outer;
				}
			}
			System.out.println("产生的一个私钥为：" + "(" + this.n + "," + this.d + ")");
		}
	}

  // 输入明文  
  public void getText() throws Exception {  
      System.out.println("请输入明文：");  
      BufferedReader stdin = new BufferedReader(new InputStreamReader(  
              System.in));  
      mc = stdin.readLine();  

  }  
  
  //传入明文
  public void getText(String test) throws Exception {  
      System.out.println("明文：" + test);  
      mc =  test;
  }  

  // 加密密文  
  public String encryption(String test) throws Exception {  
      this.getText(test);  
      System.out.println("输入明文为: " + this.mc);  
      // 加密  
      ArrayList cestr = new ArrayList();  
      for (int i = 0; i < mc.length(); i++) {  
          this.c = this.colum((long) mc.charAt(i), this.n, this.e);  
          cestr.add(c);  
      }  
      String miwen = cestr.toString().substring(1, cestr.toString().length()-1);
      System.out.println("加密后所得的密文为：" + miwen);  
     
      return miwen;

  }  
  
  public String decrypt(String test) throws Exception{
	// 解密  
	  String s =test.toString();
      
	  ArrayList cestr =  new ArrayList(Arrays.asList(s.split(", ")));
	  System.out.println("cestr"+cestr);
	  
      StringBuffer destr = new StringBuffer();  
      for (int j = 0; j < cestr.size(); j++) {  
          this.word = this.colum(Long.parseLong(cestr.get(j).toString()),  
                  this.n, this.d);  
          destr.append((char) word);  
      }  
      System.out.println("解密后所得的明文为：" + destr);  
      return new String(destr);
  }

  // 加密、解密计算  
  public long colum(long mc, long n, long key) {  
      BigInteger bigy = new BigInteger(String.valueOf(mc));  
      BigInteger bign = new BigInteger(String.valueOf(n));  
      BigInteger bigkey = new BigInteger(String.valueOf(key));  
      return Long.parseLong(bigy.modPow(bigkey, bign).toString());// 备注1  
  }  
}
