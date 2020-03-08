package top.qjmsystem.express.action;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;
import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.service.ConsumerService;
import top.qjmsystem.express.service.CourierService;
import top.qjmsystem.express.service.GoodsInfoService;
import top.qjmsystem.express.util.JsonUtil;
import top.qjmsystem.express.util.MessageUtil;
import top.qjmsystem.express.util.Random_gCodeUtil;
import top.qjmsystem.express.util.RsaUtil;

public class AppAction {
	
	
	//App扫描快递单后发送请求，该请求含有运输码，后台再根据运输码查出该快递的必要用户信息，整合后返回必要信息
	
	@Autowired
	private CourierService courierService;

	@Autowired
	private GoodsInfoService goodsInfoService;
	@Autowired
	private ConsumerService consumerService;
	
	

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	//初始化设置
	private void init() throws IOException  {
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
	
	/**
	 * 快递员扫取运输码获取快递信息和用户信息，需用openid进行快递员验证
	 * @throws IOException
	 */
	public void getMessage() throws IOException {
		init();
		Writer out = response.getWriter();
		
	
		//获取运输码，后台再根据运输码查出该快递的必要用户信息，整合后返回必要信息
		String tCode = request.getParameter("tCode");
		String openid = request.getParameter("openid");
		
		//如果请求头为空，则为post请求，进行json数据解析
		if(tCode == null && openid== null) {
			
			String json = JsonUtil.getRequestJson(request);
			//如果为json格式
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				tCode = obj.getString("tCode");
				openid = obj.getString("openid");
			} else {
				tCode=openid = null;
			}
		}
		
		//获取到信息
		if(tCode != null && openid!=null) {
			//根据openid查询是否有该快递员
			Courier courier = courierService.findCourierByOpenid(openid);
			
			//如果没有该快递员
			if(courier ==null ){
				response.getWriter().write("身份验证失败");
				return;
			}
			
			//对tCode进行解密
			String realtCode = RsaUtil.decrypt(tCode);
			
			//获取快递信息
			GoodsInfo goodsInfo = goodsInfoService.findBytCode(realtCode);
			if(goodsInfo == null) {
				response.getWriter().write("没有查到相关信息，请检查运输码是否正确");
			}
			else {
				Consumer consumer = consumerService.findByNum(goodsInfo.getNum());
				
				//加密
				goodsInfo.setTCode(RsaUtil.encryption(realtCode));
				
				//对取件码加入随机数
				goodsInfo.setGCode(goodsInfo.getgCode()+Random_gCodeUtil.getNextSendTime());
				
				JSONObject json = JSONObject.fromObject(goodsInfo);//将java对象转换为json对象
				
				//把数据封装为对象数组
				String str = "["+json.toString();//将json对象转换为字符串
				response.getWriter().write(str);
				if(consumer!= null) {
					
					
					json  = JSONObject.fromObject(consumer);//将java对象转换为json对象
					String str2 = json.toString();
					
					response.getWriter().append(","+str2);
					
				}
				response.getWriter().append("]");
				out.flush();
				
			}
			
		}
		else {
			response.getWriter().write("你已进入后台，但你没有提供运输码");
		}	
	}
	
	
	// 根据运输码和取件码查看是否匹配
	public void is_matchByCode() throws IOException {
		init();
		
		String returnJson = null;
		Writer out = response.getWriter();
		
		String code1 = request.getParameter("code1");
		String code2 = request.getParameter("code2");
		if (code1 == null || code2 == null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				code1 = obj.getString("code1");
				code2 = obj.getString("code2");
			} else {
				code1 = code2 = null;
			}
		}
		if (code1 != null && code2 != null) {
			String tCode;
			String gCode;
			String randomCode;
			// 长度较长的码为运输码
			if (code1.length() > code2.length()) {
				tCode = code1;
				// 截取取件码部分，取件码长度为16字符
				gCode = code2.substring(0, 16);
				randomCode = code2.substring(16);
			} else {
				tCode = code2;
				gCode = code1.substring(0, 16);
				randomCode = code1.substring(16);
			}

			// 判断取件码的时效性
			if (Random_gCodeUtil.isOutTime(Long.parseLong(randomCode))) {
				returnJson = "{\"status\":\"out_time\"}";
			} else {

				//System.out.println("tCode=" + tCode);
				String realtCode = RsaUtil.decrypt(tCode);
				//System.out.println("realtCode=" + realtCode);
				//System.out.println("gCode=" + gCode);
				if (goodsInfoService.is_MatchByCode(realtCode, gCode) == true) {
					
					returnJson = "{\"status\":\"true\"}";
					
					//改为签收状态
					signIn(realtCode);
				} else {
					returnJson = "{\"status\":\"false\"}";
				}
			}
		} else {
			returnJson = "{\"status\":\"false\"}";
		}
		out.write(returnJson);
		out.flush();
	}
	
	// APP登录
	public void login() throws IOException {
		init();
		String returnJson=null;
		String accounts = request.getParameter("accounts");
		String password = request.getParameter("password");
		if(accounts==null || password== null) {
			String json=JsonUtil.getRequestJson(request);
			if(JsonUtil.isJson(json)){
				JSONObject obj = JSONObject.fromObject(json);
				accounts=obj.getString("accounts");
				password=obj.getString("password");
			}
			else {
				accounts=password=null;
			}
		}
		
		if (accounts != null && password != null) {
			Courier selectedCourier = courierService.findCourierByAccountAndPwd(accounts, password);

			// 用户非空，说明存在用户
			if (selectedCourier != null) {
				// 将用户信息保存在HttpSession中
				// 获取session对象
				HttpSession session = ServletActionContext.getRequest().getSession();
				// 将查询出来的用户信息保存在session中
				session.setAttribute("Courier", selectedCourier);
				returnJson="{\"is_login\":\"true\"}";
				

			} else {
				returnJson="{\"is_login\":\"false\"}";
				
			}

		} else {
			returnJson="{\"is_login\":\"false\"}";
			
			
			response.getWriter().write("please input accounts and password");
		}
		response.getWriter().write(returnJson);

	}
	
	
	
	//快递员提供电话号码,后台自动发送短信
	public void sendSms() throws IOException {
		init();
		Writer out = response.getWriter();
		String returnJson = null;
		String tel = request.getParameter("tel");
		String templateParam = request.getParameter("templateParam");
		

		if (tel == null && templateParam==null) {
			String json = JsonUtil.getRequestJson(request);
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				tel = obj.getString("tel");
				templateParam = obj.getString("templateParam");
			} else {
				tel = null;
				templateParam=null;
			}

		}

		if (tel != null) {

			if(MessageUtil.sendMessage(tel,templateParam)==true) {
				returnJson="{\"is_send\":\"true\"}";
			}else {
				returnJson="{\"is_send\":\"false\"}";
			}
		} else {
			returnJson="{\"is_send\":\"false\"}";
		}
		out.write(returnJson);
	}
	
	
	//根据tCode更新签收状态
	public void signIn(String tCode) {
		GoodsInfo goodsInfo = goodsInfoService.findBytCode(tCode);
		goodsInfo.setState("已签收");
		
		//更新状态为已签收
		goodsInfoService.update(goodsInfo);
	}
	
	
	
	
}
