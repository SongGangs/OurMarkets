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
	public boolean CheckuNickNameIsExist(String uNickName);

	public User AddUser(User user);

	public User IdentifyLoginInfo(String uNickName, String uPassword);

	public int GetIdByNickName(String uNickName);
}
