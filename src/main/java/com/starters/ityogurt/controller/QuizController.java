package com.starters.ityogurt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dao.QuizDAO;
import com.starters.ityogurt.dto.LearnRecordDTO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.service.LearnRecordService;
import com.starters.ityogurt.service.QuizService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class QuizController {

	@Autowired
	QuizDAO dao;
	@Autowired
	@Qualifier("quizservice")
	QuizService service;
	
	@Autowired
	@Qualifier("learnrecordservice")
	LearnRecordService learnRecordService;
	
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
	public ModelAndView answer(int knowSeq, HttpServletRequest request, int radio1, int radio2,
			int radio3) {
		ModelAndView mv = new ModelAndView();
		//quiz번호들 저장하기
		String[] s1 = request.getParameterValues("quizSeq");
		int[] quizSeq = new int[s1.length]; 
		for(int i = 0;i<quizSeq.length;i++) {
			quizSeq[i]=Integer.parseInt(s1[i]);
		}
		
		//정답 가져오기
		int[] userChoice = {radio1,radio2,radio3};
		int[] answer = new int[3];
		for(int i=0;i<userChoice.length;i++) {
			answer[i] = service.getAnswer(quizSeq[i]);			
		}
		
		//user 입력 답이랑 정답 비교해서 정답이면 1, 오답이면 0
		int[] isRight = new int[3];
		for(int i=0;i<isRight.length;i++) {
			if(userChoice[i] == answer[i]) {
				isRight[i] = 1;							
			}else {
				isRight[i] = 0;
			}
		}
		
		//leanrRecord 테이블 insert
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		for(int i=0;i<userChoice.length;i++) { //일단 나중에 다시 구현 
			learnRecordService.learnData(userChoice[i], isRight[i], userSeq, quizSeq[i]);
		}
		
		//답 보여줘야 하니 learn_record 불러오기
		List<LearnRecordDTO> learnList = learnRecordService.getLearn(quizSeq[0],quizSeq[1],quizSeq[2]);
		
		//퀴즈 내용 불러와야 하니까 리스트 가져옴
		List<QuizDTO> quizList = service.quiz(knowSeq);
		
		mv.addObject("quizList", quizList);
		mv.addObject("learnList", learnList);
		request.setAttribute("quizList", quizList);
		
		
		
//		String[] chk1 = request.getParameterValues("chk");
//		int[] chk = new int[chk1.length]; 
		
//		for(int i = 0;i<quizSeq.length;i++) {
//			quizSeq[i]=Integer.parseInt(s1[i]);
//		}
//		for(int i:chk) {
//			System.out.println("선택한 보기 값: "+i);
//		}
//	
//		for(int a : quizSeq) {
//			System.out.println(a);
//		}
		
		
//		System.out.println(quizSeq);
//		System.out.println(userSeq);
//		for(int a : check) {
//			System.out.println(a);
//		}
		
		mv.setViewName("quiz/answer");
		return mv;
	}
	
}
