package com.starters.ityogurt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.BoardDTO;

@Mapper
@Repository
public interface BoardDAO {
	
	List<Map<String,String>> getBoardJoinUser(int limit);
	
	Map<String,String> getOneBoardJoinUser(int boardSeq);

	int countAllBoard();
	
}
