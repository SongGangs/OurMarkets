/**
 * 
 */
package ourmarket.services;

import ourmarket.models.User;

/**
 * @Title:IUserService
 * @Description:User�ķ�����ӿ�
 * @author : SGang
 * @date : 2017��4��28��
 */
public interface IUserService {
	public boolean CheckuNickNameIsExist(String uNickName);

	public User AddUser(User user);

	public User IdentifyLoginInfo(String uNickName, String uPassword);
}
