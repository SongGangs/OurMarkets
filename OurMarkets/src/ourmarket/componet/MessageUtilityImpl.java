/**
 * 
 */
package ourmarket.componet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Title:MessageUtilityImpl
 * 
 * Description:
 * 
 * @author SGang
 * @date 2017年4月29日下午10:57:09
 */
@Service
public class MessageUtilityImpl implements IMessageUtility {

	private String url = "http://gw.api.taobao.com/router/rest?"; // 阿里服务网址ַ
	private String AppKey = "23300902";
	private String Security = "24c5befb62bed7917bf139b7d39d251d";
	private static boolean IsHaveSend = false; // 是否已发送验证码 不设置为static的话会

	/**
	 * 大陆手机号码11位数， 匹配格式：前三位固定格式+后8位任意数 此方法中前三位格式有： 13+任意数 15+除4的任意数 18+除1和4的任意数
	 * 17+除9的任意数 147
	 */
	@Override
	public boolean CheckPhoneNumberIsExist(String phoneNumber) {
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 发送短信验证码
	 * 
	 * @see
	 * ourmarket.componet.IMessageUtility#SendSecurityCode(java.lang.String)
	 */
	@Override
	public String SendSecurityCode(String phoneNumber) {
		if (CheckPhoneNumberIsExist(phoneNumber)) {
			String product = "测试机器";
			// 短信模板的内容
			String content = "{\"code\":\"" + ProduceRandomSecurityCode() + "\",\"product\":\"" + product + "\"}";
			TaobaoClient client = new DefaultTaobaoClient(url, AppKey, Security);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend("123456");
			req.setSmsType("normal");
			req.setSmsFreeSignName("注册验证");
			req.setSmsParamString(content);
			req.setRecNum(phoneNumber);
			req.setSmsTemplateCode("SMS_4720619");
			try {
				AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
				System.out.println(rsp.getBody());
				return rsp.getBody();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		return null;
	}

	@SuppressWarnings("unused")
	private String ProduceRandomSecurityCode() {
		return String.valueOf((Math.random() * 9 + 1) * 100000);
	}
}
