package com.starters.ityogurt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView quiz(int knowSeq) {
		ModelAndView mv = new ModelAndView();
		List<QuizDTO> quizList = service.getQuiz(knowSeq);
		mv.addObject("quizList", quizList);
		mv.setViewName("quiz/list");		
		return mv;
	}
	
	//정답 페이지 보여주기(insert 관련)
	@PostMapping("/answer") 
	public String answer(int knowSeq, HttpServletRequest request, int radio1, int radio2,
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
				System.out.println(isRight[i]);
			}else {
				isRight[i] = 0;
				System.out.println(isRight[i]);
			}
		}
		
		//이미 insert된 내용이 있는지 확인하기
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		int choiceRecord = learnRecordService.getUserChoice(userSeq, quizSeq[0], quizSeq[1], quizSeq[2]); //해당 유저 번호의 총 갯수 가져오기
		System.out.println("유저 푼 문제 수"+choiceRecord);
		
		// 0보다 크면 update 진행, 아니면 insert 진행
		if(choiceRecord == 0) {//insert
			//leanrRecord 테이블 insert
			for(int i=0;i<userChoice.length;i++) { 
				learnRecordService.learnData(userChoice[i], isRight[i], userSeq, quizSeq[i]);
			}			
		}else {//update
			for(int i=0;i<userChoice.length;i++) { 
				learnRecordService.updateLearnData(userChoice[i], isRight[i], userSeq, quizSeq[i]);
			}
		}
		
		// 새로운 페이지로 redirect, 대신 필요한 값들 모두 url에 전달해주기
		return "redirect:/answerResult?quizSeq="+quizSeq[0]+"&quizSeq="+quizSeq[1]+"&quizSeq="+quizSeq[2]+"&knowSeq="+knowSeq;
	}

	//정답 보여주기(가져와서 보여주기)
	@GetMapping("/answerResult")
	public ModelAndView answerResult(int[] quizSeq, int knowSeq) {
		ModelAndView mv = new ModelAndView();
		//답 보여줘야 하니 learn_record 불러오기
		List<LearnRecordDTO> learnList = learnRecordService.getLearn(quizSeq[0],quizSeq[1],quizSeq[2]);
		for(LearnRecordDTO d:learnList) {
			System.out.println("퀴즈번호"+d.getQuizSeq());
			System.out.println("유저 선택"+d.getUserChoice());
		}
		
		//퀴즈 내용 불러와야 하니까 리스트 가져옴
		List<QuizDTO> quizList = service.getQuiz(knowSeq);
		mv.addObject("quizList", quizList);
		mv.addObject("learnList", learnList);
//		mv.addObject("isRight1",learnList.get(0).getIsRight());
//		mv.addObject("isRight2",learnList.get(1).getIsRight());
//		mv.addObject("isRight3",learnList.get(2).getIsRight());
//		mv.addObject("userChoice1",learnList.get(0).getUserChoice());
//		mv.addObject("userChoice2",learnList.get(1).getUserChoice());
//		mv.addObject("userChoice3",learnList.get(2).getUserChoice());
		mv.setViewName("quiz/answer");
		return mv;
	}
	
	
	
	
}
