package com.starters.ityogurt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dao.QuizDAO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.service.QuizService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class QuizController {

	@Autowired
	QuizDAO dao;
	@Autowired
	@Qualifier("quizservice")
	QuizService service;
	
	@GetMapping("/quiz") //매일지식 폼 확인
	public ModelAndView quiz(int knowSeq, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<QuizDTO> quizList = service.quiz(knowSeq);
		mv.addObject("quizList", quizList);
		request.setAttribute("quizList", quizList);
		mv.setViewName("quiz/list");
//		
		return mv;
	}
	
	@GetMapping("/answer") 
	public ModelAndView answer( int knowSeq, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String[] s1 = request.getParameterValues("quizSeq");
		int[] quizSeq = new int[s1.length]; 
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		String[] chk1 = request.getParameterValues("chk");
		int[] chk = new int[chk1.length]; 
		
		for(int i = 0;i<quizSeq.length;i++) {
			quizSeq[i]=Integer.parseInt(s1[i]);
		}
		for(int i:chk) {
			System.out.println("선택한 보기 값: "+i);
		}
	
		for(int a : quizSeq) {
			System.out.println(a);
		}
		
		
//		System.out.println(quizSeq);
//		System.out.println(userSeq);
//		for(int a : check) {
//			System.out.println(a);
//		}
		
		mv.setViewName("quiz/list");
		return mv;
	}
	
}
