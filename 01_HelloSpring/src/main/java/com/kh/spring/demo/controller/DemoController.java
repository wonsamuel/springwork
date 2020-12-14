package com.kh.spring.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Demo;

/*수정할 때마다 서버리로드해야 함*/

@Controller
public class DemoController {
	
	@Autowired
	DemoService service;
	
//	urladdress의 mapping한 method를 쓴다
//	mapping method로 변경 @RequestMapping("/demo/demo.do") requestHandler가 얘를 찾는다
	@RequestMapping("/demo/demo.do")
	public String demo() {
		//처리로직구현
		//화면전환 서블릿 같은거
		return "demo/demo";
		
//		servlet-context.xml에 있는viewResolver/WEB-INF/views/demo/demo.jsp를 찾는다
	}
	
	
	//기본으로 매핑매소드가 가질 수 있는 파라미터값
	/*
	 * 1. HttpServletRequest 
	 * 2. HttpServletResponse 
	 * 3. HttpSession 
	 * 4. java.util.Locale 
	 * 5. InputStream/Reader 
	 * 6. OutputStream/Writer
	 * 7. Map
	 * 8. Model
	 * 9. ModelAndView
	 *  10. Command(vo객체)
	 *  11 SessoinStatus : session값???
	 * 
	 * 어노테이션으로 표현하는 값도 받을 수 있음
	 * @PathVariable : 요청한 주소의 경로를 가져올 때 사용
	 * @RequestParam : 클라이언트가 보낸 파라미터값
	 * @RequestHeader : 요청한 내용의 header
	 * @Coolie : 쿠키값
	 * @RequestBody : 보낸 데이터를 json으로 받는것
	 */
	
	@RequestMapping("/demo/basicParam.do")
	public String basicParam(HttpServletRequest req, HttpServletResponse res) {
		
		//DB에 클라이언트가 보낸 데이터를 저장 (파라미터로 갖고옴)
		String name = req.getParameter("devName");
		int age = Integer.parseInt(req.getParameter("devAge"));
		String email = req.getParameter("devEmail");
		String gender = req.getParameter("devGender");
		String[] devLang = req.getParameterValues("devLang");
		
		System.out.println(name+age+email+gender);
		for(String l : devLang) {
			System.out.println(l);
		}
		
		Demo d = new Demo(0, name, age, email, gender, devLang);
		
		service.insertDemo(d);
		
		return "demo/demoView";
		
	}
	
	@RequestMapping("/demo/requestParam.do")  //parameter 변수명이 jsp의 name과 동일해야 함---------> 이렇게도 가능하다  @RequestParam(value="devName) String name (devName의 value를 name에 넣는다는 의미)
//	public String requestparam(@RequestParam(value="devName") String name, 
//								@RequestParam(required=false, defaultValue="18") int devAge,  //required=false ==값이 안들어와도 됨 // defaultValue="18" ==값이 안들어오면 기본 값이 18임
//								@RequestParam String devEmail,
//								@RequestParam String devGender,
//								@RequestParam String[] devLang) {
	public String requestPara(String devName, int devAge, String devEmail, String devGender, String[] devLang) { //여기서는 무조건 파라미터값이 똑같에야 함
		
		System.out.println(devName+devAge+devEmail+devGender);
		Demo d = new Demo(0, devName, devAge, devEmail, devGender, devLang);
		
		service.insertDemo(d);
		return "demo/demoView";
	}
	
	@RequestMapping("/demo/requestMap.do")
	public String requestMap(@RequestParam Map map, String[] devLang) {
		
		map.put("devLang", devLang);
		System.out.println(map);
		
		return "demo/demoView";
	}
	
	@RequestMapping("/demo/requestCommand.do")
	public String requestCommand(Demo d, /*HttpServletRequest req*/  //무조건 jsp의 name과 vo객체의 파라미터 값이 같아야 함
									Model m) {  //Model = spring에서 제공하는 객체 저장보관용 객체임
		System.out.println(d);
		
		int result = service.insertDemo(d);
//		req.setAttribute("demo", d);
		m.addAttribute("demo",d);
		return "demo/demoView";
	}
	
	@RequestMapping("/demo/selectDemo.do")
	public String demoList(Model m) {
		List<Demo>list=service.selectDemo();
		m.addAttribute("list",list);
		return "demo/demoList";
	}

}
