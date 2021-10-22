package spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jquery/*")
public class JqueryController {

	@RequestMapping("jquery01.do")
	public String jquery() {
		
//		return "jQueryTest/jquery01";
//		return "jQueryTest/jquery02";
//		return "jQueryTest/jquery03";
//		return "jQueryTest/jquery04";
//		return "jQueryTest/jquery05";
//		return "jQueryTest/jquery06";
		return "jQueryTest/jquery07";
	}
}
