package com.starters.ityogurt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.KnowledgeDTO;

@Mapper
@Repository
public interface KnowledgeDAO {

	List<KnowledgeDTO> list(@Param("userSeq")int userSeq, @Param("limit")int limit);

	int totalCnt(int userSeq);

	String contents(int knowSeq);

	String title(int knowSeq);
	
	void uploadKnowledge(KnowledgeDTO dto);
	
}
