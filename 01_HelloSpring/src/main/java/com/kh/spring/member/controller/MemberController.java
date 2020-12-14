package com.kh.spring.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

//@Component
@Controller
@SessionAttributes("loginMember")   //model에 있는 것을 session으로 옮기기 (괄호 안에 있는 건 key값임)  여기에 여러개가 들어갈 경우 -> @SessionAttributes({"loginMember","somethingElse"})
public class MemberController {
	
	//log4j를 이용하여 로그 남기기
	//1.log4j객체를 생성. -> logger(slf4j를 이용)
	
//	private Logger logger=LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private Logger logger; //이렇게하면 bean등록해야 함 --> 2가지 방법 --> common --> BeanConfigure
	
	@Autowired
	@Qualifier("real")
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping("/member/insertMember.do")
	public String insertMember() {
		
		return "member/memberEnroll";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String insertMember(Member m, Model model) {
		
		//비밀번호 암호화하기
		//비밀번호 단방향 암호화는 BCryptPasswordEncoder객체를 이용
		//암호화 : encode메소드를 이용
		System.out.println("암호화 전 : "+m.getPassword());
		m.setPassword(encoder.encode(m.getPassword()));
		System.out.println("암호화 후 : "+m.getPassword());
		
		//매개변수 받는 방법: requestparam, map, command
		int result = service.insertMember(m);
//		m.addAttribute("member", member);
		System.out.println(m);
		String page="";
		if(result==0) {
			page="common/msg";
			model.addAttribute("msg", "회원가입실해");
			model.addAttribute("loc","/member/insertMember.do");
		}else {
			page="redirect:/";
		}
		
		
//		return "redirect:/"; //정해진 주소를 무시함 /WEB-INF/views/....jsp이거
		return page;
	}
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin(String userId, String password, Model m, HttpSession session) {
		
		//로그 출력하기 (여긴 String만 들어감) 그래서 그냥 변수만 쓰면 에러 뜸 
		logger.debug(""+session);
		logger.debug("이건 debug");
		logger.info("이건 info");
		logger.warn("이건  warn");
		logger.error("이건 error");
		
		Member login = service.selectMember(userId);
		
		
//		if(login!=null && login.getPassword().equals(password)) {
			//암호화된 값을 비교하기 위해서는 matches메소드를 이용
		if(login!=null && encoder.matches(password, login.getPassword())) {
			//로그인 성공
			m.addAttribute("msg","로그인 성공");
			//로그인 유지하기 위해 객체 저장
			//model에 저장되어 있는 객체를 Session범위로 확장하기
			//SessionAttributes어노테이션을 이용
			m.addAttribute("loginMember", login);
			
		}else {
			//로그인 실패
			m.addAttribute("msg","로그인 실패");
		}
		m.addAttribute("loc","/");
		return "common/msg";
	}
	
	@RequestMapping("/member/logout.do")
	public String logout(SessionStatus status, HttpSession session) {
		
		if(!status.isComplete()) {
			//isComplete means session이 끊어졌다
			status.setComplete();
		}
//		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("/member/checkId")
	public void checkId(String userId, ServletOutputStream out) {
		
		Member m = service.selectMember(userId);
		
		boolean flag = m != null?false:true;
		try {
			out.print(flag);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/member/checkIdJsonView")
	public String checkIdJsonView(String userId, Model model) {
		
		Member m = service.selectMember(userId);
		
		boolean flag = m != null?false:true;
		
		model.addAttribute("flag",flag);
		model.addAttribute("member",m);
		
		
		return "jsonView";
		
	}
	
	@RequestMapping("/member/checkIdResponse")
	@ResponseBody
	public boolean checkId(String userId) {
//	public Member checkId(String userId) {
//	public List<Board> checkId(String userId) {	
//	public Map checkId(String userId) {	
		
		
		Member m = service.selectMember(userId);
		
		List<Board> list = boardservice.selectBoard(1, 5);
		
		boolean flag = m != null?false:true;
		
		Map<String, Object> map = new HashedMap();
		map.put("board", list);
		map.put("member", m);
		map.put("flag", flag);
		
		return flag;
//		return m; //이것도 response로 넘길 수 있다(javascript 객체로)
//		return list;
//		return map;
	}
	
}
