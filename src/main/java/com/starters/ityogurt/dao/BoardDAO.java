package com.starters.ityogurt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.BoardDTO;

@Mapper
@Repository
public interface BoardDAO {
	
	List<BoardDTO> getBoardlistLimit(int limit);

	int countAllBoard();
	
}
