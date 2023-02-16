package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.BoardDTO;

public interface BoardService {
	
	List<BoardDTO> getBoardlistLimit(int limit);
	
	int countAllBoard();

}
