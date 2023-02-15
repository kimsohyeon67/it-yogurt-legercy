package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.QuizDTO;

public interface QuizService {
	void uploadContents (QuizDTO dto);
	
	List<QuizDTO> quiz(int knowSeq);
	
}
