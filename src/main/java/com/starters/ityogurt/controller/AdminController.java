package com.starters.ityogurt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.BlacklistService;
import com.starters.ityogurt.service.BoardService;
import com.starters.ityogurt.service.CommentService;
import com.starters.ityogurt.service.KnowledgeService;
import com.starters.ityogurt.service.LearnRecordService;
import com.starters.ityogurt.service.QuizService;
import com.starters.ityogurt.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("quizservice")
	QuizService quizService;
	
	@Autowired
	@Qualifier("knowledgeservice")
	KnowledgeService knowledgeService;
	
	@Autowired
	@Qualifier("userservice")
	UserService userService;

	@Autowired
	@Qualifier("blacklistservice")
	BlacklistService blacklistService;
	
	@Autowired
	@Qualifier("boardservice")
	BoardService boardService;
	
	@Autowired
	@Qualifier("commentservice")
	CommentService commentService;
	
	@Autowired
	@Qualifier("learnrecordservice")
	LearnRecordService learnRecordService;
	
	

	//관리자 마이페이지
	 @GetMapping("/page")
	    public String admin() {
	        return "admin/adminPage";
	    }

	// 관리자 회원 조회
	 @GetMapping(value ={"/user","/user/" ,"/user/{userpage}"})
	    public ModelAndView adminUser(@PathVariable(value = "userpage", required=false) Optional<String> userPage) {
		 	ModelAndView mv = new ModelAndView();
		 	int pageInt=0;
		 	if (userPage!=null) {
		 		pageInt =Integer.parseInt(userPage.get()) ;
		 	}
		 	else {
		 		pageInt= 1;
		 	}
		 	
		 	int limit = (pageInt- 1) * 10;
		 	int totalUserCnt = userService.countAllUser();
		 	List<UserDTO> userList = userService.getAllUserlistLimit(limit);
		 	mv.addObject("totalUserCnt", totalUserCnt);
		 	mv.addObject("userList", userList);
		 	mv.setViewName("admin/adminUser");
		 	return mv;
	    }

	 //관리자가 유저 탈퇴 시키기
	 @GetMapping("/user/manage/{userseq}")
	 public String deleteUser(@PathVariable("userseq") int userSeq) {
		 commentService.deleteComment(userSeq);
		 boardService.deleteBoard(userSeq);
		 learnRecordService.deleteLearnData(userSeq);
		 userService.deleteUser(userSeq);
		 return "redirect:/admin/user/1";
	 }

	 //관리자가 유저 블랙
	 @GetMapping("/user/manage/{userseq}/{email}")
	 public String blackUser(@PathVariable("userseq") int userSeq, @PathVariable("email") String email) {
		 blacklistService.insertBlackUser(email);
		 commentService.deleteComment(userSeq);
		 boardService.deleteBoard(userSeq);
		 learnRecordService.deleteLearnData(userSeq);
		 userService.deleteUser(userSeq);
		 return "redirect:/admin/user/1";
	 }



	 //컨텐츠 업로드 화면
	 @GetMapping("/contents")
	    public ModelAndView adminContents() {
		 	ModelAndView mv = new ModelAndView();
		 	int knowSeq = knowledgeService.getTotalCnt() + 1;
		 	mv.addObject("knowSeq", knowSeq);
		 	mv.setViewName("admin/adminContents");
	        return mv; 
	    }

	 //컨텐츠 업로드
   @PostMapping("/contents")
	  	public ModelAndView UploadContents(QuizDTO quizDto, KnowledgeDTO knowledgeDto) {
		 	ModelAndView mv = new ModelAndView();
		 	knowledgeService.uploadKnowledge(knowledgeDto);
		 	quizService.uploadQuiz(quizDto);
		 	mv.setViewName("redirect:page");
		 	return mv;
	 }
}
