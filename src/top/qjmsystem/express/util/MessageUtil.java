package top.qjmsystem.express.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class MessageUtil {

    static final String product = "Dysmsapi";
   
    static final String domain = "dysmsapi.aliyuncs.com";


    static final String accessKeyId = "LTAIklbjYJryVwnS";
    static final String accessKeySecret = "aUS5wk98SsJV4yF07GMzzr4VhKJtbY";

    static final String defaultTemplateParam= "{\"code\":\"123\", \"address\":\"学院后门\"}";

    public static SendSmsResponse sendSms(String tel, String templateParam) throws ClientException {

    	//设置超时时间-可自行调整
    	System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
    	System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    	//初始化ascClient需要的几个参数
    	final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    	final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    	//替换成你的AK
    	final String accessKeyId = "LTAIklbjYJryVwnS";//你的accessKeyId,参考本文档步骤2
    	final String accessKeySecret = "aUS5wk98SsJV4yF07GMzzr4VhKJtbY";//你的accessKeySecret，参考本文档步骤2
    	//初始化ascClient,暂时不支持多region（请勿修改）
    	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
    	accessKeySecret);
    	DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
    	IAcsClient acsClient = new DefaultAcsClient(profile);
    	 //组装请求对象
    	 SendSmsRequest request = new SendSmsRequest();
    	 //使用post提交
    	 request.setMethod(MethodType.POST);
    	 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
    	 request.setPhoneNumbers(tel);
    	 //必填:短信签名-可在短信控制台中找到
    	 request.setSignName("柚码");
    	 //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
    	 request.setTemplateCode("SMS_150172772");
    	 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    	 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
 
    	 if(templateParam==null) {
    		 templateParam=defaultTemplateParam;
    	 }
    	 request.setTemplateParam(templateParam);
    	 //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
    	 //request.setSmsUpExtendCode("90997");
    	 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    	 request.setOutId("yourOutId");
    	//请求失败这里会抛ClientException异常
    	 SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {

        //鍙嚜鍔╄皟鏁磋秴鏃舵椂闂�
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //鍒濆鍖朼csClient,鏆備笉鏀寔region鍖�
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //缁勮璇锋眰瀵硅薄
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //蹇呭～-鍙风爜
        request.setPhoneNumber("15013295784");
        //鍙��-娴佹按鍙�
        request.setBizId(bizId);
        //蹇呭～-鍙戦�佹棩鏈� 鏀寔30澶╁唴璁板綍鏌ヨ锛屾牸寮弝yyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //蹇呭～-椤靛ぇ灏�
        request.setPageSize(10L);
        //蹇呭～-褰撳墠椤电爜浠�1寮�濮嬭鏁�
        request.setCurrentPage(1L);

        //hint 姝ゅ鍙兘浼氭姏鍑哄紓甯革紝娉ㄦ剰catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
    
    
    public static boolean sendMessage(String tel, String templateParam){
    	 SendSmsResponse response;
		try {
			response = sendSms(tel,templateParam);
		} catch (ClientException e) {
			e.printStackTrace();
			return false;
		}
    	   if(response.getCode() != null && response.getCode().equals("OK")) {
    		   return true;
    	   }
    	   else return false;
    }

    /*public static void main(String[] args) throws ClientException, InterruptedException {

        //鍙戠煭淇�
        SendSmsResponse response = sendSms("15013295784",defaultTemplateParam);
        System.out.println("开始发送----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

        Thread.sleep(3000L);

        //鏌ユ槑缁�
        if(response.getCode() != null && response.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
            System.out.println("鐭俊鏄庣粏鏌ヨ鎺ュ彛杩斿洖鏁版嵁----------------");
            System.out.println("Code=" + querySendDetailsResponse.getCode());
            System.out.println("Message=" + querySendDetailsResponse.getMessage());
            int i = 0;
            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
            {
                System.out.println("SmsSendDetailDTO["+i+"]:");
                System.out.println("Content=" + smsSendDetailDTO.getContent());
                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
            }
            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
        }
    }*/
}
