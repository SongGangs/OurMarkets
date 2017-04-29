/**
 * 
 */
package ourmarket.controllers.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ourmarket.models.User;
import ourmarket.services.imp.UserServiceImp;

/**
 * @Title:AccountAjaxController
 * @Description:
 * @author : SGang
 * @date : 2017年4月28日
 */
@Controller
@RequestMapping("/Account")
public class AccountAjaxController {
	@Autowired
	private UserServiceImp userServiceImp = null;

	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Login(String username, String password) {
		User user = userServiceImp.IdentifyLoginInfo(username, password);
		if (user == null) {
			return "账号密码不正确";
		} else {
			return "账号验证通过";// 用户中心
		}

	}
}
