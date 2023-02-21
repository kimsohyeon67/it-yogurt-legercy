package com.starters.ityogurt.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.starters.ityogurt.dto.BoardDTO;
import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.service.BoardService;
import com.starters.ityogurt.service.CategoryService;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Criteria;
import com.starters.ityogurt.util.Paging;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("boardservice")
	BoardService boardService;
	
	@Autowired
	@Qualifier("userservice")
	UserService userService;
	
	@Autowired
	@Qualifier("categoryservice")
	CategoryService categoryService;
	
	

	//게시판 리스트 화면
		 @GetMapping(value = { "/list"})  
		    public ModelAndView boardList(Criteria cri) throws Exception {
				ModelAndView mv = new ModelAndView();
				//paging
				Paging paging = new Paging();
				paging.setCri(cri); // 현재 페이지, 페이지당 보여줄 게시글의 개수 설정
				int totalBoardCnt = boardService.countAllBoard(); // 전체 게시글 수
				int maxPage = (int)((double)totalBoardCnt / cri.getPerPageNum() + 0.9); // 전체 페이지 수
				paging.setTotalCount(totalBoardCnt); //전체 게시글 수 설정
				List<Map<String,String>> boardlist = boardService.getBoardJoinUser(cri); // 게시글 데이터 가져오기
				mv.addObject("maxpage", maxPage);
			 	mv.addObject("paging", paging);
			 	mv.addObject("boardList", boardlist);
			 	mv.setViewName("board/boardList");
			 	return mv;
		 
		    }	
		 //게시판 리스트 화면 ajax
		 @GetMapping(value = { "/list/a"}) 
		 @ResponseBody
		 public JSONObject boardListAjax(Criteria cri) throws Exception {
			 Paging paging = new Paging();
			 JSONObject jsonObjBoard = new JSONObject();
			 paging.setCri(cri); // 현재 페이지, 페이지당 보여줄 게시글의 개수
			 int totalBoardCnt = boardService.countAllBoard(); // 전체 게시글 수
			 int maxPage = (int)((double)totalBoardCnt / cri.getPerPageNum() + 0.9); // 전체 페이지 수
			 paging.setTotalCount(totalBoardCnt);
			 List<Map<String,String>> boardlist = boardService.getBoardJoinUser(cri); // 게시글 데이터 가져오기
			 jsonObjBoard.put("maxPage", maxPage);
			 jsonObjBoard.put("paging", paging);
			 jsonObjBoard.put("boardList", boardlist);
			 return jsonObjBoard;
			 
		 }	
	 
	 //게시판 글 화면
	 @GetMapping("/{boardSeq}")
	 public ModelAndView boardlisttest(@PathVariable("boardSeq") int boardSeq) {
		 ModelAndView mv = new ModelAndView();
		 int limit =0;
		 boardService.viewCntBoard(boardSeq);
		 Map<String,String> oneBoard = boardService.getOneBoardJoinUser(boardSeq);
		 // 해당 글의 카테고리 번호
		 String categorySeq = String.valueOf(oneBoard.get("category"));
		 CategoryDTO categoryInfo = categoryService.getCategoryByCategorySeq(categorySeq);
		 
		 mv.addObject("categoryInfo", categoryInfo);
		 mv.addObject("oneBoard", oneBoard);
		 mv.setViewName("board/boardDetail");
		 return mv;
	 }
	 
	 
	 //게시글 업로드 폼
	 @GetMapping("/form")
	 public String boardInsertForm() {
		return "board/boardForm";
	 }
	 
	 //게시글 업로드
	 @PostMapping("/form")
	 public ModelAndView insertBoard(BoardDTO boardDto) {
		 ModelAndView mv = new ModelAndView();
		 boardService.insertBoard(boardDto);
		 mv.setViewName("redirect:list");
		 return mv;
	 }
	 
	 //게시글 수정
	 @GetMapping("/form/{boardseq}")
	 public ModelAndView uploadBaordForm(BoardDTO boardDto, @PathVariable("boardseq") int boardSeq) {
		 ModelAndView mv = new ModelAndView();
		 
		 Map<String,String> oneBoard = boardService.getOneBoardJoinUser(boardSeq);
		 mv.addObject("oneBoard", oneBoard);
		 mv.setViewName("board/boardUpdateForm");
		 return mv;
	 }
	
	 @PostMapping("/form/{boardseq}")
	 public ModelAndView uploadBoard(BoardDTO boardDto,  @PathVariable("boardseq") int boardSeq) {
		 ModelAndView mv = new ModelAndView();
		 boardDto.setBoardSeq(boardSeq);
		 boardService.updateBoard(boardDto);
		 mv.setViewName("redirect:/board/list");
		 return mv;
	 }
	
	 
}
