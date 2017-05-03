/**
 * 
 */
package ourmarket.message.services;

/**
 * 
 * Title:IMessageUtility
 *
 * Description:短信公共类
 * 
 * @author SGang
 * @date 2017年4月30日上午10:56:28
 */
public interface IMessageUtilityService {
	public boolean CheckPhoneNumberIsExist(String phoneNumber);

	public String SendSecurityCode(String phoneNumber, String SecurityType);

}
