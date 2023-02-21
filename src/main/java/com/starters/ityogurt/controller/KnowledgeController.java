package com.starters.ityogurt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


//	@RequestMapping(value = "/list/{page}", method = { RequestMethod.GET })	
//	@GetMapping("/list/{page}") //매일지식 list 불러오기
//	public ModelAndView list(@PathVariable("page") int page) {
//		ModelAndView mv = new ModelAndView();
//		int userSeq = 2;
//		int limit = (page - 1) * 9; // page처리 위해서
//		int totalCnt = service.getTotalCnt(); // 매일지식 몇 개인지 불러오기
//        List<KnowledgeDTO> knowledgeList = service.getList(userSeq,limit);
//        mv.addObject("knowledgeList", knowledgeList);
//        mv.addObject("totalCnt",totalCnt);
//        mv.setViewName("knowledge/list");
//		
//		return mv;
//	}
//	ajax 테스트용
//	@GetMapping("/list/{page}") //매일지식 list 불러오기
//	@ResponseBody
//	public List<KnowledgeDTO> list(@PathVariable("page") int page) {
//		JSONObject jsonObj = new JSONObject();
//		int userSeq = 2;
//		int limit = (page - 1) * 9; // page처리 위해서
//		int totalCnt = service.getTotalCnt(); // 매일지식 몇 개인지 불러오기
//        List<KnowledgeDTO> knowledgeList = service.getList(userSeq,limit);
//        jo.add("knowledgeList", (JsonElement) knowledgeList);
//        jo.add("totalCnt",totalCnt);
//        jo.setViewName("knowledge/list");
//        System.out.println(totalCnt);
//        jsonObj.put("knowledgeList", knowledgeList);
////        jsonObj.put("totalCnt", totalCnt);
//        
//		return knowledgeList;
////        return jsonObj;
//	}
	
	@GetMapping("/list/{page}") //매일지식 list 불러오기
	@ResponseBody
	public Map<String, Object> list2(@PathVariable("page") int page) {
	    Map<String, Object> result = new HashMap<>();
	    int userSeq = 2;
	    int limit = (page - 1) * 9; // page처리 위해서
	    int totalCnt = service.getTotalCnt(); // 매일지식 몇 개인지 불러오기
	    List<KnowledgeDTO> knowledgeList = service.getList(userSeq,limit);
	    result.put("knowledgeList", knowledgeList);
	    result.put("totalCnt", totalCnt);
	    return result;
	}
	
	
//	@GetMapping("/list2/{page}") //매일지식 list 불러오기
//	@ResponseBody
//	public Map<String, Object> list(@PathVariable("page") int page) {
//	    Map<String, Object> result = new HashMap<>();
//	    JSONObject jsonObj = new JSONObject();
//	    int userSeq = 2;
//	    int limit = (page - 1) * 9; // page처리 위해서
//	    int totalCnt = service.getTotalCnt(); // 매일지식 몇 개인지 불러오기
//	    List<KnowledgeDTO> knowledgeList = service.getList(userSeq,limit);
//	    result.put("knowledgeList", knowledgeList);
//	    result.put("totalCnt", totalCnt);
//	    return result;
//	}
	
	@GetMapping("/list2/{page}") //매일지식 list 불러오기
	public ModelAndView list23(@PathVariable("page") int page) {
		ModelAndView mv = new ModelAndView();
		int userSeq = 2;
		int limit = (page - 1) * 9; // page처리 위해서
		int totalCnt = service.getTotalCnt(); // 매일지식 몇 개인지 불러오기
        List<KnowledgeDTO> knowledgeList = service.getList(userSeq,limit);
        mv.addObject("knowledgeList", knowledgeList);
        mv.addObject("totalCnt",totalCnt);
        mv.setViewName("knowledge/list");
		return mv;
	}
	
	@GetMapping("/detail/{knowSeq}") //매일지식 폼 확인
	public ModelAndView detail(@PathVariable("knowSeq") int knowSeq) {
		ModelAndView mv = new ModelAndView();
		String title = service.getTitle(knowSeq);
		String contents = service.getContents(knowSeq);
        service.viewCnt(knowSeq);
		mv.addObject("knowSeq",knowSeq);
		mv.addObject("title",title);
		mv.addObject("contents",contents);
		mv.setViewName("knowledge/detail");
		return mv;
	}
	
//	@GetMapping("/quiz") //매일지식 폼 확인
//	public String quiz() {
//		return "quiz/list";
//	}
	
	@RequestMapping("searchResult")
	public ModelAndView searchResult(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<KnowledgeDTO> list = service.getSearchList(keyword);
		System.out.println(list);
		
		mv.addObject("list", list);
		mv.setViewName("knowledge/searchResult");
		return mv;
	}
	
	
	
}








