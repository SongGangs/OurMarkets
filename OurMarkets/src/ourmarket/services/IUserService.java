/**
 * 
 */
package ourmarket.services;

import ourmarket.models.User;

/**
 * @Title:IUserService
 * @Description:User的服务类接口
 * @author : SGang
 * @date : 2017年4月28日
 */
public interface IUserService {
	public boolean CheckuNickNameIsExist(String uNickName);

	public User AddUser(User user);

	public User IdentifyLoginInfo(String uNickName, String uPassword);
}
