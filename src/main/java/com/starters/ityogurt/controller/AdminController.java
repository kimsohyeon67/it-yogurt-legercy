package com.starters.ityogurt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.service.QuizService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("quizservice")
	QuizService service;

	 @GetMapping("/page")
	    public String admin() {
	        return "admin/adminPage";
	    }
	 @GetMapping("/user")
	    public String adminUser() {
	        return "admin/adminUser";
	    }
	 @GetMapping("/contents")
	    public String adminContents() {
	        return "admin/adminContents";
	    }
	 
	 @PostMapping("/contents")
	 	public ModelAndView UploadContents(QuizDTO dto) {
		 	ModelAndView mv = new ModelAndView();
		 	service.uploadContents(dto);
		 	mv.setViewName("redirect:page");
		 	return mv;
	 }
}
