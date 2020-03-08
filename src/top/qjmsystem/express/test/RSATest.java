package top.qjmsystem.express.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import top.qjmsystem.express.util.RsaUtil;

public class RSATest {
	@Test
	public void Test() {

		while (true) {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("«Î ‰»Î");
				String mc = stdin.readLine();
				String s = RsaUtil.encryption(mc);
				// String s = RsaUtil.encryption("EMS123456789123");
				String g = RsaUtil.decrypt(s);
				System.out.println("√‹Œƒ" + s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
