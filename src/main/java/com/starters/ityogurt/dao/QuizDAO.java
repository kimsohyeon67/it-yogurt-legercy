package com.starters.ityogurt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.QuizDTO;

@Mapper
@Repository
public interface QuizDAO {
	void uploadQuiz(QuizDTO dto);
}
