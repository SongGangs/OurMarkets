/**
 * 
 */
package ourmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title:SecurityController
 *
 * Description:
 * 
 * @author SGang
 * @date 2017年5月3日下午1:27:34
 */
@Controller
@RequestMapping("/Security")
public class SecurityController {
	@RequestMapping("/Index")
	public String index() {
		return "security/index";
	}
}
