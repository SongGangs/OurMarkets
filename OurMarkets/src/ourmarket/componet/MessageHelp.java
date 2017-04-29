/**
 * 
 */
package ourmarket.componet;

/**
 * @Title:MessageHelp
 * @Description:
 * @author : SGang
 * @date : 2017年4月28日
 */
public class MessageHelp {
	private String url = "http://gw.api.taobao.com/router/rest?"; // 阿里服务网址
	private String AppKey = "23281692";
	private String Security = "e767dfa2ce0a46ba554268dc720c7be6";
	private static int SecurityCode; // 验证码
	private static boolean IsHaveSend = false; // 是否已发送验证码 不设置为static的话会
	private String phoneNumber;
	/*
	 * // 发送验证码 private String SendSecurityCode(String SecurityCode) {
	 * phoneNumber = "";/// String result = ""; if
	 * (MetarnetRegex.IsMobilePhone(phoneNumber)) { ITopClient client = new
	 * DefaultTopClient(url, AppKey, Security);
	 * 
	 * AlibabaAliqinFcSmsNumSendRequest req = new
	 * AlibabaAliqinFcSmsNumSendRequest();
	 * 
	 * req.Extend = "123456";
	 * 
	 * req.SmsType = "normal";
	 * 
	 * req.SmsFreeSignName = "注册验证"; // req.SmsParam = //
	 * String.Format("{\"code\":\"1234\",\"product\":\"打堆云打印\"}", //
	 * SecurityCode);// "{\"code\":\"1234\",\"product\":\"打堆云打印\"}";
	 * req.SmsParam = "{\"code\":\"" + SecurityCode +
	 * "\",\"product\":\"打堆云打印\"}"; req.RecNum = phoneNumber;
	 * req.SmsTemplateCode = "SMS_3125049"; AlibabaAliqinFcSmsNumSendResponse
	 * rsp = client.Execute(req); result = rsp.Body; } return result; }
	 */
}
