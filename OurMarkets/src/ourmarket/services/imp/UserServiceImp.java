/**
 * 
 */
package ourmarket.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImp implements IUserService {
	@Autowired
	private UserDAO userdao = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ourmarket.services.IUserService#CheckuNickNameIsExist(java.lang.String)
	 * 检查用户名是否存在
	 */
	@Override
	public boolean CheckuNickNameIsExist(String uNickName) {
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
	@Override
	public User AddUser(User user) {
		if (!CheckuNickNameIsExist(user.getUnickName())) {
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
	public User IdentifyLoginInfo(String uNickName, String uPassword) {
		if (CheckuNickNameIsExist(uNickName)) {
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
	@Override
	public int GetIdByNickName(String uNickName) {
		if (CheckuNickNameIsExist(uNickName)) {
			return ((User) userdao.findByUnickName(uNickName).get(0)).getUid();
		} else {
			return 0;
		}
	}

}
