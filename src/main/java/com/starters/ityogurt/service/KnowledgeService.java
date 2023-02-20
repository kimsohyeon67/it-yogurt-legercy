package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.QuizDTO;

public interface KnowledgeService {

	List<KnowledgeDTO> getList(int userSeq, int limit);

	int getTotalCnt();

	String getContents(int knowSeq);

	String getTitle(int knowSeq);

	void uploadKnowledge(KnowledgeDTO dto);

	void viewCnt(int knowSeq);


}
