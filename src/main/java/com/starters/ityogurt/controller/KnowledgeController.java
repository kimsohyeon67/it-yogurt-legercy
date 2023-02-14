package com.starters.ityogurt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dao.KnowledgeDAO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.service.KnowledgeService;

@Controller
public class KnowledgeController {

	@Autowired
	KnowledgeDAO dao;
	@Autowired
	@Qualifier("knowledgeservice")
	KnowledgeService service;

//	@GetMapping("/list") //매일지식 폼 확인
//	public String list1() {
//		return "knowledge/list";
//	}

	@GetMapping("/list") //매일지식 list 불러오기
	public ModelAndView list2(int page) {
		ModelAndView mv = new ModelAndView();
//      KnowledgeDTO dto = service.getOneNovel(id);
		int userSeq = 2;
		int limit = (page - 1) * 9; // page처리 위해서
		int totalCnt = service.totalCnt(userSeq); // 매일지식 몇 개인지 불러오기
        List<KnowledgeDTO> knowledgeList = service.list(userSeq,limit);
        mv.addObject("knowledgeList", knowledgeList);
        mv.addObject("totalCnt",totalCnt);
        mv.setViewName("knowledge/list");
		
		return mv;
	}
	
	@GetMapping("/detail") //매일지식 폼 확인
	public ModelAndView detail(int knowSeq) {
		ModelAndView mv = new ModelAndView();
		String contents = service.contents(knowSeq);
		mv.addObject("contents",contents);
		mv.setViewName("knowledge/detail");
		return mv;
	}
	
	
	
	
	
	
	
	
}








