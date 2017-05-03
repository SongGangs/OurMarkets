/**
 * 
 */
package ourmarket.services;

import ourmarket.models.User;

/***
 * 
 * Title:IUserService Description:
 * 
 * @author SGang
 * @date 2017年4月29日下午4:18:17
 */
public interface IUserService {
	public boolean checkuNickNameIsExist(String uNickName);

	public User addUser(User user);

	public User identifyLoginInfo(String uNickName, String uPassword);

	public int getIdByNickName(String uNickName);

	public User getUserByuNickName(String uNickName);

	public String getRoleByuNickNameAnduPassword(String uNickName, String uPassword);
}
