package com.starters.ityogurt.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.ityogurt.dao.BoardDAO;
import com.starters.ityogurt.dto.BoardDTO;
import com.starters.ityogurt.service.BoardService;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;

	@Override
	public List<BoardDTO> getBoardlistLimit(int limit) {
		return dao.getBoardlistLimit(limit);
	}

	@Override
	public int countAllBoard() {
		return dao.countAllBoard();
	}
	
	
}
