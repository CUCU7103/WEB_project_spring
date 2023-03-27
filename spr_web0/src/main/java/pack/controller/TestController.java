package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


//인스턴스 생성, 클라이언트와 데이터 입출력을 제어하는 클래스에 적용
@Controller // 컨트롤러임을 명시함, 가독성을 위함이다.
public class TestController { // ex 인사관리 컨트롤러....

	//@RequestMapping에 대한 정보는 HandlerMapping class가 가지고 있다.
	@RequestMapping("test1") // get과 post 방식 모두 처리할 수 있다.
	
	/*
	 * 
	 * 특정 uri로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지 정의를 한다.
	 * 이때 들어온 요청을 특정 메서드와 매핑하기 위해 사용하는 것이 @RequestMapping이다. 
	 * RequestMapping에서 가장 많이 사용하는 부분은 value와 method이다.
	 * 
	 */
	
	public ModelAndView abc() {
		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("list");
//		modelAndView.addObject("msg", "스프링 만세 "); // 아래의 두 줄을 의미한다.
		
//		HttpServletRequest request = new HttpServletRequest(); 
//		request.setAttribute("msg", "스프링 만세 ");
		
//		return modelAndView;
// 		ModelAndView는 데이터와 이동하고자 하는 View Page를 같이 저장한다
		
		/*
		 * ModelAndView(String viewName) : 응답할 view 설정 
		 * ModelAndView(String viewName, Map values) : 응답할 view와 view로 전달할 값들을 저장한 Map 객체 
		 * ModelAndView(String viewName, String name, Object value) : 응답할 view 이름, view로 넘길 객체의 name과 value
		 */
		
		return new ModelAndView("list", "msg", "스프링 만세"); // forwarding, 스프링은 기본적으로 forwarding이다.
		// 						응답할 view 이름, view로 넘길 객체의 name과 value
		// 즉 list라는 view를 사용하고 그 view에 msg라는 객체에 스프링 만세라는 값을 넘긴다.
	}
	
	// @RequestMapping(value = "test2", method = RequestMethod.GET) // get방식만 처리하겠다는 뜻 get방식은 문자열만 넘길 수있다.
	@RequestMapping(value = {"test2","kbs","mbc/sbs"}, method = RequestMethod.GET) // get방식만 처리하겠다는 뜻
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "스프링만세2"); // 응답 view 이름, view로 넘길 객체의 name 과 value
	}
	
	  @GetMapping("test3") // 주로 이걸 사용한다.
	//@GetMapping("test3","hello","world/nice")
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "스프링만세3");
	}
	  
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg","스프링만세 4");
	//	request.setAttribute("msg", "스프링 만세4 ");  == model.addAttribute("msg","스프링만세4");
		return "list"; 
		// 파일명을 적어준다.
		
	}
	
	@RequestMapping(value ="test5", method = RequestMethod.POST) // post사용함.
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "포스트 만세5");
	}
	  
	@RequestMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "포스트 만세6");
	}
	
	
	@RequestMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg","post 만세7");
		return "list";
	}
	
	
	@GetMapping("test8")
	@ResponseBody //  http요청의 본문(body)이 그대로 전달된다.
	public String abc8() {
		String value ="실제로는 모델을 다녀온 결과를 반환 Java object : String, Map, JSON...";
		return value;
	}
	
	
	@GetMapping("test8_1")
	@ResponseBody // Json 형식으로 반환되어진다.
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("허균");
		return dto; // jackson 라이브러리가 자동으로 지원.
	}
	
}




