/**
 * 
 */
package ourmarket.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ourmarket.daos.UserDAO;
import ourmarket.models.User;
import ourmarket.services.IUserService;

/**
 * 
 * @Title:UserServiceImp
 * @Description:
 * @author : SGang
 * @date : 2017年4月29日
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDAO userdao = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ourmarket.services.IUserService#CheckuNickNameIsExist(java.lang.String)
	 * 检查用户名是否存在
	 */
	@Cacheable(value = "userCache", key = "#uNickName")
	@Override
	public boolean checkuNickNameIsExist(String uNickName) {

		int result = userdao.findByUnickName(uNickName).size();
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#AddUser(ourmarket.models.User) //
	 * 添加用户
	 */
	@CachePut(value = "userCache", key = "#result.getUnickName()", condition = "#result!=null")
	@Override
	public User addUser(User user) {
		if (!checkuNickNameIsExist(user.getUnickName())) {
			return userdao.save(user);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#IdentifyLoginInfo(java.lang.String,
	 * java.lang.String) 检查账号信息是个正确
	 */

	@Override
	public User identifyLoginInfo(String uNickName, String uPassword) {
		if (checkuNickNameIsExist(uNickName)) {
			User user = (User) userdao.findByUnickName(uNickName).get(0);
			if (user.getUpassword().equals(uPassword)) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#GetIdByNickName(java.lang.String)
	 * 根据用户名查找ID
	 */
	@Cacheable(value = "userCache", key = "#result", condition = "#result>0")
	@Override
	public int getIdByNickName(String uNickName) {
		if (checkuNickNameIsExist(uNickName)) {
			return ((User) userdao.findByUnickName(uNickName).get(0)).getUid();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#GetUserByuNickName(java.lang.String)
	 * 
	 * 根据用户名查找用户信息
	 */
	@Override
	public User getUserByuNickName(String uNickName) {
		if (checkuNickNameIsExist(uNickName)) {
			return (User) userdao.findByUnickName(uNickName).get(0);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ourmarket.services.IUserService#getRoleByuNickNameAnduPassword(java.lang.
	 * String, java.lang.String)
	 * 
	 * 更加用户名密码查看角色
	 */
	@Override
	public String getRoleByuNickNameAnduPassword(String uNickName, String uPassword) {
		User user = identifyLoginInfo(uNickName, uPassword);
		if (user != null) {
			return user.getRid() == 0 ? "ROLE_USER" : "ROLE_ADMIN";
		}
		return null;
	}

}
