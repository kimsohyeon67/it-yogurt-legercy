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
	public List<KnowledgeDTO> getList(int userSeq, int limit) {
		return dao.getList(userSeq, limit);
	}

	@Override
	public int getTotalCnt() {
		return dao.getTotalCnt();
	}

	@Override
	public String getContents(int knowSeq) { return dao.getContents(knowSeq); }

	@Override
	public String getTitle(int knowSeq) {
		return dao.getTitle(knowSeq);
	}
	
	@Override
	public void uploadKnowledge(KnowledgeDTO dto) {
		dao.uploadKnowledge(dto);
	}

	@Override
	public void viewCnt(int knowSeq) {
		dao.viewCnt(knowSeq);
	}

	@Override
	public List<KnowledgeDTO> getSearchList(String keyword) {
		return dao.getSearchList(keyword);
	}

  @Override
	public KnowledgeDTO getKnowledgeByCategorySeq(int categorySeq) {
		return dao.getKnowledgeByCategorySeq(categorySeq);
	}


}
