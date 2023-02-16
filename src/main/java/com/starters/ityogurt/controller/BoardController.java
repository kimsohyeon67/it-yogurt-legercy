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

import com.starters.ityogurt.dto.BoardDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("boardservice")
	BoardService boardService;
	
	@GetMapping("/list")
		public ModelAndView boardlisttest() {
			ModelAndView mv = new ModelAndView();
			int limit =10;
			List<BoardDTO> boardlist = boardService.getBoardlistLimit(limit);
			
			mv.addObject("boardList", boardlist);
			mv.setViewName("board/boardList");
			return mv;
	}
	

	//게시판 리스트 화면
	 @GetMapping(value = { "/list/", "/list/{boardpage}"})  
	    public ModelAndView boardList(@PathVariable(value = "boardpage", required=false) Optional<String> boardPage) {
			ModelAndView mv = new ModelAndView();
			int bordPageInt=0;
			if (boardPage!=null) {
				bordPageInt =Integer.parseInt(boardPage.get()) ;
			}
			else {
				bordPageInt= 1;
			}
			int limit = (bordPageInt- 1) * 10;
			int totalBoardCnt = boardService.countAllBoard();
			System.out.println(totalBoardCnt);
		 	List<BoardDTO> boardlist = boardService.getBoardlistLimit(limit);
		 	
		 	mv.addObject("totalBoardCnt", totalBoardCnt);
		 	mv.addObject("boardList", boardlist);
		 	mv.setViewName("board/boardList");
		 	return mv;
	 
	    }
	
	 
}
