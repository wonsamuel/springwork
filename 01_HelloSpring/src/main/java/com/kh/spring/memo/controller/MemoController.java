package com.kh.spring.memo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

@Controller
public class MemoController {

	@Autowired
	private MemoService service;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memoList(ModelAndView mv) { /* modelandview가 같이 있는 객체 */
		
		List<Map<String, String>> memos = service.selectMemo();
		//객체 넣기
		mv.addObject("list",memos);
		//화면
		mv.setViewName("memo/memoList");
		return mv;
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public ModelAndView insertMemo(ModelAndView mv, @RequestParam Map<String,String> map) {
		
		int result = service.insertMemo(map);
		
		mv.setViewName("redirect:/memo/memo.do");
		
		return mv;
	}
}
