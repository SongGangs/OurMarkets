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

	private String url = "http://gw.api.taobao.com/router/rest"; // 阿里服务网址
	private String AppKey = "23401777";
	private String Security = "413bccbc7a9964b957c2e04940cc2369";

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
	 * 用户注册时
	 * 
	 * 发送短信验证码 SecurityType
	 * 
	 * 为用户变更类型 只允许
	 * 
	 * 注册验证
	 * 
	 * 身份验证
	 * 
	 * @see
	 * ourmarket.componet.IMessageUtility#SendSecurityCode(java.lang.String)
	 */
	@Override
	public String SendSecurityCode(String phoneNumber, String SecurityType) {
		if (CheckPhoneNumberIsExist(phoneNumber)) {
			String product = "测试机器";// 产品名称
			String m_SecurityCode = generateRandomArray(6);// 验证码
			// 短信模板的内容
			String content = "{\"code\":\"" + m_SecurityCode + "\",\"product\":\"" + product + "\"}";
			TaobaoClient client = new DefaultTaobaoClient(url, AppKey, Security);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend("123456");
			req.setSmsType("normal");
			req.setSmsFreeSignName(SecurityType);
			req.setSmsParamString(content);
			req.setRecNum(phoneNumber);
			req.setSmsTemplateCode("SMS_11350208");
			try {
				AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
				System.out.println(rsp.getBody());
				if (rsp.getBody().contains("\"success\":true"))
					return m_SecurityCode;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		return null;
	}

	/**
	 * 随机生成 num位数字字符数组
	 * 
	 * @param num
	 * @return
	 */
	private String generateRandomArray(int num) {
		String chars = "0123456789";
		char[] rands = new char[num];
		for (int i = 0; i < num; i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return String.valueOf(rands);
	}

}
