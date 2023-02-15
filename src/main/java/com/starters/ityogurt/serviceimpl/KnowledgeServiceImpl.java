package com.starters.ityogurt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.ityogurt.dao.KnowledgeDAO;
import com.starters.ityogurt.dao.QuizDAO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.QuizDTO;
import com.starters.ityogurt.service.KnowledgeService;


@Service("knowledgeservice")
public class KnowledgeServiceImpl implements KnowledgeService{

	@Autowired
    KnowledgeDAO dao;
	
	@Override
	public List<KnowledgeDTO> list(int userSeq, int limit) {
		return dao.list(userSeq, limit);
	}

	@Override
	public int totalCnt() {
		return dao.totalCnt();
	}

	@Override
	public String contents(int knowSeq) {
		return dao.contents(knowSeq);
	}

	@Override
	public String title(int knowSeq) {
		return dao.title(knowSeq);
	}



}
