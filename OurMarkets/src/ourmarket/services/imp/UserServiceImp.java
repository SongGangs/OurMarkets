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
 * @Description:User�ķ�����ʵ��
 * @author : SGang
 * @date : 2017��4��28��
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
	 * �鿴�û����Ƿ����
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
	 * ����û�
	 */
	@Override
	public User AddUser(User user) {
		return userdao.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ourmarket.services.IUserService#IdentifyLoginInfo(java.lang.String,
	 * java.lang.String) ��֤������û����Ƿ���ȷ �����ȷ�����û���Ϣ ����ȷ���ؿ�
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
