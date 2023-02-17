package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.QuizDTO;

public interface KnowledgeService {

	List<KnowledgeDTO> list(int userSeq, int limit);

	int totalCnt();

	String contents(int knowSeq);

	String title(int knowSeq);

	void uploadKnowledge(KnowledgeDTO dto);

	void viewCnt(int knowSeq);


}
