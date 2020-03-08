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

	// ���ڷ�װ΢��С���򴫵ݹ�����ֵ,�����޸���Ϣ
	private Consumer consumer;

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// ��ʼ������
	private void init() throws IOException {
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

	// ͨ��΢�źŲ���û�������Ϣ
	public void findByWetChatAccounts() throws IOException {
		init();
		Writer out = response.getWriter();

		// ����΢��С�����͹�����΢�ź���Ϣ���в�ѯ��������json����
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
				out.append("û�в鵽�κ���Ϣ������΢�ź���û�д���");
			} else {
				JSONObject json = JSONObject.fromObject(consumer);// ��java����ת��Ϊjson����
				String str = json.toString();// ��json����ת��Ϊ�ַ���
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"���Ѿ������̨����wetChatAccountsΪ��\"");
		}

	}

	// ͨ��openid����û�������Ϣ
	public void findByOpenid() throws IOException {
		init();
		Writer out = response.getWriter();

		// ����΢��С�����͹�����΢�ź���Ϣ���в�ѯ��������json����
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
				out.append("û�в鵽�κ���Ϣ������openid��û�д���");
			} else {
				JSONObject json = JSONObject.fromObject(consumer);// ��java����ת��Ϊjson����
				String str = json.toString();// ��json����ת��Ϊ�ַ���
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"���Ѿ������̨����openidΪ��\"");
		}

	}

	// �޸Ă�����Ϣ
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
			out.write("JsonStrΪnull");
		} else {
			JSONObject obj = JSONObject.fromObject(jsonStr);// ��json�ַ���ת��Ϊjson����
			// System.out.println(obj);
			// ��json����ת��Ϊjava����
			consumer = (Consumer) JSONObject.toBean(obj, Consumer.class);// ����json����ת��ΪConsumer����
			consumerService.update(consumer);
			out.write("�޸ĳɹ�");
		}

	}

	// �ṩ���к� ����ȡ������Ϣ

	public void getGoodsInfo() throws IOException {
		init();

		Writer out = response.getWriter();
		// ����΢��С�����͹�����΢�ź���Ϣ���в�ѯ��������json����
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
				out.append("û�в鵽�κ���Ϣ������΢�ź���û�д���");
			} else {
				for (GoodsInfo str : list) {
					String rsaTCode = str.gettCode();
					str.setTCode(RsaUtil.encryption(rsaTCode));

					// ��ȡ�������������׺
					str.setGCode(str.getgCode() + Random_gCodeUtil.getNextSendTime());
					rsalist.add(str);
				}
				JSONArray json = JSONArray.fromObject(rsalist);// ��java����ת��Ϊjson����
				String str = json.toString();// ��json����ת��Ϊ�ַ���
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"���Ѿ������̨��NumΪ��\"");
		}
	}

	// �����ṩ��mailNo���ض�λ��Ϣ

	public void getGoodsPosition() throws IOException {
		init();

		Writer out = response.getWriter();
		// ����΢��С�����͹�����΢�ź���Ϣ���в�ѯ��������json����
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
				out.append("û�в鵽�κ���Ϣ������mailNo��û�д���");
			} else {
				JSONArray json = JSONArray.fromObject(list);// ��java����ת��Ϊjson����
				String str = json.toString();// ��json����ת��Ϊ�ַ���
				response.getWriter().write(str);
				out.flush();
			}

		} else {
			out.write("\"���Ѿ������̨����mailNoΪnull\"");
		}
	}

	// ��ȡ΢��ΨһID
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
			out.write("json_codeΪ��");
		}

		else {
			// ��ʼ������
			Wparam wparam = new Wparam();
			wparam.setJs_code(js_code);
			wparam.setAppid("wx50ed494c861227ec");
			wparam.setSecret("481c61cfeb04e66808451a1db74f6c0a");

			// ͨ����̨���������ȡΨһID
			String id = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", wparam.toParam());
			/*
			 * System.out.println("ΨһID�� "+id);
			 * 
			 * String str="{\"id\":"+id+"}";
			 */

			// ����ȡ���ݷ���
			System.out.println(id);
			out.write(id);
		}
	}

	// ����
	public void text() throws IOException {
		init();
		Writer out = response.getWriter();
		String value = null;

		value = request.getParameter("aa");

		// ���������ͷ�ò���������������Ϊ post���󣬲������� body��
		if (value == null) {
			System.out.println("���յ�POST���󡣡���");
			String params = JsonUtil.getRequestJson(request);
			// �� json�ַ���ת����json����
			System.out.println("���ܵ�������Ϊ" + params);
			// �ж��Ƿ�Ϊjson��ʽ���ַ���
			if (JsonUtil.isJson(params)) {
				System.out.println("���ܵ���������json��ʽ����");
				JSONObject obj = JSONObject.fromObject(params);

				value = (String) obj.get("aa");
				System.out.println("���յ���aaΪ: " + value);
				// System.out.println("params="+params);
			} else {
				System.out.println("params=" + params);
				String jsonParams = "{" + params + "}";
				if (JsonUtil.isJson(jsonParams)) {
					JSONObject obj = JSONObject.fromObject(params);
					value = (String) obj.get("aa");
				} else {
					System.out.println("params=" + params);
					value = "�޷�����";
				}
			}

		}

		String code = "{\"code\":" + 1 + ",\"aa\":" + "\"ͨ�ųɹ����㴫�������Ϊ" + value + "\"}";
		// System.out.println("��̨��������Ϊ��"+code);
		out.write(code);
		out.flush();

	}

	// ����mailNo��ѯgCode;
	public void findgCodeByMailNo() throws IOException {
		init();
		String returnJson = null;
		Writer out = response.getWriter();
		// ����΢��С�����͹�����΢�ź���Ϣ���в�ѯ��������json����
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
			//����Ѿ�ǩ�գ�ֱ�ӷ�����ǩ��
			else if (gCode.equals("��ǩ��")) {
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
