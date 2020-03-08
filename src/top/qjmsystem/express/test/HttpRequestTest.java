package top.qjmsystem.express.test;

import top.qjmsystem.express.bean.HttpRequest;
import top.qjmsystem.express.bean.Wparam;

/*
 * https://api.weixin.qq.com/sns/jscode2session?appid=wx50ed494c861227ec
 * &secret=481c61cfeb04e66808451a1db74f6c0a
 * &js_code=033c9t5S0mcBa82KPf5S0AIq5S0c9t5a
 * &grant_type=authorization_code
 */
public class HttpRequestTest {
	public static void main(String[] args) {
		// ���� GET ����
		
		Wparam wparam=new Wparam();
		wparam.setAppid("wx50ed494c861227ec");
		wparam.setJs_code("033c9t5S0mcBa82KPf5S0AIq5S0c9t5a");
		wparam.setSecret("481c61cfeb04e66808451a1db74f6c0a");
		String s = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session",
				wparam.toParam());
		System.out.println(s);

		// ���� POST ����
		String sr = HttpRequest.sendPost("https://api.weixin.qq.com/sns/jscode2session",
				wparam.toParam());
		System.out.println(sr);
	}
}
