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
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.KnowledgeService;
import com.starters.ityogurt.service.QuizService;
import com.starters.ityogurt.service.UserService;

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

	 @GetMapping("/page")  //관리자 마이페이지
	    public String admin() {
	        return "admin/adminPage";
	    }
	 @GetMapping(value ={"/user","/user/" ,"/user/{userpage}"})  // 관리자 회원 조회 
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
		 	int totalCnt = userService.countAllUser();
		 	List<UserDTO> userList = userService.getAllUserlistLimit(limit);
		 	mv.addObject("totalCnt", totalCnt);
		 	mv.addObject("userList", userList);
		 	mv.setViewName("admin/adminUser");
		 	return mv;
	    }
	 
	 @GetMapping("/user/manage/{userseq}")
	 public String deleteUser(@PathVariable("userseq") int userSeq) {
		 userService.deleteUser(userSeq);
		 return "redirect:/admin/user/1";
	 }
	 
	 @GetMapping("/contents") // 컨텐츠 업로드 화면
	    public ModelAndView adminContents() {
		 	ModelAndView mv = new ModelAndView();
		 	int knowSeq = knowledgeService.totalCnt() + 1;
		 	mv.addObject("knowSeq", knowSeq);
		 	mv.setViewName("admin/adminContents");
	        return mv; 
	    }
	 
	 @PostMapping("/contents") // 컨텐츠 업로드 
	 	public ModelAndView uploadContents(QuizDTO quizDto, KnowledgeDTO knowledgeDto) {
		 	ModelAndView mv = new ModelAndView();
		 	knowledgeService.uploadKnowledge(knowledgeDto);
		 	quizService.uploadQuiz(quizDto);
		 	mv.setViewName("redirect:page");
		 	return mv;
	 }
	 
}
