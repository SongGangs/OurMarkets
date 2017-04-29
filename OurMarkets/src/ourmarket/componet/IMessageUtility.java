/**
 * 
 */
package ourmarket.componet;

/**
 * Title:IMessageUtility
 * 
 * Description:短信公共类
 * 
 * @author SGang
 * @date 2017年4月29日下午10:54:16
 */
public interface IMessageUtility {
	public boolean CheckPhoneNumberIsExist(String phoneNumber);

	public String SendSecurityCode(String phoneNumber);
}
