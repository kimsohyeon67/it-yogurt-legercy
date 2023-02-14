package com.starters.ityogurt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.ityogurt.dao.QuizDAO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.service.QuizService;

@Service("quizservice")
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizDAO dao;
	
	@Override
	public void uploadContents(QuizDTO dto) {
		dao.uploadContents(dto);
		
	}
	
}
