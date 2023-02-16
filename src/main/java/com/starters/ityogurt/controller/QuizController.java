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
	public ModelAndView quiz(int knowSeq) {
		ModelAndView mv = new ModelAndView();
		List<QuizDTO> quizList = service.quiz(knowSeq);
		mv.addObject("quizList", quizList);
		mv.setViewName("quiz/list");
//		
		return mv;
	}
	
	@GetMapping("/answer") 
	public ModelAndView answer(int[] check, int knowSeq, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int quizSeq = Integer.parseInt(request.getParameter("quizSeq"));
		System.out.println(quizSeq);
//		for(int a : check) {
//			System.out.println(a);
//		}
		mv.setViewName("quiz/list");
		return mv;
	}
	
}
