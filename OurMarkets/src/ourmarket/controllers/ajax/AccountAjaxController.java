/**
 * 
 */
package ourmarket.controllers.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ourmarket.models.User;
import ourmarket.services.imp.UserServiceImp;

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
	@Autowired
	private UserServiceImp userServiceImp = null;

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
	@ResponseBody
	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Login(String uNickName, String uPassword) {
		User user = userServiceImp.IdentifyLoginInfo(uNickName, uPassword);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user == null) {
			System.out.println("error");
			map.put("msg", "error");
		} else {
			System.out.println("success");
			map.put("msg", "success");
			// 返回个人中心
		}
		return map;
	}
}
