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
 * @date : 2017��4��28��
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
			return "�˺����벻��ȷ";
		} else {
			return "�˺���֤ͨ��";// �û�����
		}

	}
}
