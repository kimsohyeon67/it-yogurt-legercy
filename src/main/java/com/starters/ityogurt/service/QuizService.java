package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.QuizDTO;

public interface QuizService {

	List<QuizDTO> quiz(int knowSeq);

	void uploadQuiz (QuizDTO dto);
	
}
