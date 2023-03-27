package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9") // 클래스에 맵핑함.
public class TestController2 {
	
	@RequestMapping(method = RequestMethod.GET) // get 방식으로 받는다.
	public String def(Model model) {
		model.addAttribute("msg","success get"); // view에 넘길 객체명과 value
		return "list"; // 특정 뷰 호출함.
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg","success post");
		return "list";
	}
}
