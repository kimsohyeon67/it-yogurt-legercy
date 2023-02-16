package com.starters.ityogurt.service;

import java.util.List;
import java.util.Map;

import com.starters.ityogurt.dto.BoardDTO;

public interface BoardService {
	
	List<Map<String,String>> getBoardJoinUser(int limit);
	
	int countAllBoard();

}
