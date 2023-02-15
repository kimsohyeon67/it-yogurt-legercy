package com.starters.ityogurt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.QuizDTO;

@Mapper
@Repository
public interface QuizDAO {
	void uploadContents(QuizDTO dto);
	
	List<QuizDTO> quiz(int knowSeq);



}
