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
 * @Title:UserServiceImp
 * @Description:User的服务类实现
 * @author : SGang
 * @date : 2017年4月28日
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
	 * 查看用户名是否存在
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
		return userdao.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#IdentifyLoginInfo(java.lang.String,
	 * java.lang.String) 验证密码和用户名是否正确 如果正确返回用户信息 不正确返回空
	 */
	@Override
	public User IdentifyLoginInfo(String uNickName, String uPassword) {
		if (CheckuNickNameIsExist(uNickName)) {
			User user = (User) userdao.findByUnickName(uNickName).get(0);
			if (user.getUpassword() == uPassword) {
				return user;
			} else {
				return new User();
			}
		} else {
			return new User();
		}
	}

}
