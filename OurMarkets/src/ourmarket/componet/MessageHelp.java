/**
 * 
 */
package ourmarket.componet;

/**
 * @Title:MessageHelp
 * @Description:
 * @author : SGang
 * @date : 2017��4��28��
 */
public class MessageHelp {
	private String url = "http://gw.api.taobao.com/router/rest?"; // ���������ַ
	private String AppKey = "23281692";
	private String Security = "e767dfa2ce0a46ba554268dc720c7be6";
	private static int SecurityCode; // ��֤��
	private static boolean IsHaveSend = false; // �Ƿ��ѷ�����֤�� ������Ϊstatic�Ļ���
	private String phoneNumber;
	/*
	 * // ������֤�� private String SendSecurityCode(String SecurityCode) {
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
	 * req.SmsFreeSignName = "ע����֤"; // req.SmsParam = //
	 * String.Format("{\"code\":\"1234\",\"product\":\"����ƴ�ӡ\"}", //
	 * SecurityCode);// "{\"code\":\"1234\",\"product\":\"����ƴ�ӡ\"}";
	 * req.SmsParam = "{\"code\":\"" + SecurityCode +
	 * "\",\"product\":\"����ƴ�ӡ\"}"; req.RecNum = phoneNumber;
	 * req.SmsTemplateCode = "SMS_3125049"; AlibabaAliqinFcSmsNumSendResponse
	 * rsp = client.Execute(req); result = rsp.Body; } return result; }
	 */
}
