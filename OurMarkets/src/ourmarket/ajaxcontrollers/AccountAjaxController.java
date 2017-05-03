/**
 * 
 */
package ourmarket.ajaxcontrollers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ourmarket.componet.IMessageUtility;
import ourmarket.models.User;
import ourmarket.services.IUserService;

/***
 * 
 * Title:AccountAjaxController Description:
 * 
 * @author SGang
 * @date 2017年4月29日下午4:32:46
 */
@Controller
@RequestMapping("/Account")
public class AccountAjaxController {

	// 在自动注入时使用@Autowired时需要用接口而不能用实现类
	@Autowired
	private IUserService userServiceImp = null;
	@Autowired
	private IMessageUtility messageUtilityImpl = null;
	private String m_securityCode = "";

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
	@ResponseBody
	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Login(String uNickName, String uPassword) {
		User user = userServiceImp.identifyLoginInfo(uNickName, uPassword);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user == null) {
			map.put("msg", "error");
			System.out.println("error");
		} else {
			map.put("msg", "success");
			System.out.println("success");
			// 返回个人中心
		}
		return map;
	}

	/*
	 * 注册用户
	 */
	@ResponseBody
	@RequestMapping(value = "/Register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Register(String uNickName, String uPassword, String uPhone) {
		User user = new User();
		user.setUphone(uPhone);
		user.setUnickName(uNickName);
		user.setUpassword(uPassword);
		user.setRid(1);
		User users = userServiceImp.addUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (users == null) {
			map.put("msg", "error");
		} else {
			map.put("msg", "success");
		}
		return map;
	}

	/*
	 * 发送短信验证码
	 */
	@ResponseBody
	@RequestMapping(value = "/SendSecurityCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> SendSecurityCode(String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = messageUtilityImpl.SendSecurityCode(phoneNumber, "注册验证");
		m_securityCode = code;
		if (code == null) {
			map.put("msg", "error");
		} else {
			map.put("msg", "success");
		}
		return map;
	}

	/*
	 * 检查验证码是否正确
	 */
	@ResponseBody
	@RequestMapping(value = "/CheckSecurityCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> CheckSecurityCode(String securityCode) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (securityCode.equals(m_securityCode)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		return map;
	}

	// 检查用户名的合法性,如果用户已经存在，返回false，否则返回true
	@ResponseBody
	@RequestMapping(value = "/CheckuNickNameIsExist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> CheckuNickNameIsExist(String uNickName) {
		boolean flag = userServiceImp.checkuNickNameIsExist(uNickName);
		Map<String, Boolean> map = new HashMap<>();
		if (flag)
			map.put("valid", false);
		else
			map.put("valid", true);
		return map;
	}
}
