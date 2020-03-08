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
	
	
	//Appɨ���ݵ��������󣬸������������룬��̨�ٸ������������ÿ�ݵı�Ҫ�û���Ϣ�����Ϻ󷵻ر�Ҫ��Ϣ
	
	@Autowired
	private CourierService courierService;

	@Autowired
	private GoodsInfoService goodsInfoService;
	@Autowired
	private ConsumerService consumerService;
	
	

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	//��ʼ������
	private void init() throws IOException  {
		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// ������һ����ܽ��(���б�ҳ��)����
		response.setHeader("content-type", "text/html;charset=UTF-8");

		/* ������Ӧͷ����ajax������� */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}
	
	/**
	 * ���Աɨȡ�������ȡ�����Ϣ���û���Ϣ������openid���п��Ա��֤
	 * @throws IOException
	 */
	public void getMessage() throws IOException {
		init();
		Writer out = response.getWriter();
		
	
		//��ȡ�����룬��̨�ٸ������������ÿ�ݵı�Ҫ�û���Ϣ�����Ϻ󷵻ر�Ҫ��Ϣ
		String tCode = request.getParameter("tCode");
		String openid = request.getParameter("openid");
		
		//�������ͷΪ�գ���Ϊpost���󣬽���json���ݽ���
		if(tCode == null && openid== null) {
			
			String json = JsonUtil.getRequestJson(request);
			//���Ϊjson��ʽ
			if (JsonUtil.isJson(json)) {
				JSONObject obj = JSONObject.fromObject(json);
				tCode = obj.getString("tCode");
				openid = obj.getString("openid");
			} else {
				tCode=openid = null;
			}
		}
		
		//��ȡ����Ϣ
		if(tCode != null && openid!=null) {
			//����openid��ѯ�Ƿ��иÿ��Ա
			Courier courier = courierService.findCourierByOpenid(openid);
			
			//���û�иÿ��Ա
			if(courier ==null ){
				response.getWriter().write("�����֤ʧ��");
				return;
			}
			
			//��tCode���н���
			String realtCode = RsaUtil.decrypt(tCode);
			
			//��ȡ�����Ϣ
			GoodsInfo goodsInfo = goodsInfoService.findBytCode(realtCode);
			if(goodsInfo == null) {
				response.getWriter().write("û�в鵽�����Ϣ�������������Ƿ���ȷ");
			}
			else {
				Consumer consumer = consumerService.findByNum(goodsInfo.getNum());
				
				//����
				goodsInfo.setTCode(RsaUtil.encryption(realtCode));
				
				//��ȡ������������
				goodsInfo.setGCode(goodsInfo.getgCode()+Random_gCodeUtil.getNextSendTime());
				
				JSONObject json = JSONObject.fromObject(goodsInfo);//��java����ת��Ϊjson����
				
				//�����ݷ�װΪ��������
				String str = "["+json.toString();//��json����ת��Ϊ�ַ���
				response.getWriter().write(str);
				if(consumer!= null) {
					
					
					json  = JSONObject.fromObject(consumer);//��java����ת��Ϊjson����
					String str2 = json.toString();
					
					response.getWriter().append(","+str2);
					
				}
				response.getWriter().append("]");
				out.flush();
				
			}
			
		}
		else {
			response.getWriter().write("���ѽ����̨������û���ṩ������");
		}	
	}
	
	
	// �����������ȡ����鿴�Ƿ�ƥ��
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
			// ���Ƚϳ�����Ϊ������
			if (code1.length() > code2.length()) {
				tCode = code1;
				// ��ȡȡ���벿�֣�ȡ���볤��Ϊ16�ַ�
				gCode = code2.substring(0, 16);
				randomCode = code2.substring(16);
			} else {
				tCode = code2;
				gCode = code1.substring(0, 16);
				randomCode = code1.substring(16);
			}

			// �ж�ȡ�����ʱЧ��
			if (Random_gCodeUtil.isOutTime(Long.parseLong(randomCode))) {
				returnJson = "{\"status\":\"out_time\"}";
			} else {

				//System.out.println("tCode=" + tCode);
				String realtCode = RsaUtil.decrypt(tCode);
				//System.out.println("realtCode=" + realtCode);
				//System.out.println("gCode=" + gCode);
				if (goodsInfoService.is_MatchByCode(realtCode, gCode) == true) {
					
					returnJson = "{\"status\":\"true\"}";
					
					//��Ϊǩ��״̬
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
	
	// APP��¼
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

			// �û��ǿգ�˵�������û�
			if (selectedCourier != null) {
				// ���û���Ϣ������HttpSession��
				// ��ȡsession����
				HttpSession session = ServletActionContext.getRequest().getSession();
				// ����ѯ�������û���Ϣ������session��
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
	
	
	
	//���Ա�ṩ�绰����,��̨�Զ����Ͷ���
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
	
	
	//����tCode����ǩ��״̬
	public void signIn(String tCode) {
		GoodsInfo goodsInfo = goodsInfoService.findBytCode(tCode);
		goodsInfo.setState("��ǩ��");
		
		//����״̬Ϊ��ǩ��
		goodsInfoService.update(goodsInfo);
	}
	
	
	
	
}
