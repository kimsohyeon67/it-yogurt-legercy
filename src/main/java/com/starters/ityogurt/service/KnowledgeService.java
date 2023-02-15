package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.KnowledgeDTO;

public interface KnowledgeService {

	List<KnowledgeDTO> list(int userSeq, int limit);

	int totalCnt(int userSeq);

	String contents(int knowSeq);

	String title(int knowSeq);
	
	void uploadKnowledge(KnowledgeDTO dto);
}
