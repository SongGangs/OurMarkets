/**
 * 
 */
package ourmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:HomeController
 * @Description:
 * @author : SGang
 * @date : 2017��4��28��
 */
@Controller
@RequestMapping("/Home")
public class HomeController {

	@RequestMapping("/Index")
	public String index() {
		return "home/index";
	}
}
