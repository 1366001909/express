package top.qjmsystem.express.action;

import java.io.IOException;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.bean.HttpRequest;
import top.qjmsystem.express.bean.Wparam;
import top.qjmsystem.express.service.ConsumerService;
import top.qjmsystem.express.service.GoodsInfoService;
import top.qjmsystem.express.service.GoodsPositionService;
import top.qjmsystem.express.util.JsonUtil;
import top.qjmsystem.express.util.Random_gCodeUtil;
import top.qjmsystem.express.util.RsaUtil;

public class WetChatAction {

	@Autowired
	private GoodsPositionService goodsPositionService;
	@Autowired
	private GoodsInfoService goodsInfoService;
	@Autowired
	private ConsumerService consumerService;

	// 用于封装微信小程序传递过来的值,用于修改信息
	private Consumer consumer;

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// 初始化设置
	private void init() throws IOException {
		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 加上这一句才能解决(运行本页面)乱码
		response.setHeader("content-type", "text/html;charset=UTF-8");

		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}

	// 通过微信号查得用户个人信息
	public void findByWetChatAccounts() throws IOException {
		init();
		Writer out = response.getWriter();

		// 根据微信小程序发送过来的微信号信息进行查询，并返回json数组
		String Accounts = request.getParameter("wetChatAccounts");

		if (Accounts == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				Accounts = obj.getString("wetChatAccounts");
			} else {
				Accounts = null;
			}

		}

		if (Accounts != null) {
			Consumer consumer = new Consumer();

			consumer = consumerService.findByWetChatAccounts(Accounts);
			if (consumer == null) {
				out.append("没有查到任何信息，请检查微信号有没有错误");
			} else {
				JSONObject json = JSONObject.fromObject(consumer);// 将java对象转换为json对象
				String str = json.toString();// 将json对象转换为字符串
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"你已经进入后台，但wetChatAccounts为空\"");
		}

	}

	// 通过openid查得用户个人信息
	public void findByOpenid() throws IOException {
		init();
		Writer out = response.getWriter();

		// 根据微信小程序发送过来的微信号信息进行查询，并返回json数组
		String openid = request.getParameter("openid");

		if (openid == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				openid = obj.getString("openid");
			} else {
				openid = null;
			}

		}

		if (openid != null) {
			Consumer consumer = new Consumer();

			consumer = consumerService.findByOpenid(openid);
			if (consumer == null) {
				out.append("没有查到任何信息，请检查openid有没有错误");
			} else {
				JSONObject json = JSONObject.fromObject(consumer);// 将java对象转换为json对象
				String str = json.toString();// 将json对象转换为字符串
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"你已经进入后台，但openid为空\"");
		}

	}

	// 修改個人信息
	public void updateConsumer() throws IOException {
		init();
		String jsonStr = request.getParameter("JsonStr");
		Writer out = response.getWriter();

		if (jsonStr == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				jsonStr = obj.getString("JsonStr");
			} else {
				jsonStr = null;
			}
		}

		if (jsonStr == null) {
			out.write("JsonStr为null");
		} else {
			JSONObject obj = JSONObject.fromObject(jsonStr);// 将json字符串转换为json对象
			// System.out.println(obj);
			// 将json对象转换为java对象
			consumer = (Consumer) JSONObject.toBean(obj, Consumer.class);// 将建json对象转换为Consumer对象
			consumerService.update(consumer);
			out.write("修改成功");
		}

	}

	// 提供序列号 返回取件码信息

	public void getGoodsInfo() throws IOException {
		init();

		Writer out = response.getWriter();
		// 根据微信小程序发送过来的微信号信息进行查询，并返回json数组
		String num = request.getParameter("Num");

		if (num == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				num = obj.getString("Num");
			} else {
				num = null;
			}
		}

		if (num != null) {
			List<GoodsInfo> list = goodsInfoService.findByNum(num);
			//
			List<GoodsInfo> rsalist = new ArrayList<GoodsInfo>();

			if (list == null) {
				out.append("没有查到任何信息，请检查微信号有没有错误");
			} else {
				for (GoodsInfo str : list) {
					String rsaTCode = str.gettCode();
					str.setTCode(RsaUtil.encryption(rsaTCode));

					// 对取件码添加随机码后缀
					str.setGCode(str.getgCode() + Random_gCodeUtil.getNextSendTime());
					rsalist.add(str);
				}
				JSONArray json = JSONArray.fromObject(rsalist);// 将java对象转换为json对象
				String str = json.toString();// 将json对象转换为字符串
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"你已经进入后台，Num为空\"");
		}
	}

	// 根据提供的mailNo返回定位信息

	public void getGoodsPosition() throws IOException {
		init();

		Writer out = response.getWriter();
		// 根据微信小程序发送过来的微信号信息进行查询，并返回json数组
		String mailNo = request.getParameter("mailNo");

		if (mailNo == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				mailNo = obj.getString("mailNo");
			} else {
				mailNo = null;
			}
		}

		if (mailNo != null) {
			List<GoodsPosition> list = goodsPositionService.findByMailNo(mailNo);

			if (list == null) {
				out.append("没有查到任何信息，请检查mailNo有没有错误");
			} else {
				JSONArray json = JSONArray.fromObject(list);// 将java对象转换为json对象
				String str = json.toString();// 将json对象转换为字符串
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"你已经进入后台，但mailNo为null\"");
		}
	}

	// 获取微信唯一ID
	public void getId() throws IOException {
		init();
		Writer out = response.getWriter();
		String js_code = request.getParameter("js_code");

		if (js_code == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				js_code = obj.getString("js_code");
			} else {
				js_code = null;
			}
		}

		if (js_code == null) {
			out.write("json_code为空");
		}

		else {
			// 初始化数据
			Wparam wparam = new Wparam();
			wparam.setJs_code(js_code);
			wparam.setAppid("wx50ed494c861227ec");
			wparam.setSecret("481c61cfeb04e66808451a1db74f6c0a");

			// 通过后台发送请求获取唯一ID
			String id = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", wparam.toParam());
			/*
			 * System.out.println("唯一ID： "+id);
			 * 
			 * String str="{\"id\":"+id+"}";
			 */

			// 将获取数据返回
			System.out.println(id);
			out.write(id);
		}
	}

	// 测试
	public void text() throws IOException {
		init();
		Writer out = response.getWriter();
		String value = null;

		value = request.getParameter("aa");

		// 如果从请求头得不到参数，则请求为 post请求，参数放在 body中
		if (value == null) {
			System.out.println("接收到POST请求。。。");
			String params = JsonUtil.getRequestJson(request);
			// 将 json字符串转换成json对象
			System.out.println("接受到的数据为" + params);
			// 判断是否为json格式的字符串
			if (JsonUtil.isJson(params)) {
				System.out.println("接受到的数据是json格式数据");
				JSONObject obj = JSONObject.fromObject(params);

				value = (String) obj.get("aa");
				System.out.println("接收到的aa为: " + value);
				// System.out.println("params="+params);
			} else {
				System.out.println("params=" + params);
				String jsonParams = "{" + params + "}";
				if (JsonUtil.isJson(jsonParams)) {
					JSONObject obj = JSONObject.fromObject(params);
					value = (String) obj.get("aa");
				} else {
					System.out.println("params=" + params);
					value = "无法解析";
				}
			}

		}

		String code = "{\"code\":" + 1 + ",\"aa\":" + "\"通信成功：你传输的数据为" + value + "\"}";
		// System.out.println("后台返回数据为："+code);
		out.write(code);
		out.flush();

	}

	// 根据mailNo查询gCode;
	public void findgCodeByMailNo() throws IOException {
		init();
		String returnJson = null;
		Writer out = response.getWriter();
		// 根据微信小程序发送过来的微信号信息进行查询，并返回json数组
		String mailNo = request.getParameter("mailNo");
		if (mailNo == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				mailNo = obj.getString("mailNo");
			} else {
				mailNo = null;
			}
		}
		if (mailNo != null) {

			String gCode = goodsInfoService.findgCodeByMailNo(mailNo);

			if (gCode == null) {
				returnJson = "{\"gCode\":\"" + null + "\"}";
				
			}
			//如果已经签收，直接返回已签收
			else if (gCode.equals("已签收")) {
				returnJson = "{\"gCode\":\"" + gCode + "\"}";

			} else {
				returnJson = "{\"gCode\":\"" + gCode + Random_gCodeUtil.getNextSendTime() + "\"}";
			}

		} else {
			returnJson = "{\"gCode\":\"" + null + "\"}";
		}
		// System.out.println("mailNo="+mailNo);
		out.write(returnJson);
	}

}
